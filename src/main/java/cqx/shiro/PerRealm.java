package cqx.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import cqx.module.rbac.daomain.Resource;
import cqx.module.rbac.daomain.User;
import cqx.module.rbac.service.ResourceService;
import cqx.module.rbac.service.RoleService;
import cqx.module.rbac.service.UserService;

/**
 * @author cqx
 * @date 2018/1/10 15:30
 */



public class PerRealm extends AuthorizingRealm{
    private Logger logger = LoggerFactory.getLogger(PerRealm.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;

    /*授权管理*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        User user = userService.queryUserByName(username);
        int uid = user.getId();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        logger.info("用户[{}]进入授权验证",username);
        try {
            List<Resource> resources = resourceService.queryResourceByUser(uid);
            List<String> permissions = new ArrayList<String>();
            for (Resource res : resources) {
                permissions.add(res.getUrl());
            }

            info.setStringPermissions(new HashSet<String>(permissions));
            logger.info("用户[{}]授权认证完成", username);
            return info;
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /*登录验证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        String password = new String((char[]) token.getCredentials());
        String md5Pwd = ShiroKit.md5Pwd(password, username);
        logger.info("用户[{}]进入登录验证", username);
        User user = userService.queryUserByName(username);

        if (user == null) {
            throw new UnknownAccountException("用户名不存在");
        } else {
            if (!user.getPassword().equals(md5Pwd)) {
                throw new IncorrectCredentialsException("密码错误");
            }
            if (user.getStatus().equals("0")) {
                throw new LockedAccountException("用户账号已被锁定");
            }
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, this.getName());

        /**
         * 很大的疑惑这个
         *   info.setCredentialsSalt(ByteSource.Util.bytes(password));
         *   应该是设置username这个盐值得可是设置就会出错
         *   设置成password就没问题
         */
        info.setCredentialsSalt(ByteSource.Util.bytes(password));
        logger.info("用户[{}]进入登录验证成功", username);
        return info;
    }
}


























