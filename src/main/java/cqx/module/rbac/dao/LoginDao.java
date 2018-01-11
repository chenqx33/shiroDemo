package cqx.module.rbac.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cqx.module.rbac.dao.mapper.UserMapper;
import cqx.module.rbac.daomain.User;

/**
 * @author cqx
 * @date 2018/1/10 16:33
 */
@Repository
public class LoginDao {
    private Logger logger = LoggerFactory.getLogger(LoginDao.class);

    @Autowired
    private UserMapper mapper;
    public User queryUserByName(String username){
        try{
            return mapper.queryUserByName(username);
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }


    }

}