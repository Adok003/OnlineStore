package com.example.onlinestore.Controller;


import com.example.onlinestore.Entity.User;
import com.example.onlinestore.service.JwtService;
import com.example.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    // REGISTER USER
    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    // LOGIN,CREATE TOKEN
    @PostMapping({"/authenticate"})
    public User createJwtToken(@RequestBody User user) throws Exception {
        return jwtService.createJwtToken(user);
    }

}
