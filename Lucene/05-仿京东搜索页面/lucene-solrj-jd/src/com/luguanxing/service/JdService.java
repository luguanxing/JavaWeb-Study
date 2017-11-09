package com.luguanxing.service;

import java.util.List;

import com.luguanxing.pojo.Product;

public interface JdService {

	public List<Product> selectedProductListByQuery(String queryString, String price, String sort)  throws Exception ;
	
}
