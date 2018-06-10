package com.mod.mycat.web.controller;

import com.mod.mycat.domain.OrderItem;
import com.mod.mycat.service.OrderItemService;
import com.mod.mycat.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderitem")
public class OrderItemController extends BaseController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/insert")
    public Result insert(OrderItem orderItem) {
        return success(orderItemService.insert(orderItem));
    }
}
