package myTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/22.
 */
public class ToUpperCase extends BodyTagSupport {
	
	@Override
	public int doEndTag() throws JspException {
		String content = this.getBodyContent().getString();
		content = content.toUpperCase();
		try {
			//输出数据
			//this.pageContext.getOut().write(content);
			this.bodyContent.getEnclosingWriter().write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}
	
}
