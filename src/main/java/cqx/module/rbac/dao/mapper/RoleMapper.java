package cqx.module.rbac.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import cqx.module.rbac.daomain.Role;
import cqx.module.rbac.daomain.UserRole;

/**
 * @author cqx
 * @date 2018/1/10 15:49
 */
@Repository
public interface RoleMapper {

    /*获取角色列表*/
    List<Role> getRoleList();

    /*根据某个用户获取全部角色*/
    List<Role> queryRoleByUser(@Param("uid") int uid);

    /*加载用户的UserRole对象*/
    UserRole loadUserRole(@Param("uid") int uid,@Param("roleId") int roleId);

    /*增加用户角色*/
    void addUserRole(@Param("uid") int uid,@Param("roleId") int roleId);

    /*删除用户角色*/
    void deleteUserRole(@Param("uid") int uid,@Param("roleId") int roleId);

    /*删除某个用户的全部角色*/
    void deleteUserRoleByUser(@Param("uid") int uid);

    void addRole(@Param("role") Role role);

    void deleteRole(@Param("id") int id);

    /*删除用户时,删除user--role中的与此id有关的role*/
    void deleteUserRoleByRole(@Param("roleId") int roleId);

    /*更新角色*/
    void updateRole(@Param("role") Role role);

    /*根据id获得角色*/
    Role queryRoleById(@Param("id")int id);





















}
