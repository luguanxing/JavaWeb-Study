package es;

import java.net.InetAddress;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSearch {

	private static String host = "192.168.136.128"; // 服务器地址
	private static int port = 9300; // 端口

	private TransportClient client = null;

	@Before
	public void getClient() throws Exception {
		client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
	}

	@After
	public void close() {
		if (client != null) {
			client.close();
		}
	}
	
	@Test
	public void testSearchAll() throws Exception{
		SearchRequestBuilder srb = client.prepareSearch("film").setTypes("dongzuo");
		SearchResponse response = srb.setQuery(QueryBuilders.matchAllQuery())
			.execute()
			.actionGet();
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			System.out.println(hit.getSourceAsString());
		}
	}
	
	@Test
	public void testSearchPage() throws Exception{
		SearchRequestBuilder srb = client.prepareSearch("film").setTypes("dongzuo");
		SearchResponse response = srb.setQuery(QueryBuilders.matchAllQuery())
			.setFrom(1)
			.setSize(3)
			.execute()
			.actionGet();
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			System.out.println(hit.getSourceAsString());
		}
	}
	
	@Test
	public void testSearchSort() throws Exception{
		SearchRequestBuilder srb = client.prepareSearch("film").setTypes("dongzuo");
		SearchResponse response = srb.setQuery(QueryBuilders.matchAllQuery())
			.addSort("publishDate", SortOrder.DESC)
			.execute()
			.actionGet();
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			System.out.println(hit.getSourceAsString());
		}
	}
	
	@Test
	public void testSearchFilter() throws Exception{
		SearchRequestBuilder srb = client.prepareSearch("film").setTypes("dongzuo");
		SearchResponse response = srb.setQuery(QueryBuilders.matchAllQuery())
			.setFetchSource(new String[]{"title", "price"}, null)
			.execute()
			.actionGet();
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			System.out.println(hit.getSourceAsString());
		}
	}
	
	@Test
	public void testSearchCondition() throws Exception{
		SearchRequestBuilder srb = client.prepareSearch("film").setTypes("dongzuo");
		SearchResponse response = srb.setQuery(QueryBuilders.matchQuery("title", "战"))
			.setFetchSource(new String[]{"title", "price"}, null)
			.execute()
			.actionGet();
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			System.out.println(hit.getSourceAsString());
		}
	}
		
	@Test
	public void testSearchHighLight() throws Exception{
		SearchRequestBuilder srb = client.prepareSearch("film").setTypes("dongzuo");
		HighlightBuilder highlightBuilder = new HighlightBuilder();
		highlightBuilder.preTags("<h2><font>");
		highlightBuilder.postTags("</h2></font>");
		highlightBuilder.field("title");
		
		SearchResponse response = srb.setQuery(QueryBuilders.matchQuery("title", "战"))
			.highlighter(highlightBuilder)
			.setFetchSource(new String[]{"title", "price"}, null)
			.execute()
			.actionGet();
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			System.out.println(hit.getSourceAsString());
			System.out.println(hit.getHighlightFields());
		}
	}
	
}
