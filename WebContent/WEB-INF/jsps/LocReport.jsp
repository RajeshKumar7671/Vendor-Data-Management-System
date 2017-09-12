<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<style>
 .container{
     margin-top:30px;
     margin-bottom:30px;
     margin-left:100px;
     padiing:30px;
 }
</style>
 <c:if test="${userObj!=null }">
  <%@include file="vdmHeader.jsp" %>
 </c:if>
 <c:if test="${venObj!=null }">
  <%@include file="VendorHeader.jsp" %>
 </c:if>

  <div class="container">
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../reportA.jpg" align="middle"/>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../reportB.jpg"  align="middle"/>
    </div>
  <br><br>
<%@include file="vdmFooter.jsp"%>