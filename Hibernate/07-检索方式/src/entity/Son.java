package entity;

public class Son {

	private Integer son_id; // 儿子编号(主键)
	private String son_name;// 儿子姓名
	private String son_gender;// 儿子性别(。。。)
	private String son_phone;// 儿子办公电话
	
	//每个儿子只能有一个父亲
	private Father father;
	
	public Father getFather() {
		return father;
	}
	public void setFather(Father father) {
		this.father = father;
	}
	public Integer getSon_id() {
		return son_id;
	}
	public void setSon_id(Integer son_id) {
		this.son_id = son_id;
	}
	public String getSon_name() {
		return son_name;
	}
	public void setSon_name(String son_name) {
		this.son_name = son_name;
	}
	public String getSon_gender() {
		return son_gender;
	}
	public void setSon_gender(String son_gender) {
		this.son_gender = son_gender;
	}
	public String getSon_phone() {
		return son_phone;
	}
	public void setSon_phone(String son_phone) {
		this.son_phone = son_phone;
	}
	
}
