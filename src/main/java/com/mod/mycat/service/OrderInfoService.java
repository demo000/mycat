package com.mod.mycat.service;

import com.mod.mycat.domain.OrderInfo;
import com.mod.mycat.req.OrderReq;

public interface OrderInfoService {

    int insert(OrderInfo info);

    int createOrder(OrderReq req, Long userId);

    OrderInfo queryById1(Long id);
    OrderInfo queryById2(Long id);
}
