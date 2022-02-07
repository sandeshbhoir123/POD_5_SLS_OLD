<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
 <link rel="stylesheet" href="/The-School-Directory/resources/CSS/adminLogin.css">
</head>
<body>
<div class="wrapper">
	<sf:form role="form" action="${pageContext.request.contextPath}/forgetPassword" method="post" modelAttribute="form">
            <div id="formContent">
              <!-- Tabs Titles -->
              <h1 class="active" style="color: white;">Forget Password</h2>
              <b><%@ include file="businessMessage.jsp"%></b>
         	 
             
              <!-- Login Form -->
              	<s:bind path="login">
                <sf:input type="email" id="login" path="${status.expression}" placeholder="Login Id"/>
                </s:bind>
              
                
                <input type="submit" value="Go" name="operation" >
        
          
           </div>
           </sf:form>
         </div>
</body>
</html>