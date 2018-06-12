package com.mod.mycat.service.impl;

import com.mod.mycat.domain.OrderInfo;
import com.mod.mycat.domain.OrderItem;
import com.mod.mycat.domain.ProductItem;
import com.mod.mycat.mapper.OrderInfoMapper;
import com.mod.mycat.mapper.OrderItemMapper;
import com.mod.mycat.mapper.ProductItemMapper;
import com.mod.mycat.mapper.ProductMapper;
import com.mod.mycat.req.OrderReq;
import com.mod.mycat.service.OrderInfoService;
import com.mod.mycat.util.Constant;
import com.mod.mycat.util.OrderConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private ProductItemMapper productItemMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public int insert(OrderInfo info) {
        info.setCreatedate(new Date());
        info.setUpdatedate(new Date());
        return orderInfoMapper.insert(info);
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int createOrder(OrderReq req, Long userId) {
        Long amount = 0L;
        List<OrderItem> orderItemList = new ArrayList<>();
        for (OrderReq.ProductlistBean productlistBean : req.getProductlist()) {
            ProductItem productItem = productItemMapper.selectByPrimaryKey(productlistBean.getProductItemId());
            OrderItem orderItem = getOrderItem(productItem, productlistBean.getCount());
            orderItemList.add(orderItem);
            amount += orderItem.getTotal();
        }
        OrderInfo orderInfo = getOrderInfo(req, amount, userId);
        orderInfoMapper.insert(orderInfo);
        for (OrderItem orderItem : orderItemList) {
            orderItem.setOrderid(orderInfo.getId());
            orderItemMapper.insert(orderItem);
        }
        return Constant.SUCCESS;
    }

    private OrderInfo getOrderInfo(OrderReq req, Long amount, Long userId) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreatedate(new Date());
        orderInfo.setUpdatedate(new Date());
        orderInfo.setRemark(req.getRemark());
        orderInfo.setUserid(userId);
        orderInfo.setPaystatus(OrderConstant.PAYSTATUS_0);
        orderInfo.setStatus(OrderConstant.ORDER_STATUS_0);
        orderInfo.setName(req.getOrderName());
        orderInfo.setTotal(amount);
        return orderInfo;
    }

    private OrderItem getOrderItem(ProductItem item, int num) {
        OrderItem orderItem = new OrderItem();
        orderItem.setNum(num);
        orderItem.setPrice(item.getPrice());
        orderItem.setProductname(item.getProductname());
        orderItem.setSpec(item.getSpec());
        orderItem.setUnit(item.getUnit());
        orderItem.setTotal(item.getPrice() * num);
        return orderItem;
    }
}
