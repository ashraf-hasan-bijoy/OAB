<%@ taglib prefix="decorator" uri="/SiteMash" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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



<div id="content">
    <div class="contentbg">
        <div class="post">
            <h2 class="title">Welcome to Online Address Book</h2>

            <div class="entry">
                <p>21th century is the age of digital and dynamic social communication. With the technological
                    advancement, our life became so dynamic that automated solutions for our conventional communicative
                    activities, is now the demand of time. In our country, with the booming increase of population, the
                    housing sector is drawing our attention greatly for accommodation solutions. But all the
                    communicative activities related to this sector are still manual and time consuming. So the online
                    solution for communication, dedicated to this sector has become essential to make our life easy.</p>

                <p> This system aims to automate the communication among all the stakeholders acting in the housing
                    sector of Bangladesh. From a person seeking flats to rent or purchase, to a giant housing developer
                    looking for a platform to advertise its ongoing and future projects, can be an active part of our
                    system. People searching to buy or rent flats in specific region or criteria, will be able to find
                    flats fulfilling their demand. Registered users can subscribe to the posts of flats meeting to their
                    provided criteria. Flat related posts for rent or sell will be provided by Flat owners and housing
                    developers. Flat owners and housing developers can also subscribe to the information of the system
                    users, searching for flats to buy or rent.</p>

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
