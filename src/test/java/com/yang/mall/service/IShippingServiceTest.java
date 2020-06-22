package com.yang.mall.service;

import com.yang.mall.MallApplicationTests;
import com.yang.mall.enums.ResponseEnum;
import com.yang.mall.form.ShippingForm;
import com.yang.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author yg
 * @date 2020/6/20 9:22
 */
@Slf4j
public class IShippingServiceTest extends MallApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private Integer uid= 1;

    @Test
    public void add() {
        ShippingForm form = new ShippingForm();
        form.setReceiverName("aaa");
        form.setReceiverAddress("bbb");
        form.setReceiverCity("ccc");
        form.setReceiverDistrict("ddd");
        form.setReceiverMobile("12234343");
        form.setReceiverPhone("12323434");
        form.setReceiverProvince("sdas");
        form.setReceiverZip("123344");
        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, form);
        log.info("response={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());

    }

    @Test
    public void delete() {
        ResponseVo responseVo = shippingService.delete(uid, 6);
        log.info("response={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void update() {
        ShippingForm form = new ShippingForm();
        form.setReceiverName("aaa");
        form.setReceiverAddress("aa");
        form.setReceiverCity("aaa");
        form.setReceiverDistrict("ddd");
        form.setReceiverMobile("12234343");
        form.setReceiverPhone("12323434");
        form.setReceiverProvince("sdas");
        form.setReceiverZip("123344");
        ResponseVo responseVo = shippingService.update(uid, 7, form);
        log.info("response={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo responseVo = shippingService.list(uid, 1, 10);
        log.info("response={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}