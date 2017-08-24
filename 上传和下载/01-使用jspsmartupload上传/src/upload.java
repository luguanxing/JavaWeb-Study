/**
 * Created by Administrator on 2017/8/24.
 */

import com.jspsmart.upload.SmartUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class upload extends HttpServlet {

	private ServletConfig config;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config = config;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String root = request.getSession().getServletContext().getRealPath("/");
		String rootPath = root + "files\\";
		File f = new File(rootPath);
		if (!f.exists()) {
			f.mkdir();
		}
		SmartUpload mySmartUpload = new SmartUpload();
		PrintWriter out = response.getWriter();
		try {
			mySmartUpload.initialize(config, request, response);
			mySmartUpload.upload();
			com.jspsmart.upload.File file = mySmartUpload.getFiles().getFile(0);
			if (file.getSize() > 20000) {
				Exception exception = new Exception("文件大小超过20000");
				throw exception;
			}
			if (file.getSize() == 0) {
				Exception exception = new Exception("文件不存在");
				throw exception;
			}
			String savePath = rootPath + UUID.randomUUID() + "." + file.getFileExt();
			file.saveAs(savePath);
			out.write("上传成功，已保存到："+savePath);
		} catch (Exception e) {
			out.println("上传失败：" + e.getMessage());
		}
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	}

}
