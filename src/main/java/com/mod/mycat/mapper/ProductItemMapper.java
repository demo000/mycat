package com.mod.mycat.mapper;

import com.mod.mycat.domain.ProductItem;

public interface ProductItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductItem record);

    int insertSelective(ProductItem record);

    ProductItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductItem record);

    int updateByPrimaryKey(ProductItem record);
}