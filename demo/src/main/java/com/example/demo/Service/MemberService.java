package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MemberDao.MemberDao;
import com.example.demo.Model.MemberAccount;

@Service
public class MemberService {
    
    @Autowired
    MemberDao memberDao;
    public void addMemeber(MemberAccount memberAccount) {
        memberDao.addMember(memberAccount);
    }
}
