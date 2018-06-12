package com.mod.mycat.util;

import java.io.Serializable;

/**
 * @author Mr.p
 */
public final class OrderConstant implements Serializable {

    /**
     * 0待发货,1已发货,2已签收,3退款,4退货,5已完成,6作废
     */
    public final static Integer ORDER_STATUS_0 = 0;
    public final static Integer ORDER_STATUS_1 = 0;
    public final static Integer ORDER_STATUS_2 = 0;
    public final static Integer ORDER_STATUS_3 = 0;
    public final static Integer order_Status_4 = 0;
    public final static Integer order_Status_5 = 0;
    public final static Integer order_Status_6 = 0;

    /**
     * 0未支付,1已支付
     */
    public final static Integer PAYSTATUS_0 = 0;
    public final static Integer PAYSTATUS_1 = 1;

}
