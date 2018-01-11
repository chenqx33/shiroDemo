package cqx.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cqx.module.rbac.daomain.User;

/**
 * 以静态变量持有安全上下文, 例如:HttpSession
 * 需要根据实际情况替换session
 *
 * @author cqx
 * @date 2018/1/10 17:03
 */
public class SecurityContextHolder {

    /** 用户上下文 */
    public static String USER_CONTEXT = "operator";

    /**
     * 私有的构造函数
     */
    private SecurityContextHolder() {}

    /**
     * 设置user会话
     */
    public static void setUser(User user) {
        HttpServletRequest request = ServletContextHolder.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(USER_CONTEXT, user);
    }

    /**
     * 获取User会话
     * @return
     */
    public static User getUser() {
        HttpServletRequest request = ServletContextHolder.getRequest();
        HttpSession session = request.getSession();
        return (User)session.getAttribute(USER_CONTEXT);
    }

    /**
     * 销毁User会话
     */
    public static void destroy() {
        HttpServletRequest request = ServletContextHolder.getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute(USER_CONTEXT);
        session.invalidate();
    }
}