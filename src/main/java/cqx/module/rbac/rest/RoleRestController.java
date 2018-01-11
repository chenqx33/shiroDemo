package cqx.module.rbac.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cqx.module.rbac.service.ResourceService;

/**
 * @author cqx
 * @date 2018/1/10 17:01
 */
@RestController
@RequestMapping("/rest/role")
public class RoleRestController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/res/update",method = RequestMethod.POST)
    public String updateRes(int aOrd, int roleId,int resId) {
        if (aOrd == 0){
            resourceService.delRoleResource(roleId,resId);
        }else {
            resourceService.addRoleResource(roleId,resId);
        }
        return "redirect:/role/list";
    }
}
