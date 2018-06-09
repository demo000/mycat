package com.mod.mycat.service.impl;

import com.mod.mycat.domain.Product;
import com.mod.mycat.domain.ProductItem;
import com.mod.mycat.mapper.ProductItemMapper;
import com.mod.mycat.mapper.ProductMapper;
import com.mod.mycat.service.ProductItemService;
import com.mod.mycat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductItemServiceImpl implements ProductItemService {
    @Autowired
    private ProductItemMapper productItemMapper;

    @Override
    public int insert(ProductItem item) {
        return productItemMapper.insert(item);
    }
}
