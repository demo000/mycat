package com.mod.mycat.web.controller;

import com.mod.mycat.domain.BookInfo;
import com.mod.mycat.service.BookInfoService;
import com.mod.mycat.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookinfo")
@Api("bookinfo")
public class BookInfoController extends BaseController {


    @Autowired
    private BookInfoService bookInfoService;



    @GetMapping("/queryByAuthor")
    @ApiOperation("根据作者进行查询")
    public Result queryByAuthor(Long authorId) {
        return success(bookInfoService.findBookByAuthorId(authorId));
    }

    @PostMapping("/insert")
    @ApiOperation("插入")
    public Result insert(BookInfo info) {
        return success(bookInfoService.insert(info));
    }

}
