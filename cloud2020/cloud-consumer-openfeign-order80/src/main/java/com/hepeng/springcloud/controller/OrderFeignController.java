package com.hepeng.springcloud.controller;

import com.hepeng.springcloud.entities.Payment;
import com.hepeng.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
/*
@RequestMapping("paymentController")
*/
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @RequestMapping("addPayment.do")
    @ResponseBody
    public boolean addPayment(Payment payment){
        paymentFeignService.addPayment(payment);
        return true;
    }

    @RequestMapping("deletePayment.do")
    @ResponseBody
    public boolean deletePayment(long id){
        paymentFeignService.deletePayment(id);
        return true;
    }

    @RequestMapping("updatePayment.do")
    @ResponseBody
    public boolean updatePayment(Payment payment){
        paymentFeignService.updatePayment(payment);
        return true;
    }

    @RequestMapping("getPaymentById.do")
    @ResponseBody
    public Payment getPaymentById(long id){
        Payment payment = paymentFeignService.getPaymentById(id);
        return payment;
    }

    @RequestMapping("findAllPayment.do")
    @ResponseBody
    public List<Payment> findAllPayment(){
        List<Payment> list = paymentFeignService.findAllPayment();
        return list;
    }
}
