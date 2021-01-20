package com.hepeng.springcloud.service.impl;

import com.hepeng.springcloud.dao.PaymentDao;
import com.hepeng.springcloud.entities.Payment;
import com.hepeng.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service("classesService")
public class PaymentServiceImpl implements PaymentService {
	@Resource
	private PaymentDao paymentDao;

	@Override
	public int create(Payment payment) {
		return paymentDao.create(payment);
	}

	@Override
	public int deletePaymentById(Long id) {
		return paymentDao.deletePaymentById(id);
	}

	@Override
	public int updatePayment(Payment payment) {
		return paymentDao.updatePayment(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		return paymentDao.getPaymentById(id);
	}

	@Override
	public List<Payment> findAllPayment() {
		return paymentDao.findAllPayment();
	}

}
