package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("create")
    private String create(User user) {
        System.out.println("creater...");
        return "redirect:/index.jsp";
    }

}
