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
<title>Suggestion School List</title>
 <link rel="stylesheet" href="/The-School-Directory/resources/SchoolList/CSS/SchoolList.css">
</head>
<body>
   <!-- Title Division Declaration and Adding the title in a separate division-->
        <div class="UpperTitle">
            <img class="demo-bg" src="https://krmangalam.com/wp-content/uploads/2018/09/education-background-18.jpg" alt="">
            <h1 class="HeadTitle">Suggestions Schools</h1>
        </div>
        <b><%@ include file="businessMessage.jsp"%></b>
        <!--Using table to display a structured view of page content -->
        <table>
        <c:forEach items="${list}" var="sc" varStatus="school">
            <tr>
                <!--Adding the Schools as a link -->
                <!--Each link is added as a table data row-wise--> 
                <td>
                    <a href="<c:url value="/suggestion/detail?id=${sc.id}"/>">
                        <div class="cell">
                           ${sc.schoolName}
                        </div>
                    </a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <!--Each link redirects the user to a separate page for each school respectively-->
</body>
</html>