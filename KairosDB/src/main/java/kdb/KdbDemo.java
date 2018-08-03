package kdb;

import org.junit.Test;
import org.kairosdb.client.HttpClient;
import org.kairosdb.client.builder.AggregatorFactory;
import org.kairosdb.client.builder.MetricBuilder;
import org.kairosdb.client.builder.QueryBuilder;
import org.kairosdb.client.builder.TimeUnit;
import org.kairosdb.client.response.QueryResponse;
import org.kairosdb.client.response.Response;

public class KdbDemo {

	@Test
	public void testAdd() throws Exception {
		MetricBuilder builder = MetricBuilder.getInstance();
		builder.addMetric("myMetric").addTag("ip", "12").addTag("testTag", "abc")
				.addDataPoint(System.currentTimeMillis(), 10).addDataPoint(System.currentTimeMillis(), 100L);
		HttpClient client = new HttpClient("http://192.168.136.128:8080/");
		Response response = client.pushMetrics(builder);
		System.out.println(response.getStatusCode());
		client.shutdown();
	}
	
	@Test
	public void testGet() throws Exception {
		QueryBuilder builder = QueryBuilder.getInstance();
		builder.setStart(2, TimeUnit.MONTHS)
		       .setEnd(1, TimeUnit.MONTHS)
		       .addMetric("metric1")
		       .addAggregator(AggregatorFactory.createAverageAggregator(5, TimeUnit.MINUTES));
		HttpClient client = new HttpClient("http://192.168.136.128:8080/");
		QueryResponse response = client.query(builder);
		System.out.println(response.getBody());
		client.shutdown();
	}

}
