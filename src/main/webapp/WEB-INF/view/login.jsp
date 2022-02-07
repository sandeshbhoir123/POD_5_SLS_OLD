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
<title>Admin Login</title>
 <link rel="stylesheet" href="/The-School-Directory/resources/CSS/adminLogin.css">
</head>
<body>
<div class="wrapper">
	<sf:form role="form" action="${pageContext.request.contextPath}/login" method="post" modelAttribute="form">
            <div id="formContent">
              <!-- Tabs Titles -->
              <h1 class="active" style="color: white;"> Sign In </h2>
              <b><%@ include file="businessMessage.jsp"%></b>
         	 
              <div>
                <img src="/The-School-Directory/resources/Images/login-icon-3048.png" id="icon" alt="User Icon" />
              </div>
              <!-- Login Form -->
              	<s:bind path="login">
                <sf:input type="email" id="login" path="${status.expression}" placeholder="Login Id"/>
                </s:bind>
                <s:bind path="password">
                <sf:input type="password" id="password" path="${status.expression}" placeholder="password"/>
                </s:bind>
                
                <input type="submit" value="SignIn" name="operation" >
          
              <!-- forgot Passowrd -->
              <div id="formFooter">
                <a class="underlineHover" href="<c:url value="/forgetPassword" />" style="color:#24252A;"><i>Forgot Password?</i></a>
              </div>
          
           </div>
           </sf:form>
         </div>
</body>
</html>