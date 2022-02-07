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
                <img src="<c:url value="/school/getLogo/${form.id}"/>" alt="" class="logo">&nbsp;
                ${form.name}
            </h1>
        </div>
        <div class="imgdiv">
            <img class="schoolimg" src="<c:url value="/school/getImage/${form.id}"/>" alt="">
        </div>
        <div class="about">
            <h2>About School</h2>
            <p>${form.about}</p>
        </div>
        <div class="details">
            <h2>More Info</h2>
            <table>
                <tr>
                    <td>
                        <img class="icon" src="/The-School-Directory/resources/SchoolList/Icons/pin.png" alt="">
                    </td>
                    <td>${form.location}</td>
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
                    <td>${form.emailId}</td>
                </tr>
                <tr>
                    <td>Affiliation:</td>
                    <td>${form.affiliation}</td>
                </tr>
                <tr>
                    <td>
                        Rating:
                    </td>
                    <td>${form.rating}</td>
                </tr>
            </table>
        </div>
        <div class="about">
            <table class="website">
                <tr >
                    <td class="row"><h4>Website :</h4></td>
                    <td class="row"><div class="Click">
                        <a href="${form.website}">Click Here</a>
                    </div></td>
                </tr>
            </table>
        </div>
    </body>

</html>