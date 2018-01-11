package cqx.security;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 以静态变量持有 Web ServletContext
 *
 * @author cqx
 * @date 2018/1/10 17:04
 */
public class ServletContextHolder {

    /** 私有构造函数 */
    private ServletContextHolder() {}

    /**
     * 从静态变量中取得 HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}
