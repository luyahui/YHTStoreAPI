package com.yhtart.controller;

import com.yhtart.annotation.PassToken;
import com.yhtart.model.User;
import com.yhtart.service.UserService;
import com.yhtart.util.TokenUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    UserService userService;

    @PassToken
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        User userInBase = userService.findByUsername(user.getUsername());
        JSONObject object = new JSONObject();
        if (userInBase == null) {
            object.put("message", "登录失败，用户不存在！");
            return ResponseEntity.ok(object.toString());
        }
        if (!userInBase.getPassword().equals(user.getPassword())) {
            object.put("message", "登录失败，密码错误！");
            return ResponseEntity.ok(object.toString());
        }
        String token = TokenUtil.getToken(userInBase);
        object.put("token", token);
        object.put("username", userInBase.getUsername());
        return ResponseEntity.ok(object.toString());
    }
}
