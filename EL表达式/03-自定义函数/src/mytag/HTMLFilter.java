package mytag;
//注意不能放在默认包中否则不能引入

public class HTMLFilter {
	public static String filter(String message) {
		if (message == null)
			return null;
//		注意是转换单字符''不是转换字符串"",不能像下面一样
//		message = message.replaceAll("<", "&lt;");
//		message = message.replaceAll(">", "&gt;");
//		message = message.replaceAll("&", "&amp;");
//		message = message.replaceAll("\"", "&quot;");
		char content[] = new char[message.length()];
		message.getChars(0, message.length(), content, 0);
		StringBuilder sb = new StringBuilder();
		for (int i =0; i < content.length; i++) {
			switch (content[i]) {
				case '<':
					sb.append("&lt;");
					break;
				case '>':
					sb.append("&gt;");
					break;
				case '&':
					sb.append("&amp;");
					break;
				case '"':
					sb.append("quot;");
					break;
				default:
					sb.append(content[i]);
			}
		}
		return sb.toString();
	}
}
