package es;

import java.net.InetAddress;

import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMultiSearch {

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
	public void testSearchMulti() throws Exception{
		SearchRequestBuilder srb = client.prepareSearch("film").setTypes("dongzuo");
		MatchPhraseQueryBuilder qb1 = QueryBuilders.matchPhraseQuery("title", "战");
		MatchPhraseQueryBuilder qb2 = QueryBuilders.matchPhraseQuery("content", "武士");
		SearchResponse response = srb.setQuery(QueryBuilders.boolQuery()
			.must(qb1)
			.mustNot(qb2))
			.execute()
			.actionGet();
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			System.out.println(hit.getSourceAsString());
		}
	}
	
	@Test
	public void testSearchMultiScore() throws Exception{
		SearchRequestBuilder srb = client.prepareSearch("film").setTypes("dongzuo");
		MatchPhraseQueryBuilder qb1 = QueryBuilders.matchPhraseQuery("title", "战");
		MatchPhraseQueryBuilder qb2 = QueryBuilders.matchPhraseQuery("content", "星球");
		RangeQueryBuilder qb3 = QueryBuilders.rangeQuery("publishDate").gte("2018-01-01");
		SearchResponse response = srb.setQuery(QueryBuilders.boolQuery()
			.must(qb1)
			.should(qb2)
			.should(qb3))
			.execute()
			.actionGet();
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			System.out.println(hit.getScore() + " -> " + hit.getSourceAsString());
		}
	}
	
	@Test
	public void testSearchMultiRange() throws Exception{
		SearchRequestBuilder srb = client.prepareSearch("film").setTypes("dongzuo");
		MatchPhraseQueryBuilder qb1 = QueryBuilders.matchPhraseQuery("title", "战");
		RangeQueryBuilder qb2 = QueryBuilders.rangeQuery("price").lt(40);
		SearchResponse response = srb.setQuery(QueryBuilders.boolQuery()
			.must(qb1)
			.filter(qb2))
			.execute()
			.actionGet();
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			System.out.println(hit.getSourceAsString());
		}
	}

}
