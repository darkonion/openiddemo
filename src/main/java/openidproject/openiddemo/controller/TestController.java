package openidproject.openiddemo.controller;

import openidproject.openiddemo.services.UserDataService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class TestController {

    private final UserDataService userDataService;

    public TestController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }


    @GetMapping("/")
    public String test1() {
        return "index";
    }

    @GetMapping("/identity")
    public String test2(Model model) {
        Map<String, Object> userData = userDataService.getUserData();
        model.addAttribute("username", userData.getOrDefault("login", "none"));
        model.addAttribute("avatar", userData.getOrDefault("avatar_url", "https://via.placeholder.com/300/09f/fff.png"));
        model.addAttribute("account_url", userData.getOrDefault("url", "none"));
        model.addAttribute("name", userData.getOrDefault("name", "none"));
        model.addAttribute("company", userData.getOrDefault("company", "none"));
        model.addAttribute("location", userData.getOrDefault("location", "none"));
        return "identity";
    }
}
