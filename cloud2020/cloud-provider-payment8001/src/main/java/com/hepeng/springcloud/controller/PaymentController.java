package com.hepeng.springcloud.controller;

import com.hepeng.springcloud.entities.Payment;
import com.hepeng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("paymentController")
public class PaymentController {
  @Resource private PaymentService paymentService;
  @Resource
  private DiscoveryClient discoveryClient;

  @Value("${server.port}")
  private String serverport;

  @RequestMapping("addPayment.do")
  @ResponseBody
  public boolean addPayment(Payment payment){
    paymentService.create(payment);
    return true;
  }

  @RequestMapping("deletePayment.do")
  @ResponseBody
  public boolean deletePayment(long id){
    paymentService.deletePaymentById(id);
    return true;
  }

  @RequestMapping("updatePayment.do")
  @ResponseBody
  public boolean updatePayment(Payment payment){
    paymentService.updatePayment(payment);
    return true;
  }

  @RequestMapping("getPaymentById.do")
  @ResponseBody
  public Payment getPaymentById(long id){
    Payment payment = paymentService.getPaymentById(id);
    return payment;
  }

  @RequestMapping("findAllPayment.do")
  @ResponseBody
  public List<Payment> findAllPayment(){
    List<Payment> list = paymentService.findAllPayment();
    return list;
  }
}

  /*@PostMapping(value = "/payment/create")
  public CommonResult create(@RequestBody Payment payment) {
    int result = paymentService.create(payment);
    log.info("******插入结果：" + result);

    if (result > 0) {
      return new CommonResult(200, "插入数据库成功,serverport:  "+serverport, result);
    } else {
      return new CommonResult(444, "插入数据库失败", null);
    }
  }

  @GetMapping(value = "/payment/get/{id}")
  public CommonResult getPaymentById(@PathVariable("id") Long id) {
    Payment payment = paymentService.getPaymentById(id);
    log.info("******查询结果：" + payment);

    if (payment != null) {
      return new CommonResult(200, "查询成功,serverport:  "+serverport, payment);
    } else {
      return new CommonResult(444, "没有对应记录，查询id" + id, null);
    }
  }
  @GetMapping(value="/payment/discovery")
  public Object discovery(){
    List<String> services = discoveryClient.getServices();
    for (String element : services){
      log.info("*****element:  "+element);
    }
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    for (ServiceInstance instance : instances){
      log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
    }
    return this.discoveryClient;
  }
  
}*/
