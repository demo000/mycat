package com.mod.mycat.web.controller;

import com.mod.mycat.domain.OrderInfo;
import com.mod.mycat.req.OrderReq;
import com.mod.mycat.service.OrderInfoService;
import com.mod.mycat.util.Constant;
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
    public Result insert(OrderInfo info) {
        return success(orderInfoService.insert(info));
    }

    @PostMapping("/create")
    public Result createOrder(OrderReq req) {
        try {
            int status = orderInfoService.createOrder(req, req.getUserId());
            return Constant.SUCCESS.equals(status) ? success("") : error();
        } catch (Exception e) {

        }
        return error();
    }

    @PostMapping("/queryById")
    public Result queryByid(Long id) {
        return success(orderInfoService.queryById1(id));
    }
    @PostMapping("/queryById2")
    public Result queryByid2(Long id) {
        return success(orderInfoService.queryById2(id));
    }
}
