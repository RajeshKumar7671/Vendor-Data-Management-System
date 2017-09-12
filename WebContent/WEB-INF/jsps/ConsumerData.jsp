<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <meta charset="utf-8">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   <title>Location</title>
<c:if test="${userObj!=null }">
  <%@include file="vdmHeader.jsp" %>
 </c:if>
 <c:if test="${venObj!=null }">
  <%@include file="VendorHeader.jsp" %>
 </c:if>
<table class="table">
    <thead>
        <tr>
            <th>#</th>
            <th>ConsumerId</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Id</th>
			<th>Mobile No</th>
			<th>Date of Birth</th>
			<th>Gender</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
       <c:forEach items="${consListObj}" var="cons">
       <tr>
            <th scope="row">1</th>
            <td><c:out value="${cons.consId}"/></td>
			<td><c:out value="${cons.consFirstName}"/></td>
			<td><c:out value="${cons.consLastName}"/></td>
			<td><c:out value="${cons.consEmail}"/></td>
			<td><c:out value="${cons.mobileNo}"/></td>
			<td><c:out value="${cons.dob}"/></td>
			<td><c:out value="${cons.gender}"/></td>
			<td>
               <a href="consDetails?consId=<c:out value="${cons.consId}"/>" class="blue-text"><i class="glyphicon glyphicon-user"></i></a>
            </td>				
	   </c:forEach>
    </tbody>
</table>
	<br><br>
	<%@include file="vdmFooter.jsp" %>