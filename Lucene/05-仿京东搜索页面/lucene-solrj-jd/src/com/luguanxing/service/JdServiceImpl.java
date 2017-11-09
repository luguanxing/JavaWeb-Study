package com.luguanxing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luguanxing.dao.JdDao;
import com.luguanxing.pojo.Product;

@Service
public class JdServiceImpl implements JdService {

	@Autowired
	private JdDao jdDao;
	
	@Override
	public List<Product> selectedProductListByQuery(String queryString, String price, String sort) throws Exception {
		return jdDao.selectedProductListByQuery(queryString, price, sort);
	}

}
