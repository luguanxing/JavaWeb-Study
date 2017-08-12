package stock;

import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */

//返回股票信息的servlet类
public class GetStockInfo extends HttpServlet {

	private HashMap<String, Stock> stocks;

	@Override    //初始化保存股票对象
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		//创建股票
		stocks = new HashMap<>();
		Stock szzs = new Stock(3000.0, 2990.1, "上证指数", "300001");
		Stock pfyh = new Stock(23.22, 23.50, "浦发银行", "000001");

		//添加股票
		stocks.put(szzs.getId(), szzs);
		stocks.put(pfyh.getId(), pfyh);
	}

	@Override    //更新并返回两只股票价格信息
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result;
		UpdateStocks();
		try {
			result = GetStockJson();
		} catch (JSONException e) {
			result = e.toString();
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(result);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	public void UpdateStocks() {
		double rmd_szzs = Math.random() * 20;
		boolean isUp_szzs = Math.random() >= 0.5;
		Stock szzs = stocks.get("300001");
		double now_szzs = (isUp_szzs)? szzs.getNow() + rmd_szzs : szzs.getNow() - rmd_szzs;
		szzs.setNow(((int)(now_szzs*100))/100.0);

		double rmd_pfyh = Math.random() * 0.5;
		boolean isUp_pfyh = Math.random() >= 0.5;
		Stock pfyh = stocks.get("000001");
		double now_pfyh = (isUp_pfyh)? pfyh.getNow() + rmd_pfyh : pfyh.getNow() - rmd_pfyh;
		pfyh.setNow(((int)(now_pfyh*100))/100.0);
	}
	
	public String GetStockJson() throws JSONException {
		/*
			利用json格式返回两支股票信息
			{
				"stocks" : [
					{"name":"xxx", "id":"xxx", "yes":xxx, "tod":xxx, "now":xxx},
					{"name":"xxx", "id":"xxx", "yes":xxx, "tod":xxx, "now":xxx}
				]
			}
		 */
		JSONObject json = new JSONObject();
		JSONObject json_szzs = new JSONObject();
		JSONObject json_pfyh = new JSONObject();

		Stock szzs = stocks.get("300001");
		json_szzs.put("name", szzs.getName());
		json_szzs.put("id", szzs.getId());
		json_szzs.put("yes", szzs.getYesterday());
		json_szzs.put("tod", szzs.getToday());
		json_szzs.put("now", szzs.getNow());

		Stock pfyh = stocks.get("000001");
		json_pfyh.put("name", pfyh.getName());
		json_pfyh.put("id", pfyh.getId());
		json_pfyh.put("yes", pfyh.getYesterday());
		json_pfyh.put("tod", pfyh.getToday());
		json_pfyh.put("now", pfyh.getNow());

		List list = new LinkedList();
		list.add(json_szzs);
		list.add(json_pfyh);
		json.put("stocks", list);
		
		return json.toString();
	}
}
