package entity;

public class Son {

	private Integer son_id; // ���ӱ��(����)
	private String son_name;// ��������
	private String son_gender;// �����Ա�(������)
	private String son_phone;// ���Ӱ칫�绰
	
	//ÿ������ֻ����һ������
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
