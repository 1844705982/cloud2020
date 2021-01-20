package com.hepeng.springcloud.dao;

import com.hepeng.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentDao {
  public int create(Payment payment);

  public int deletePaymentById(@Param("id") Long id);

  public int updatePayment(Payment payment);

  public Payment getPaymentById(@Param("id") Long id);

  public List<Payment> findAllPayment();

}
