<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String scheme = request.getScheme();
	String serverName = request.getServerName();
	String remoteName = request.getRemoteAddr();
	String realIP = request.getHeader("X-Forward-For");
	String realIP2 = request.getHeader("X-Real-IP");
	String Host = request.getHeader("Host");
	int port = request.getServerPort();
	int portR = request.getRemotePort();
	String requestURIC1 = scheme + "://" + realIP;
	String requestURIC2 = scheme + "://" + realIP2 + ":" + portR;
	String requestURIC3 = scheme + "://" + remoteName + ":" + portR;
	String requestURI = scheme + "://" + serverName + ":" + port;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	客户端请求地址<%=requestURIC1%>
	<br> 服务器应用地址:<%=requestURIC3%>
	<br> 请求服务器地址:<%=requestURI%>
	<br> 服务器Host:<%=Host%>
	<br>
</body>
</html>