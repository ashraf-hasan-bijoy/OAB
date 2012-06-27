<%--
  Created by IntelliJ IDEA.
  User: ashraf
  Date: 5/31/12
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="/spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>

    <title>Simple jsp page</title>
    <style type="text/css">
        span.error {
            color: #D8000C;
        }
    </style>
</head>
<body>
<div id="content">
    <div class="contentbg">
        <div class="post">
            <h2 class="title">${title}</h2>
        </div>
        <div class="post">
            <div class="entry">
                <form:form action="" modelAttribute="addresscard" method="POST" enctype="multipart/form-data">
                    <table>
                        <tr>
                            <td>
                                <fmt:message key="card.name"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="name"/><br/>
                                <span class="error"><form:errors path="name"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="card.fullName"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>

                                <form:input path="fullName"/><br/>
                                <span class="error"><form:errors path="fullName"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="card.email"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="email"/><br/>
                                <span class="error"><form:errors path="email"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="card.organization"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="organization"/><br/>
                                <span class="error"><form:errors path="organization"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="card.title"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="title"/><br/>
                                <span class="error"><form:errors path="title"/></span>
                            </td>
                        </tr>

                         <tr>
                            <td>
                                <fmt:message key="card.tel_home"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="tel_home"/><br/>
                                <span class="error"><form:errors path="tel_home"/></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="card.tel_office"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>

                                <form:input path="tel_office"/><br/>
                                <span class="error"><form:errors path="tel_office"/></span>
                            </td>
                        </tr>

                         <tr>
                            <td>
                                <fmt:message key="card.address"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:textarea path="address" cols="40" rows="5"/><br/>
                                <span class="error"><form:errors path="address"/></span>
                            </td>
                        </tr>

                    </table>


                    <input type="submit" value="<fmt:message key="flatOwner.submit"/>"/>

                </form:form>
            </div>
        </div>

        <div style="clear: both;">&nbsp;</div>
    </div>
</div>
</body>
</html>