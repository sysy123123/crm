package com.shsxt.crm.interceptor;

import com.shsxt.crm.exception.NoCookieException;
import com.shsxt.crm.utils.GetCookieFromRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义的拦截器
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setAttribute("ctx", request.getContextPath());

        String id = GetCookieFromRequest.getValueFromCookieByName(request, "id");
        if (id == null || "".equals(id)) {
            throw new NoCookieException("没有cookie");
        }
        return true;
    }

}
