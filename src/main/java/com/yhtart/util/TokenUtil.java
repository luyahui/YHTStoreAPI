package com.yhtart.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yhtart.model.User;

public class TokenUtil {
    public static String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(String.valueOf(user.getId()))// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
