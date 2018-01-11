package cqx.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

/**
 * @author cqx
 * @date 2018/1/10 16:42
 */
public class ShiroKit {

    public static String md5Pwd(String password,String salt){
        String md5Pwd = new Md5Hash(password,salt).toHex();
        return md5Pwd;
    }
    @Test
    public void md5Pwd(){
        String md5Pwd = new Md5Hash("cqx","hgits").toHex();
        System.out.println(md5Pwd);
    }
}
