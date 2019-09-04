package com.imooc.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * LN
 * 2019/8/29 0029 14:51
 */
//声明成spring的组件，这里只声明组件，并不能使拦截器工作,需要在WebConfig中将拦截器注册到拦截器中
@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        System.out.println(((HandlerMethod) o).getBean().getClass().getName());
        System.out.println(((HandlerMethod) o).getMethod().getName());
        httpServletRequest.setAttribute("startTime", new Date().getTime());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        //startTime是从上边传递下来的
        long start = (long) httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时：" + (new Date().getTime() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
        long start = (long) httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时：" + (new Date().getTime() - start));
        System.out.println("ex is" + e);
    }
}
