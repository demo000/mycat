package com.mod.mycat.web.controller;

import com.mod.mycat.domain.UserInfo;
import com.mod.mycat.service.UserInfoService;
import com.mod.mycat.util.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userinfo")
@Api("userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    @GetMapping("/query")
    public Result queryList() {
        return Result.success(userInfoService.findAll());
    }

    @PostMapping("/insert")
    public Result insert(UserInfo info) {
        return Result.success(userInfoService.insert(info));
    }
}
