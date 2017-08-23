package myTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/22.
 */
public class ShowIp extends TagSupport {
	@Override
	public int doStartTag() throws JspException {
		String ip = this.pageContext.getRequest().getRemoteAddr();
		String host = this.pageContext.getRequest().getRemoteHost();
		try {
			//输出用户IP地址
			pageContext.getOut().write("您的IP地址为: " + ip + "<br/>");
			pageContext.getOut().write("您的host主机名为: " + host + "<br/>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
