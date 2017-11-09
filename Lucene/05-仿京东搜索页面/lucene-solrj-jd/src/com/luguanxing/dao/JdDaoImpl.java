package com.luguanxing.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luguanxing.pojo.Product;

@Repository
public class JdDaoImpl implements JdDao {

	//索引库
	@Autowired
	private SolrServer solrServer;
	
	@Override
	public List<Product> selectedProductListByQuery(String queryString, String price, String sort) throws Exception {
		SolrQuery solrQuery = new SolrQuery();
		//设置关键词、查询过滤条件、排序、分页、默认域、高亮等，设置方法不唯一
		solrQuery.set("q", queryString);
		if (price != null && !price.isEmpty()) {
			String[] prices = price.split("-");
			solrQuery.set("fq", "product_price:[" + prices[0] +" TO " + prices[1] +"]");
		}
		if ("1".equals(sort))
			solrQuery.setSort("product_price", ORDER.desc);
		else
			solrQuery.setSort("product_price", ORDER.asc);
		solrQuery.setStart(0);
		solrQuery.setRows(8);
		solrQuery.set("df", "product_keywords");
		solrQuery.setHighlight(true);
		solrQuery.set("hl.highlightMultiTerm", true);  
		solrQuery.setHighlightSimplePre("<span style='color:red'>");
		solrQuery.addHighlightField("product_name");
		solrQuery.addHighlightField("product_description");
		solrQuery.setHighlightSimplePost("</span>");
		QueryResponse response = solrServer.query(solrQuery);
		SolrDocumentList documents = response.getResults();
		//查询得到的文档和高亮文档
 		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
		List<Product> productList = new ArrayList();
		for (SolrDocument document : documents) {
			//设置id
			Product product = new Product();
			product.setPid(document.get("id").toString());
			//设置name和description
			Map<String, List<String>> map = highlighting.get(document.get("id"));
			List<String> product_name = map.get("product_name");
			if (product_name != null)
				product.setName(product_name.get(0));
			else
				product.setName(document.get("product_name").toString());
			product.setDescription(document.get("product_description").toString());
			//设置image和price
			product.setPicture(document.get("product_imgae").toString());
			product.setPrice(Float.parseFloat(document.get("product_price").toString()));
			productList.add(product);
		}
		return productList;
	}

}
