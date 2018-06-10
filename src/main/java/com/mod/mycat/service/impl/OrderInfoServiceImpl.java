package com.mod.mycat.service.impl;

import com.mod.mycat.domain.OrderInfo;
import com.mod.mycat.mapper.OrderInfoMapper;
import com.mod.mycat.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Override
    public int insert(OrderInfo info) {

        info.setCreatedate(new Date());
        info.setUpdatedate(new Date());

        return orderInfoMapper.insert(info);
    }
}
