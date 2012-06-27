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

</head>
<body>
<style type="text/css">
    td.head {
        width: 400px;
        padding-right: 50px;
    }
</style>
<div id="content">
    <div class="contentbg">
        <div class="post">
            <h2 class="title">${title}</h2>
        </div>
        <div class="post">
            <div class="entry">

                <c:if test="${addresscard.image ne null}">
                      <img width="100" height="100" src="../image/cardimage.htm?cardid=${addresscard.addressCardId}"
                     alt="../image/flatimage.htm?flatid=${addresscard.addressCardId}"/>
                     <hr style="border-color: #7F7F81;"/>
                </c:if>

                <c:if test="${addresscard.image eq null}">
                      <img width="100" height="100" src="/OnlineAddressBook/resources/img/noimage.jpeg"
                     alt="/OnlineAddressBook/resources/img/noimage.jpeg"/>
                     <hr style="border-color: #7F7F81;"/>
                </c:if>


                <%--<form:form action="" modelAttribute="addresscard" method="POST" enctype="multipart/form-data">--%>
                <table>


                    <tr>
                        <td class="head">
                            <fmt:message key="card.name"/>

                        </td>
                        <td>

                            ${addresscard.name}
                        </td>
                    </tr>

                    <tr>
                        <td class="head">
                            <fmt:message key="card.fullName"/>

                        </td>
                        <td>


                            ${addresscard.fullName}
                        </td>
                    </tr>

                    <tr>
                        <td class="head">
                            <fmt:message key="card.email"/>

                        </td>
                        <td>

                            ${addresscard.email}
                        </td>
                    </tr>

                    <tr>
                        <td class="head">
                            <fmt:message key="card.organization"/>

                        </td>
                        <td class="head">

                            ${addresscard.organization}
                        </td>
                    </tr>

                    <tr>
                        <td class="head">
                            <fmt:message key="card.title"/>

                        </td>
                        <td>

                            ${addresscard.title}
                        </td>
                    </tr>

                    <tr>
                        <td class="head">
                            <fmt:message key="card.tel_home"/>

                        </td>
                        <td>

                            ${addresscard.tel_home}
                        </td>
                    </tr>

                    <tr>
                        <td class="head">
                            <fmt:message key="card.tel_office"/>

                        </td>
                        <td>


                            ${addresscard.tel_office}
                        </td>
                    </tr>

                    <tr>
                        <td class="head">
                            <fmt:message key="card.address"/>

                        </td>
                        <td>

                            ${addresscard.address}
                        </td>
                    </tr>

                </table>
                <br/>
                    <span style="float:left;"><a
                            href="/OnlineAddressBook/app/address/exportcard.htm?cardid=${addresscard.addressCardId}">Export
                        Card</a></span>
                    <span style="float:right;"><a
                            href="/OnlineAddressBook/app/address/edit.htm?cardid=${addresscard.addressCardId}">Edit
                        Card</a></span>


                <%--</form:form>--%>
            </div>
        </div>

        <div style="clear: both;">&nbsp;</div>
    </div>
</div>
</body>
</html>