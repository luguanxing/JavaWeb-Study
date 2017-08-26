import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class upload extends HttpServlet {
	//注意要把commons-fileupload，commons-io放到tomcat/lib目录
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		try {
			//设置上传路径
			String root = request.getSession().getServletContext().getRealPath("/");
			String rootPath = root + "uploadfiles\\";
			File f = new File(rootPath);
			if (!f.exists()) {
				f.mkdir();
			}
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(f);

			//开始并解析上传内容
			ServletFileUpload fileupload = new ServletFileUpload(factory);
			fileupload.setHeaderEncoding("utf-8");
			List<FileItem> fileItems = fileupload.parseRequest(request);
			for(FileItem fileItem : fileItems) {
				if (fileItem.isFormField()) {	//普通字段
					String name = fileItem.getFieldName();
					String value = new String(fileItem.getString("utf-8"));
					writer.println(name + " => " + value + "<br/>");
				} else {	//文件
					//获得文件名
					String filename = fileItem.getName();
					writer.println("浏览器获取文件路径 =>" + filename + "<br/>");
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					writer.println("截取文件名 =>" + filename + "<br/>");
					String ext = filename.substring(filename.lastIndexOf(".")+1);
					writer.println("后缀名 =>" + ext + "<br/>");
					writer.println("<br/><br/><br/>");

					//获取大小限制
					long filesize = fileItem.getSize();
					writer.println("文件大小 =>" + filesize + "<br/>");
					if (filesize == 0) {
						fileItem.delete();
						throw new Exception("文件不存在");
					}
					if (filesize > 20000) {
						fileItem.delete();
						throw new Exception("文件太大");
					}
					writer.println("<br/><br/><br/>");


					File file = new File(rootPath + filename);
					file.createNewFile();
					InputStream in = fileItem.getInputStream();
					OutputStream out = new FileOutputStream(file);
					byte[] buffer = new byte[1024];
					int len;
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					writer.println("成功上传到目录 =>" + rootPath + filename + "<br/>");
					in.close();
					out.close();
					fileItem.delete();
				}
			}
		} catch (Exception e) {
			writer.println("出错了：" + e.getMessage());
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

}