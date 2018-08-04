package es;

import java.net.InetAddress;
import java.util.Map;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.avg.InternalAvg;
import org.elasticsearch.search.aggregations.metrics.sum.InternalSum;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyTestDemo {


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
	public void testSearchAll() throws Exception {
		SearchRequestBuilder srb = client.prepareSearch().setTypes("dongzuo");
		SearchResponse response = srb.setQuery(QueryBuilders.matchAllQuery())
			.execute()
			.actionGet();
		SearchHits hits = response.getHits();
		for (SearchHit hit : hits) {
			System.out.println(hit.getSourceAsString());
		}
	}
	
	@Test
	public void testSearchPriceSum() throws Exception {
		SearchRequestBuilder srb = client.prepareSearch("film").setTypes("dongzuo");
        AggregationBuilder aggregation = AggregationBuilders.avg("avg").field("price");
		SearchResponse response = srb.setQuery(QueryBuilders.matchAllQuery())
			.addAggregation(aggregation)
			.execute()
			.actionGet();
		Map<String, Aggregation> aggMap = response.getAggregations().asMap();
		System.out.println(((InternalAvg) aggMap.get("avg")).getValue());
	}
	
}
