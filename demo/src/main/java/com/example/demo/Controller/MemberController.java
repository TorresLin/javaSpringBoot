package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.MemberAccount;
import com.example.demo.Service.MemberService;

@RestController
public class MemberController {
    @Autowired
    MemberAccount memberAccount;
    
    @Autowired
    MemberService memberService;
    
    @RequestMapping("/addMember")
    public String helloNewMember() {
        memberAccount =new MemberAccount();
        memberAccount.setPassword("123456");
        memberAccount.setEmail("aa@aa.aa");
        memberAccount.setCellphone("0911222333");
        memberAccount.setAddress("Taipei");
        memberService.addMemeber(memberAccount);
        return "add new member success";
    }
    
}
