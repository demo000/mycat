package com.mod.mycat.web.controller;

import com.mod.mycat.util.Result;

public class BaseController {

    protected Result success(Object obj){
        return Result.success(obj);
    }

    protected Result error(){
        return Result.error("");
    }
    protected Result error(String msg){
        return Result.error(msg);
    }


}
