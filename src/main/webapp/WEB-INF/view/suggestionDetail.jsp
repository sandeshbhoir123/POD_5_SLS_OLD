<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head><link rel="stylesheet" href="/The-School-Directory/resources/SchoolList/CSS/SchoolStyle.css"></head>
    <title>${form.name}</title>
    <body>
        <div class="UpperTitle">
            <img class="demo-bg" src="https://krmangalam.com/wp-content/uploads/2018/09/education-background-18.jpg" alt="">
            <h1 class="HeadTitle">
                ${form.schoolName}
            </h1>
        </div>
        
        <div class="about">
            <h2>About School</h2>
            <p>${form.about}</p>
        </div>
        <div class="details">
            <h2>More Info</h2>
            <table>
            
             	<tr>
                    <td>Suggestion User Name : ${form.name}</td>
                </tr>
                
                <tr>
                    <td>Suggestion User Email : ${form.email}</td>
                </tr>
                <tr>
                    <td>
                        <img class="icon" src="/The-School-Directory/resources/SchoolList/Icons/pin.png" alt="">
                    </td>
                    <td>${form.schoolAddress}</td>
                </tr>
                <tr>
                    <td>
                        <img class="icon" src="/The-School-Directory/resources/SchoolList/Icons/telephone-receiver-with-circular-arrows.png" alt="">
                    </td>
                    <td>
                        ${form.contactNo}
                    </td>
                </tr>
                <tr>
                    <td>
                        <img class="icon" src="/The-School-Directory/resources/SchoolList/Icons/email.png" alt="">
                    </td>
                    <td>${form.schoolEmailId}</td>
                </tr>
                <tr>
                    <td>Affiliation:</td>
                    <td>${form.affliation}</td>
                </tr>
            </table>
        </div>
    </body>

</html>