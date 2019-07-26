package com.czxy.controller;

import com.czxy.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @version v 1.0
 * @date 2019/7/10
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody User user, HttpServletRequest request) {
        try {
            System.out.println(user);
            request.getSession().setAttribute("user", user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
