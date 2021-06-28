<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
body {
    padding : 0;
    margin : 0;
}
header {
    background-color: #867AE9;
}
.layout {
    width: 68%;
    margin : 0 auto;
}
.layout > a {
    display: inline-block;
    padding : 18px;
    color: white;
    text-decoration: none;
}
.topmenu {
    
}
</style>

<body>
	<header>
        <div class="topmenu layout">
            <span>줄일 주소를 입력해주세요</span>
            <form action="go/master/a"method="GET">
            	<input type="text" name="originUri"></input>
            	<input type="submit" value="변환"></input>
            </form>

             <%
    if(request.getParameter("shortCode")!=null){
    %>
            <h1>변환된 주소 : <%=request.getParameter("shortCode") %></h1>
            <%} %>
             <form action="go/master/t"method="POST">
            		<input type="submit" value="주소모를때"></input>
            </form>
        </div>
    </header>
</body>
</html>