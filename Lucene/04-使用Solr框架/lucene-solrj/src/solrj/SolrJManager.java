package solrj;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;
import org.junit.Test;

/**
 * SolrJ管理：增删改查
 * @author LGX
 *
 */
public class SolrJManager {

	//添加
	@Test
	public void testAdd() throws Exception {
		String baseURL  = "http://localhost:8080/solr/collection1";
		//单机版
		SolrServer solrServer = new HttpSolrServer(baseURL);
		SolrInputDocument document = new SolrInputDocument();
		document.setField("id", "haha");
		document.setField("name", "习近平");
		solrServer.add(document);
		solrServer.commit();
	}
	
	
	//删除
	@Test
	public void testDelete() throws Exception {
		String baseURL  = "http://localhost:8080/solr/collection1";
		SolrServer solrServer = new HttpSolrServer(baseURL);
		//输入删除条件
		solrServer.deleteByQuery("*:*", 1000);
	}
	
	
	//更新(与添加一致，ID相同就为更新，ID不同则为添加)
	@Test
	public void testUpdate() throws Exception {
		String baseURL  = "http://localhost:8080/solr/collection1";
		SolrServer solrServer = new HttpSolrServer(baseURL);
		SolrInputDocument document = new SolrInputDocument();
		document.setField("id", "haha");
		document.setField("name", "特朗普");
		solrServer.add(document);
		solrServer.commit();
	}
	
	
	//查询
	@Test
	public void testSearch() throws Exception {
		String baseURL  = "http://localhost:8080/solr/collection1";
		SolrServer solrServer = new HttpSolrServer(baseURL);
		SolrQuery solrQuery = new SolrQuery();
		//设置关键词、查询过滤条件、排序、分页、默认域、高亮等，设置方法不唯一
		solrQuery.set("q", "华为");
		solrQuery.set("fq", "product_price:[* TO 3000]");
		solrQuery.setSort("product_price", ORDER.desc);
		solrQuery.setStart(0);
		solrQuery.setRows(5);
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
		long numFound = documents.getNumFound();
		System.out.println("总条数: "+numFound);
		for (SolrDocument document : documents) {
			System.out.println("==================");
			System.out.println(document.get("id"));
//			System.out.println(document.get("product_name"));
//			System.out.println(document.get("product_description"));
			Map<String, List<String>> map = highlighting.get(document.get("id"));
			List<String> product_name = map.get("product_name");
			List<String> product_description = map.get("product_description");
			if (product_name != null)
				System.out.println(product_name.get(0));
			else
				System.out.println(document.get("product_name"));
			if (product_description != null)
				System.out.println(product_description.get(0));
			else
				System.out.println(document.get("product_description"));
			System.out.println(document.get("product_price"));
			System.out.println(document.get("product_imgae"));
			System.out.println("==================");
			System.out.println();
		}
	}
}
