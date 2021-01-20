package com.hepeng.springcloud.service;

import com.hepeng.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@RequestMapping("paymentController")
public interface PaymentFeignService {
    @RequestMapping("addPayment.do")
    @ResponseBody
    public boolean addPayment(Payment payment);

    @RequestMapping("deletePayment.do")
    @ResponseBody
    public boolean deletePayment(long id);

    @RequestMapping("updatePayment.do")
    @ResponseBody
    public boolean updatePayment(Payment payment);

    @RequestMapping("getPaymentById.do")
    @ResponseBody
    public Payment getPaymentById(long id);

    @RequestMapping("findAllPayment.do")
    @ResponseBody
    public List<Payment> findAllPayment();
}
