package com.example.demo;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class UserController {
    private String message = "spring boot day XXX";
    @Autowired
    UserSerivce userService;
    
    @RequestMapping("/MyFirstPage")
        public String greeting(@RequestParam(value="title", required=false, defaultValue="xiao") 
        String title, Model model) {
        model.addAttribute("name", title);
        return "html/index";
    }
    
    @GetMapping("/test")
        public String index(Map<String, Object> model) {
        model.put("message", this.message);
        return "page1";
    }
    
    @GetMapping("/jsp")
    public String jsp(Model model) {
        model.addAttribute("msg","testJspPage");
        return "myJsp";
        
    }
    
    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("msg", "test thymeleaf");
        return "html/thymeleaf";
    }
    
    @GetMapping("/userService")
    public String getUserIdService(Map<String, Object> model) {
        model.put("ID", userService.getUserId());
        return "html/userThym";
    }
    

}
