package pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 包装类，根据部分字段查询
 */

public class QueryVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private User user;
	List<Integer> idsList;
	Integer[] ids;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getIdsList() {
		return idsList;
	}

	public void setIdsList(List<Integer> idsList) {
		this.idsList = idsList;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

}
