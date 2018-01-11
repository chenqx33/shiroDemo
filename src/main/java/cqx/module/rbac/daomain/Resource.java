package cqx.module.rbac.daomain;

import java.util.List;

/**
 * @author cqx
 * @date 2018/1/10 15:34
 */
public class Resource {
    private Integer id;
    private String permission;
    private String name;
    private String url;

    /*记录那些角色拥有这个权限*/
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
