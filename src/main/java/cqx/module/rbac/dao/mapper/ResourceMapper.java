package cqx.module.rbac.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import cqx.module.rbac.daomain.Resource;
import cqx.module.rbac.daomain.RoleResource;

/**
 * @author cqx
 * @date 2018/1/10 16:30
 */
@Repository
public interface ResourceMapper {

    /* 获取资源列表*/
    List<Resource> getResourceList();

    /*根据角色id获取他可以访问的全部资源*/
    List<Resource> queryResourceByRole(@Param("roleId") int roleId);

    /*根据用户据id获取该用户可以访问的资源*/
    List<Resource> queryResourceByUser(@Param("uid") int uid);

    /*zengjia角色资源*/
    void addRoleResource(@Param("roleId")int roleId, @Param("resId")int resId);

    /*删除角色资源*/
    void delRoleResource(@Param("roleId")int roleId, @Param("resId")int resId);

    void delResResourceByRole(@Param("roleId")int roleId);

    /*加载角色资源*/
    RoleResource loadRoleResource(@Param("roleId")int roleId, @Param("resId") int resId);

    /*增加资源*/
    void addRes(@Param("res")Resource res);

    /*删除资源*/
    void deleteRes(@Param("id")int id);

    /*删除资源 shi删除rr表中与次资源有关的*/
    void deletetRoleResByRes(@Param("resId")int resId);

    /*更新资源*/
    void updateRes(@Param("res")Resource res);

    /*根据id得到资源*/
    Resource queryResById(@Param("id")int id);
}
