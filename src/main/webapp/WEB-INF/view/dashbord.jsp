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
<title>Admin Dashbord</title>
  <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>navbar</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/The-School-Directory/resources/CSS/adminstyle.css">
        <link rel="stylesheet" href="/The-School-Directory/resources/CSS/admin.css">
</head>
<body>
 <%@ include file="header.jsp" %>
            <b><%@ include file="businessMessage.jsp"%></b>
            <!-- Page content -->
            <div class="main">
                <div class="cards-list">
                    <div class="card">
                      <div class="card_image"> <a class="card" href="<c:url value="/school/search"/>"><img src="/The-School-Directory/resources/Images/pexels-mudassir-ali-2680270.jpg"/> </a></div>
                      <div class="card_title title-black">
                        <p style="color:#edf0f1; font-size:100px;">${school}</p>
                        <p style="font-size: xx-large;color:#edf0f1;">No of Schools</p>
                      </div>
                    </div>

                    <div class="card">
                        <div class="card_image"> <img src="/The-School-Directory/resources/Images/pexels-mudassir-ali-2680270.jpg"/> </div>
                        <div class="card_title title-black">
                          <p style="color:#edf0f1; font-size:100px;">${suggestion}</p>
                          <p style="font-size: xx-large;color:#edf0f1;">Suggestions</p>
                        </div>
                    </div>
                </div>
            </div>

                    
</body>
</html>