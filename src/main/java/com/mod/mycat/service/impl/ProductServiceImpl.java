package com.mod.mycat.service.impl;

import com.mod.mycat.domain.Product;
import com.mod.mycat.mapper.ProductMapper;
import com.mod.mycat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public int insert(Product product) {
        return productMapper.insert(product);
    }
}
