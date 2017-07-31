package stock;

/**
 * Created by Administrator on 2017/7/31.
 */

//保存股票的基本信息：收盘价，开盘价，当前价，股票名，唯一标识
public class Stock {
	private double yesterday;
	private double today;
	private double now;
	private String name;
	private String id;

	public Stock(double yesterday, double today, String name, String id) {
		this.yesterday = yesterday;
		this.today = today;
		this.name = name;
		this.id = id;
		this.now = this.today;
	}

	public double getYesterday() {
		return yesterday;
	}

	public void setYesterday(double yesterday) {
		this.yesterday = yesterday;
	}

	public double getToday() {
		return today;
	}

	public void setToday(double today) {
		this.today = today;
	}

	public double getNow() {
		return now;
	}

	public void setNow(double now) {
		this.now = now;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.getName() + ":" + this.getNow();
	}
}
