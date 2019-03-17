package com.yhtart.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.yhtart.annotation.PassToken;
import com.yhtart.model.User;
import com.yhtart.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        // get handler method
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // logging in is not required for some methods
        if (method.isAnnotationPresent(PassToken.class))
            return true;

        // process authorization verification
        String token = request.getHeader("Token");

        if (token == null) {
            sendJsonMessage(response, "无Token，请重新登录！");
            return false;
        }
        long userId;

        try {
            userId = Long.parseLong(JWT.decode(token).getAudience().get(0));
            User user = userService.findUserById(userId);
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            jwtVerifier.verify(token);
        } catch (Exception e) {
            sendJsonMessage(response, "身份验证失败，请重新登录！");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        return;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        return;
    }

    private void sendJsonMessage(HttpServletResponse response, String message) throws Exception {
        JSONObject object = new JSONObject();
        object.put("message", message);
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(object.toString());
        writer.close();
        response.setStatus(401);
        response.flushBuffer();
    }
}
