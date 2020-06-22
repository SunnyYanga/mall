package com.yang.mall.listener;

import com.google.gson.Gson;
import com.yang.mall.pojo.PayInfo;
import com.yang.mall.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 关于PayInfo ,应该由pay提供一个client.jar, mall引入jar
 * @author yg
 * @date 2020/6/21 17:37
 */
@Component
@RabbitListener(queues = "payNotify")
@Slf4j
public class PayMsgListener {

    @Autowired
    private IOrderService orderService;

    @RabbitHandler
    public void process(String msg) {
        log.info("接收到消息：{}", msg);
        PayInfo payInfo = new Gson().fromJson(msg, PayInfo.class);
        if (payInfo.getPlatformStatus().equals("SUCCESS")) {
            // 修改订单里的状态
            orderService.paid(payInfo.getOrderNo());
        }
    }
}
