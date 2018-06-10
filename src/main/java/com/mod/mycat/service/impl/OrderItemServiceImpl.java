package com.mod.mycat.service.impl;

import com.mod.mycat.domain.OrderItem;
import com.mod.mycat.mapper.OrderItemMapper;
import com.mod.mycat.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public int insert(OrderItem item) {
        return orderItemMapper.insert(item);
    }
}
