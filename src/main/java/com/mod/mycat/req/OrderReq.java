package com.mod.mycat.req;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mr.p
 */
@Getter
@Setter
public class OrderReq implements Serializable {

    private List<ProductlistBean> productlist;
    /**
     * 暂时使用
     */
    private Long userId;
    /**
     * 暂时使用
     */
    private String orderName;
    /**
     * 地址 预留
     */
    private Long addressId;
    /**
     * 优惠券 预留
     */
    private Long couponNo;

    private String remark;

    public static class ProductlistBean implements Serializable {
        /**
         * productItemId : 1
         * count : 1
         */
        @Getter
        @Setter
        private Long productItemId;
        @Getter
        @Setter
        private int count;


    }
}
