package com.mod.mycat.web.controller;

import com.mod.mycat.domain.ProductItem;
import com.mod.mycat.service.ProductItemService;
import com.mod.mycat.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productitem")
public class ProductItemController extends BaseController{
    @Autowired
    private ProductItemService productItemService;

    @PostMapping("/insert")
    public Result insert(ProductItem item){
        return success(productItemService.insert(item));
    }
}
