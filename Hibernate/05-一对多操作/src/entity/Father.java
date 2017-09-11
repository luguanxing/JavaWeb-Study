package entity;

import java.util.HashSet;
import java.util.Set;

public class Father {
	
	//父亲id
	private Integer fid;
	//父亲名称
	private String fatherName;
	//父亲级别
	private String fatherLevel;
	//父亲来源
	private String fatherSource;
	//联系电话
	private String fatherPhone;
	//手机
	private String fatherMobile;
	
	//一个父亲可能有多个儿子,hibernate要求用set集合表示从属
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
