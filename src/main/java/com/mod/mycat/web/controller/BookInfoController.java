package com.mod.mycat.web.controller;

import com.mod.mycat.service.BookInfoService;
import com.mod.mycat.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookinfo")
@Api("bookinfo")
public class BookInfoController {


    @Autowired
    private BookInfoService bookInfoService;

    @GetMapping("/queryById")
    @ApiOperation("根据id获取")
    @ApiImplicitParam(name = "id",  dataType ="int", required = true)
    public Result queryById(Long id) {
        return Result.success(bookInfoService.findById(id));
    }

    @GetMapping("/queryByAuthor")
    @ApiOperation("根据作者进行查询")
    @ApiImplicitParam(name = "authorId", value = "作者id", required = true, paramType = "Long")
    public Result queryByAuthor(Long authorId) {
        return Result.success(bookInfoService.findBookByAuthorId(authorId));
    }


}
