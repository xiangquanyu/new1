package com.czxy.intercept;

import com.czxy.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version v 1.0
 * @date 2019/7/10
 */
@Component
public class MyIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        String servletPath = request.getServletPath();

        if(!servletPath.contains("login")){
            if (user == null) {
                response.sendRedirect("/login.html");
                return false;
            }
        }

            return true;
    }


}
