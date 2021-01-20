package com.hepeng.springcloud.service;

import com.hepeng.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentService {
    public int create(Payment payment);

    public int deletePaymentById(@Param("id") Long id);

    public int updatePayment(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

    public List<Payment> findAllPayment();
}
