<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Struts2标签库</title>
	</head>
	<body>
	
		<!-- form标签 -->
		<s:form>
			<!-- 普通输入项 -->
			<s:textfield name="username" label="username"></s:textfield>
			
			<!-- 文本域 -->
			<s:textarea rows="10" cols="3" name="resume" label="建立"></s:textarea>
			
			<!-- 密码输入项 -->
			<s:password name="password" label="password"></s:password>
			
			<!-- 单选输入项，文字和name相同 -->
			<s:radio list="{'女', '男'}" name="sex1" label="性别"></s:radio>
			
			<!-- 单选输入项，文字和name不同 -->
			<s:radio list="#{'female':'女', 'male':'男'}" name="sex2" label="性别"></s:radio>
			
			<!-- 多选输入项  -->
			<s:checkboxlist list="{'吃饭', '学习', '睡觉'}" name="love" label="爱好"></s:checkboxlist>
			
			<!-- 下拉输入框  -->
			<s:select list="{'博士', '博士后'}" name="college" label="学历"></s:select>
			
			<!-- 文件上传  -->
			<s:file name="file" label="文件上传"></s:file>
			
			<!-- 隐藏项  -->
			<s:hidden name="hidden" value="abc"></s:hidden>
			
			<!-- 提交项  -->
			<s:submit value="提交"></s:submit>
			
			<!-- 重置项  -->
			<s:reset value="重置"></s:reset>
		</s:form>
		
		
		
		
	</body>
</html>