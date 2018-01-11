package cqx.module.rbac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cqx.module.rbac.dao.LoginDao;
import cqx.module.rbac.daomain.User;

/**
 * @author cqx
 * @date 2018/1/10 17:02
 */
@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public User checkLogin(String loginname, String password){
        User user = loginDao.queryUserByName(loginname);
        if (user != null){
            if(user.getPassword().equals(password)){
                return user;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
    public User findUserByName(String loginname){
        return loginDao.queryUserByName(loginname);
    }
}
