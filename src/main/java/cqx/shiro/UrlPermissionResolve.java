package cqx.shiro;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;


/**
 * @author cqx
 * @date 2018/1/10 15:11
 * 将user/* 处理为 user:*
 */
public class UrlPermissionResolve implements PermissionResolver{

    public Permission resolvePermission(String permissionString) {
        if(permissionString.startsWith("/")){
            return new UrlPermission(permissionString);
        }else{
            return new WildcardPermission(permissionString);
        }
    }
}
