package com.mark.springdemo.springbootapp;

import com.mark.springdemo.springbootapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String authenticate(@RequestParam("name") String name,
                               @RequestParam("password") String password,
                               ModelMap mm) {

        boolean validUser = loginService.validateUser(name, password);
        if (!validUser) {
            mm.put("message", "invalid credentials!");
            return "login";
        }
        mm.put("name", name);
        mm.put("password", password);
        return "welcome";
    }


}
