<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC首页</title>
</head>
<body>
	<h2>这是首页</h2>
	<form:form modelAttribute="user" action="/wangdh.learner.springmvc/home/add.do">
		<table>
			<tr>
				<td><form:label path="name">姓名</form:label></td>
				<td><form:input path="name"/></td>
			</tr>		
		
			<tr>
				<td colspan="2">
					<input type="submit" value="提交"/>
				</td>
			</tr>
		</table>
	</form:form>



</body>
</html>