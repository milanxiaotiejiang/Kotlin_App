package com.kotlin.order.data.repository


import javax.inject.Inject
import com.kotlin.order.data.protocol.SubmitOrderReq
import com.kotlin.order.data.api.OrderApi
import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.order.data.protocol.Order
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.order.data.protocol.GetOrderListReq
import com.kotlin.order.data.protocol.GetOrderByIdReq
import com.kotlin.order.data.protocol.ConfirmOrderReq
import com.kotlin.order.data.protocol.CancelOrderReq
import io.reactivex.Observable

/*
   订单数据层
 */
class OrderRepository @Inject constructor() {

    /*
        取消订单
     */
    fun cancelOrder(orderId: Int): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(OrderApi::class.java).cancelOrder(CancelOrderReq(orderId))
    }

    /*
        确认订单
     */
    fun confirmOrder(orderId: Int): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(OrderApi::class.java).confirmOrder(ConfirmOrderReq(orderId))
    }

    /*
        根据ID查询订单
     */
    fun getOrderById(orderId: Int): Observable<BaseResp<Order>> {
        return RetrofitFactory.instance.create(OrderApi::class.java).getOrderById(GetOrderByIdReq(orderId))
    }

    /*
        根据状态查询订单列表
     */
    fun getOrderList(orderStatus: Int): Observable<BaseResp<MutableList<Order>?>> {
        return RetrofitFactory.instance.create(OrderApi::class.java).getOrderList(GetOrderListReq(orderStatus))
    }

    /*
        提交订单
     */
    fun submitOrder(order: Order): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(OrderApi::class.java).submitOrder(SubmitOrderReq(order))
    }

}
