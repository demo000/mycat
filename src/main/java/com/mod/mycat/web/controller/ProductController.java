package com.mod.mycat.web.controller;

import com.mod.mycat.domain.Product;
import com.mod.mycat.service.ProductService;
import com.mod.mycat.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/insert")
    public Result insert(Product product) {
        return Result.success(productService.insert(product));
    }
}
