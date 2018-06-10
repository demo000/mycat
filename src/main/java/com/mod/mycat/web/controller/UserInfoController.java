package com.mod.mycat.web.controller;

import com.mod.mycat.domain.UserInfo;
import com.mod.mycat.service.UserInfoService;
import com.mod.mycat.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userinfo")
@Api("用户基本信息")
public class UserInfoController extends BaseController{

    @Autowired
    private UserInfoService userInfoService;


    @GetMapping("/query")
    @ApiOperation("列表查询")
    public Result queryList() {
        return success(userInfoService.findAll());
    }

    @PostMapping("/insert")
    @ApiOperation("插入操作")
    public Result insert(UserInfo info) {
        return success(userInfoService.insert(info));
    }

    @GetMapping("/get")
    @ApiOperation("根据id获取")
    public Result getById(Long id) {
        return success(userInfoService.findById(id));
    }

    @GetMapping("/getAvgScore")
    @ApiOperation("统计平均得分")
    public Result getAvgScore() {
        return success(userInfoService.getAvgScore());
    }


}
