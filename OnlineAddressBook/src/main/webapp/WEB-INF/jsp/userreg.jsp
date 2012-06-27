
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="/spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name : Commercial
Description: A two-column, fixed-width design with simple color scheme.
Version : 1.0
Released : 20120520
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>OnlineAddressBook</title>
    <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css"/>
    <link href="/OnlineAddressBook/resources/css/style.css" rel="stylesheet" type="text/css" media="screen"/>
    <script type="text/javascript" src="/OnlineAddressBook/resources/js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="/OnlineAddressBook/resources/js/jquery.dropotron-1.0.js"></script>
</head>
<body>
<div id="wrapper">
    <div id="header-wrapper">
        <div id="header">
            <div id="logo">
                <h1><a href="#">Online Address Book</a></h1>

                <p>Make your Address in your hand ...</p>
            </div>
        </div>
    </div>
    <!-- end #header -->
    <div id="menu-wrapper">
        <ul id="menu">
            <li class="current_page_item"><a href="/OnlineAddressBook/app/welcome.htm"><span>Home</span></a></li>
            <li><a href="/OnlineAddressBook/app/userreg.htm"><span>Register</span></a></li>
            <li><a href="#"><span>About</span></a></li>
        </ul>
        <script type="text/javascript">
            $('#menu').dropotron();
        </script>
    </div>
    <!-- end #menu -->
    <div id="splash"><img src="/OnlineAddressBook/resources/img/pic4.jpg" width="980" height="160" alt=""/></div>

    <div id="page">




<style type="text/css">
        span.error{
            color: #D8000C;
            font-size: 12px;
        }
</style>
<div id="content">
    <div class="contentbg">
        <div class="post">
            <h2 class="title">${title}</h2>
        </div>
        <div class="post">
            <div class="entry">
                <form:form action="" modelAttribute="userForm" method="post">
                    <table>
                        <tr>
                            <td>
                                <fmt:message key="user.name"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="fullName"/><br/>
                                <span class="error"><form:errors path="fullName"/></span>
                            </td>
                        </tr>



                        <tr>
                            <td>
                                <fmt:message key="user.email"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:input path="email"/><br/>
                                <span class="error"><form:errors path="email" /></span>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <fmt:message key="user.password"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:password path="password"/><br/>
                                <span class="error"><form:errors path="password"/></span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <fmt:message key="user.confirmPassword"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <form:password path="confirmPassword"/><br/>
                                <span class="error"><form:errors path="confirmPassword"/></span>
                            </td>
                        </tr>
                    </table>
                    </br>
                    <input type="submit" value="<fmt:message key="user.submit"/>"/>
                </form:form>
            </div>
        </div>

        <div style="clear: both;">&nbsp;</div>
    </div>
</div>




        <!-- end #content -->
        <div id="sidebar-bg">
            <div id="sidebar">
                <ul>
                    <li>
                        <h2>Log in</h2>

                        <form action="/OnlineAddressBook/app/login.htm" method="post">
                            <ul>
                                <li>
                                    <label>Email :</label><br/>
                                    <input type="text" name="email"/>
                                </li>
                                <li>
                                    <label>Password :</label><br/>
                                    <input type="password" name="password"/>
                                </li>
                                <br/>
                                <c:if test="${param['errorcode'] == 1}">
                                    <span class="error">invalid email or password</span>
                                </c:if>
                                <li>
                                    <input type="submit" value="Log in"/>
                                </li>


                            </ul>
                        </form>

                    </li>
                </ul>
            </div>
        </div>
        <!-- end #sidebar -->
        <div style="clear: both;">&nbsp;</div>
    </div>
    <!-- end #page -->
</div>
<div id="footer">
    <p>All rights reserved by OnlineAddressBook</p>
</div>
<!-- end #footer -->
</body>
</html>
