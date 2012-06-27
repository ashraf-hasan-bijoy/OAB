package net.therap.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/26/12
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserAuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        boolean notLoggedIn = request.getSession(false) == null || request.getSession().getAttribute("user") == null;

        if (notLoggedIn && !(url.contains("/app/welcome") || url.contains("/app/login") || url.contains("/app/userreg"))) {
             response.sendRedirect("/OnlineAddressBook/app/login.htm");
             return false;
        }
        else if(!notLoggedIn && (url.contains("/app/welcome") || url.contains("/app/login") || url.contains("/app/userreg"))) {
            response.sendRedirect("/OnlineAddressBook/app/home.htm");
            return false;
        }
        else {
            return true;
        }
    }
}
