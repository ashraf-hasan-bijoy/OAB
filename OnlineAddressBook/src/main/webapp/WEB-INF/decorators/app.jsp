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
            <li class="current_page_item"><a href="/OnlineAddressBook/app/home.htm"><span>Home</span></a></li>
            <li><a href="/OnlineAddressBook/app/address/cardlist.htm"><span>Address List</span></a></li>
            <li><a href="/OnlineAddressBook/app/logout.htm"><span>logout</span></a></li>
        </ul>
        <script type="text/javascript">
            $('#menu').dropotron();
        </script>
    </div>
    <!-- end #menu -->
    <div id="splash"><img src="/OnlineAddressBook/resources/img/pic4.jpg" width="980" height="160" alt=""/></div>
    <div id="page">
        <decorator:body/>
        <!-- end #content -->
        <div id="sidebar-bg">
            <div id="sidebar">
                <ul>
                    <li>
                        <h2>Search for</h2>
                        <ul>
                            <li><a href="/OnlineAddressBook/app/address/search.htm">Address</a></li>
                        </ul>
                    </li>
                    <li>
                        <h2>Add new</h2>
                        <ul>
                            <li><a href="/OnlineAddressBook/app/address/create.htm">Address</a></li>
                        </ul>
                    </li>
                    <li>
                        <h2>Import</h2>
                        <ul>
                            <li><a href="/OnlineAddressBook/app/address/importcard.htm">Address</a></li>
                        </ul>
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
