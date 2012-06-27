<%--
  Created by IntelliJ IDEA.
  User: ashraf
  Date: 5/29/12
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head></head>
<body>
<style type="text/css">
span.error {
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
                <form action="/OnlineAddressBook/app/address/search.htm"  method="POST">
                    <table>
                        <tr>
                            <td>
                                <fmt:message key="card.pattern"/>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                            </td>
                            <td>
                                <input name="pattern"/><br/>
                                <c:if test="${param.error ne null}">
                                    <span class="error">Invalid Search</span>
                                </c:if>
                            </td>
                        </tr>
                    </table>

                    <input type="submit" value="<fmt:message key="card.search"/>"/>

                </form>
            </div>
        </div>

        <c:if test="${addresscardlist ne  null and fn:length(addresscardlist) == 0}">
            <div  class="post">
                <div class="entry">
                    <span style="text-align:center;">No results found for your query.</span>
                </div>
            </div>
        </c:if>

        <c:forEach items="${addresscardlist}" var="card">
            <div class="post">
                <div class="entry">
                    <a href="/OnlineAddressBook/app/address/view.htm?cardid=${card.addressCardId}">${card.fullName}  ${card.organization} ${card.title}</a>
                    <span style="float:right;"><a href="/OnlineAddressBook/app/address/delete.htm?cardid=${card.addressCardId}"style="float:right;">Delete criteria</a></span>
                </div>
            </div>

        </c:forEach>
        <%--<div style="float:right;">
            <c:forEach begin="1" end="${pagecount}" var="counter">

                <c:if test="${param['curr'] eq counter}">
                    <a href="/BdHousingPortal/cus/criteria/view.htm?curr=${counter}" style="color:#dc143c;">
                            ${counter}
                    </a>

                </c:if>
                <c:if test="${param['curr'] ne counter}">
                    <a href="/BdHousingPortal/cus/criteria/view.htm?curr=${counter}">
                            ${counter}
                    </a>
                </c:if>
                &nbsp;

            </c:forEach>
        </div>--%>
        <div style="clear: both;">&nbsp;</div>
    </div>
</div>
</body>

</html>