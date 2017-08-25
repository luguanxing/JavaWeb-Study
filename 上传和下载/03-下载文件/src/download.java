import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2017/8/25.
 */
public class download extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String filename = req.getParameter("filename");
		if (filename != null && !filename.isEmpty()) {
			String root = req.getSession().getServletContext().getRealPath("/");
			String rootPath = root + "uploadfiles\\";
			String filepath = rootPath + filename;
			File file = new File(filepath);
			if (file.exists()) {
				resp.addHeader("Content-Type", "application/octet-stream");
				//注意要将UTF8中文名转成ISO_8859_1才能在下载框显示下载名
				resp.addHeader("Content-Disposition", "attachment;filename=" +  new String(filename.getBytes("utf-8"), "ISO_8859_1") );
				InputStream in = new FileInputStream(file);
				OutputStream out = resp.getOutputStream();
				byte[] buffer = new byte[1024];
				int len;
				while ((len = in.read(buffer)) != -1) {
					out.write(buffer, 0, len);
				}
			} else {
				PrintWriter writer = resp.getWriter();
				writer.write("文件不存在");
			}
		} else {
			PrintWriter writer = resp.getWriter();
			writer.write("参数不合法");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
