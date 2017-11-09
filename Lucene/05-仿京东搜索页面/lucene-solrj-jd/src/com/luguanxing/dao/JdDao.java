package com.luguanxing.dao;

import java.util.List;

import com.luguanxing.pojo.Product;

public interface JdDao {

	public List<Product> selectedProductListByQuery(String queryString, String price, String sort)  throws Exception ;
	
}
