package com.mod.mycat.web.controller;

import com.mod.mycat.domain.OrderInfo;
import com.mod.mycat.service.OrderInfoService;
import com.mod.mycat.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController extends BaseController {
    @Autowired
    private OrderInfoService orderInfoService;
    @PostMapping("/insert")
    public Result insert(OrderInfo info){
      return success(orderInfoService.insert(info));
    }
}
