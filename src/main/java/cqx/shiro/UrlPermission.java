package cqx.shiro;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;


/**
 * @author cqx
 * @date 2018/1/10 15:14
 */
public class UrlPermission implements Permission {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public UrlPermission(){}
    public UrlPermission(String url){
        this.url = url;
    }

    public boolean implies(Permission permission) {
        if(!(permission instanceof UrlPermission)){
            return false;
        }
        UrlPermission urlPermission = (UrlPermission)permission;
        PatternMatcher patternMatcher =new AntPathMatcher();
        return patternMatcher.matches(this.getUrl(),urlPermission.getUrl());
    }
}
