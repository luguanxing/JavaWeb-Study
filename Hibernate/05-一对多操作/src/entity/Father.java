package entity;

import java.util.HashSet;
import java.util.Set;

public class Father {
	
	//����id
	private Integer fid;
	//��������
	private String fatherName;
	//���׼���
	private String fatherLevel;
	//������Դ
	private String fatherSource;
	//��ϵ�绰
	private String fatherPhone;
	//�ֻ�
	private String fatherMobile;
	
	//һ�����׿����ж������,hibernateҪ����set���ϱ�ʾ����
	private Set<Son> sons = new HashSet<Son>();
	
	public Set<Son> getSons() {
		return sons;
	}
	public void setSons(Set<Son> sons) {
		this.sons = sons;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getFatherLevel() {
		return fatherLevel;
	}
	public void setFatherLevel(String fatherLevel) {
		this.fatherLevel = fatherLevel;
	}
	public String getFatherSource() {
		return fatherSource;
	}
	public void setFatherSource(String fatherSource) {
		this.fatherSource = fatherSource;
	}
	public String getFatherPhone() {
		return fatherPhone;
	}
	public void setFatherPhone(String fatherPhone) {
		this.fatherPhone = fatherPhone;
	}
	public String getFatherMobile() {
		return fatherMobile;
	}
	public void setFatherMobile(String fatherMobile) {
		this.fatherMobile = fatherMobile;
	}
	
}
