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
                <form:form action="" modelAttribute="importcard" method="POST" enctype="multipart/form-data">
                    <table>


                         <tr>
                            <td>
                                <fmt:message key="card.file"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <input type="file" name="cardFile"/>
                            </td>
                        </tr>



                    </table>
                    </br>

                    <input type="submit" value="<fmt:message key="card.import"/>"/>

                </form:form>
            </div>
        </div>

        <div style="clear: both;">&nbsp;</div>
    </div>
</div>
</body>
</html>