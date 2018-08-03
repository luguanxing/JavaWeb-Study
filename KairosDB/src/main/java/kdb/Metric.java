package kdb;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Date;

import org.junit.Test;
import org.kairosdb.client.HttpClient;
import org.kairosdb.client.builder.AggregatorFactory;
import org.kairosdb.client.builder.MetricBuilder;
import org.kairosdb.client.builder.QueryBuilder;
import org.kairosdb.client.builder.TimeUnit;
import org.kairosdb.client.response.GetResponse;
import org.kairosdb.client.response.QueryResponse;
import org.kairosdb.client.response.Response;

public class Metric {

	// 获取metric的name集合
	public static void getMetricNames() {
		HttpClient client;
		GetResponse response;
		try {
			client = new HttpClient("http://192.168.136.128:8080");
			response = client.getMetricNames();
			System.out.println("*********************MetricNames**********************");
			System.out.println("Response Code =" + response.getStatusCode());
			for (String name : response.getResults()) {
				System.out.println(name);
			}
			client.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 获取Tag的name集合
	public static void getTagNames() {
		HttpClient client;
		GetResponse response;
		try {
			client = new HttpClient("http://192.168.136.128:8080");
			response = client.getTagNames();
			System.out.println("*********************TagNames**********************");
			System.out.println("Response Code =" + response.getStatusCode());
			for (String name : response.getResults()) {
				System.out.println(name);
			}
			client.shutdown();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 获取Tag的值集合
	public static void getTagValues() {
		HttpClient client;
		GetResponse response;
		try {
			client = new HttpClient("http://192.168.136.128:8080");
			response = client.getTagValues();
			System.out.println("*********************TagValues**********************");
			System.out.println("Response Code =" + response.getStatusCode());
			for (String name : response.getResults()) {
				System.out.println(name);
			}
			client.shutdown();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// pushMetric
	public static void pushMetric() throws URISyntaxException, IOException {
		MetricBuilder builder = MetricBuilder.getInstance();
		builder.addMetric("proc.loadavg.1m").addTag("host", "kairosdb").addDataPoint(System.currentTimeMillis(), 20)
				.addDataPoint(System.currentTimeMillis(), 30L);
		HttpClient client = new HttpClient("http://192.168.136.128:8080");
		Response response = client.pushMetrics(builder);
		System.out.println("*********************Push Metric**********************");
		System.out.println("Response Code =" + response.getStatusCode());
		client.shutdown();
	}

	// 查询数据节点
	public static void queryDataPoint() throws IOException, URISyntaxException {
		QueryBuilder builder = QueryBuilder.getInstance();
		builder.setStart(new Date(1533200400000L)).setEnd(new Date(1533201056000L))
				.addMetric("myMetric")
				.addAggregator(
					AggregatorFactory.createSumAggregator(1, TimeUnit.SECONDS)
				);
		System.out.println(builder.getMetrics());;
		HttpClient client = new HttpClient("http://192.168.136.128:8080");
		QueryResponse response = client.query(builder);
		String body = response.getBody();
		System.out.println("*********************Query DataPoint**********************");
		System.out.println("Response Code =" + response.getStatusCode());
		System.out.println(body);
		client.shutdown();
	}

	// 删除Metric中的数据点
	public static void deleteMetric() throws IOException {
		// MetricBuilder builder = MetricBuilder.getInstance();
		HttpClient client = new HttpClient("http://192.168.136.128:8080");
		Response response = client.deleteMetric("proc.loadavg.1m");
		System.out.println("*********************Delete Metric**********************");
		System.out.println("Response Code =" + response.getStatusCode());
		client.shutdown();
	}
	
	public static Integer id = 1;
	
	public static void testAddNum(int num) throws Exception {
		MetricBuilder builder = MetricBuilder.getInstance();
		builder.addMetric("myMetric").addTag("myid", id.toString()).addTag("fid", (int)(Math.random()*5+1) + "")
				.addDataPoint(System.currentTimeMillis(), 10).addDataPoint(System.currentTimeMillis(), num);
				id++;
		HttpClient client = new HttpClient("http://192.168.136.128:8080/");
		Response response = client.pushMetrics(builder);
		System.out.println(response.getStatusCode());
		client.shutdown();
	}

	public static void testAddBatch() throws Exception {
		testAddNum(10);
		Thread.sleep(1000);
		testAddNum(30);
		Thread.sleep(1000);
		testAddNum(50);
		Thread.sleep(1000);
		testAddNum(20);
		Thread.sleep(1000);
		testAddNum(25);
		Thread.sleep(1000);
		testAddNum(35);
		Thread.sleep(1000);
		testAddNum(45);
		Thread.sleep(1000);
		testAddNum(15);
		Thread.sleep(1000);
		testAddNum(35);
		Thread.sleep(1000);
		testAddNum(45);
		Thread.sleep(1000);
		testAddNum(25);
		Thread.sleep(1000);
		testAddNum(15);
		Thread.sleep(1000);
		testAddNum(30);
		Thread.sleep(1000);
		testAddNum(20);
		Thread.sleep(1000);
		testAddNum(10);
		Thread.sleep(1000);
		testAddNum(40);
		Thread.sleep(1000);
		testAddNum(30);
		Thread.sleep(1000);
		testAddNum(50);
	}

	/**
	 * 类描述：
	 * 
	 * @author: blank @date： 日期：2016-5-9 时间：上午10:30:14
	 * @param args
	 * @version 1.0
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws Exception {
//		getMetricNames();
//		getTagNames();
//		getTagValues();
//		pushMetric();
//		deleteMetric();
		queryDataPoint();
//		deleteMetric();
//		testAddBatch();
	}

}