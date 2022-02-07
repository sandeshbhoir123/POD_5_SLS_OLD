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
<title>Add School</title>
  <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link  rel="stylesheet" type="text/css" href="/The-School-Directory/resources/CSS/register/style.css">
		<script src="https://kit.fontawesome.com/yourcode.js"></script>
</head>
<body>
           <section></section>
        <div class="container">
           <sf:form role="form" action="${pageContext.request.contextPath}/school" method="post" modelAttribute="form" enctype="multipart/form-data">
                <h1>Add School</h1>
                <b><%@ include file="businessMessage.jsp"%></b>
                <sf:hidden path="id"/>
                <s:bind path="name">
                <div class="id">
                    <sf:input type="text"  path="${status.expression}" placeholder="Enter School Name"/>
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                <s:bind path="contactNo">
                <div class="id">
                  <sf:input type="text"  path="${status.expression}" placeholder="Enter Contact No"/>
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                <s:bind path="emailId">
                <div class="id">
                  <sf:input type="text"  path="${status.expression}" placeholder="Enter Email Id"/>
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                
                <s:bind path="location">
                <div class="id">
                  <sf:input type="text"  path="${status.expression}" placeholder="Enter Location"/>
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                
                <s:bind path="affiliation">
                <div class="id">
                  <sf:input type="text"  path="${status.expression}" placeholder="Enter Affiliation"/>
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                
                <s:bind path="rating">
                <div class="id">
                  <sf:input type="text"  path="${status.expression}" placeholder="Enter Rating"/>
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                
                  <s:bind path="website">
                <div class="id">
                  <sf:input type="text"  path="${status.expression}" placeholder="Enter Website"/>
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                
                    <s:bind path="distance">
                <div class="id">
                  <sf:input type="text"  path="${status.expression}" placeholder="Enter Distance"/>
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                
                   <s:bind path="free">
                <div class="id">
                  <sf:input type="text"  path="${status.expression}" placeholder="Enter Fee"/>
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                
                
                 <s:bind path="logo">
                <div class="id">
                  <sf:input type="file"  path="${status.expression}" placeholder="Enter Logo"/>
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                   
                <s:bind path="image">
                <div class="id">
                  <sf:input type="file"  path="${status.expression}" placeholder="Enter Image"/>
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                
                <s:bind path="about">
                <sf:textarea path="${status.expression}" cols="15" rows="5" placeholder="Enter About School..."/>
                <font color="red"><sf:errors path="${status.expression}"/></font>
               </s:bind>
               
                
     		  <input type="submit" value="Save" name="operation" >
     		  <input type="submit" value="Reset" name="operation" >
            </sf:form>
        </div>

                    
</body>
</html>