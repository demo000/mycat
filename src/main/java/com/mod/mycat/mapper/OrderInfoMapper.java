package com.mod.mycat.mapper;

import com.mod.mycat.domain.OrderInfo;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    /*连接查询*/
    OrderInfo queryById1(Long id);

    /**
     *
     * @param id
     * @return
     */
    OrderInfo queryById2(Long id);

}