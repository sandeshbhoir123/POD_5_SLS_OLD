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
<title>Criteria for admission </title>
<link  rel="stylesheet" type="text/css" href="/The-School-Directory/resources/CSS/register/style.css">
<script src="https://kit.fontawesome.com/yourcode.js"></script>
</head>
<body>
 <section></section>
        <div class="container">
             <sf:form role="form" action="${pageContext.request.contextPath}/signUp" method="post" modelAttribute="form">
                <h1>Add School</h1>
                <h1>Fill the criteria</h1>
                   <b><%@ include file="businessMessage.jsp"%></b>
               <s:bind path="name">
                <div class="id">
                    <sf:input type="text"  path="${status.expression}" placeholder="Enter  Name"/>
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                <s:bind path="contactNo">
                <div class="id">
                  <sf:input type="text"  path="${status.expression}" placeholder="Enter Contact No"/>
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                
                <s:bind path="gender">
                <div class="id">
                    <label for="t3"><h2>Gender:</h2></label>
                    <sf:radiobutton  path="${status.expression}" value="Female"/>Female<sf:radiobutton  path="${status.expression}" value="Male"/>Male
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                
               <s:bind path="email">
                <div class="id">
                  <sf:input type="text"  path="${status.expression}" placeholder="Enter Email Id"/>
                    <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
               </s:bind>
               
                <s:bind path="distance">
                <div class="id">
                    <label for="t4"><h2>Distance from bus stand:</h2></label>
                    <sf:radiobutton class="t4"  path="${status.expression}" value="1km"/>Within 1km<sf:radiobutton  path="${status.expression}" value="1-2kms"/>1-2kms<sf:radiobutton  path="${status.expression}" value="2-3kms"/>2-3kms
                     <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                
                 <s:bind path="affiliation">
                <div class="id">
                    <label for=""><h2>Affiliation Board:</h2></label>
                    <sf:radiobutton class="t4"  path="${status.expression}" value="CBSE"/>CBSE
                    <sf:radiobutton  class="t4"  path="${status.expression}" value="ICSE"/>ICSE
                    <sf:radiobutton  class="t4" path="${status.expression}" value="State Board"/>State Board
                     <font color="red"><sf:errors path="${status.expression}"/></font>
                </div>
                </s:bind>
                <s:bind path="fee">
                <sf:input class="last" type="text" path="${status.expression}" placeholder="Desired Education Fee Range"/>
                 <font color="red"><sf:errors path="${status.expression}"/></font>
                </s:bind>
                <!--Submission buttons-->
                 <input type="submit" value="Search" name="operation" >
     		  <input type="submit" value="Cancel" name="operation" >
            </sf:form>
        </div>
</body>
</html>