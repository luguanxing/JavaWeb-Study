package myTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/22.
 */
public class Repeat extends SimpleTagSupport {
	
	private int num;
	
	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jf = this.getJspBody();			//获取标签体
		for (int i = 0; i < num; i++) {
			jf.invoke(null);					//循环执行
		}
		
	}
}
