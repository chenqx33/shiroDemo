package cqx.module.rbac.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cqx.module.rbac.daomain.User;
import cqx.module.rbac.service.RoleService;
import cqx.module.rbac.service.UserService;

/**
 * @author cqx
 * @date 2018/1/10 17:01
 */
@RestController
@RequestMapping("/rest/user")
public class UserRestController {

    private Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;




    @RequestMapping(value = "/checkNameUnique",method = RequestMethod.POST)
    public boolean checkNameUnique(String username){
        User user = userService.queryUserByName(username);
        if (user == null){
            logger.info("可添加");
            return true;
        }else {
            logger.info("不可添加");
            return false;
        }
    }

}
