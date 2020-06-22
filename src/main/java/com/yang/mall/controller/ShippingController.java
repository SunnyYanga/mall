package com.yang.mall.controller;

import com.yang.mall.form.ShippingForm;
import com.yang.mall.pojo.User;
import com.yang.mall.service.IShippingService;
import com.yang.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.yang.mall.consts.MallConst.CURRENT_USER;

/**
 * @author yg
 * @date 2020/6/20 10:35
 */
@RestController
public class ShippingController {

    @Autowired
    private IShippingService shippingService;

    @PostMapping("/shippings")
    public ResponseVo add(@Valid @RequestBody ShippingForm form, HttpSession session){
        User user = (User) session.getAttribute(CURRENT_USER);
        return shippingService.add(user.getId(), form);
    }

    @DeleteMapping("/shippings/{shippingId}")
    public ResponseVo delete(@PathVariable Integer shippingId, HttpSession session){
        User user = (User) session.getAttribute(CURRENT_USER);
        return shippingService.delete(user.getId(), shippingId);
    }

    @PutMapping("/shippings/{shippingId}")
    public ResponseVo update(@PathVariable Integer shippingId, @Valid @RequestBody ShippingForm form, HttpSession session){
        User user = (User) session.getAttribute(CURRENT_USER);
        return shippingService.update(user.getId(), shippingId, form);
    }

    @GetMapping("/shippings")
    public ResponseVo list(@RequestParam(required = false, defaultValue = "1") Integer pageNum, @RequestParam(required = false, defaultValue = "10") Integer pageSize, HttpSession session){
        User user = (User) session.getAttribute(CURRENT_USER);
        return shippingService.list(user.getId(), pageNum, pageSize);
    }

}
