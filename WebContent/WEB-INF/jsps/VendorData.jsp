<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <meta charset="utf-8">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   <title>Vendor Data</title>
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
            <th>VenId</th>
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
       <c:forEach items="${venListObj}" var="ven">
       <tr>
            <th scope="row">1</th>
            <td><c:out value="${ven.venId}"/></td>
			<td><c:out value="${ven.venFirstName}"/></td>
			<td><c:out value="${ven.venLastName}"/></td>
			<td><c:out value="${ven.venEmail}"/></td>
			<td><c:out value="${ven.venMobile}"/></td>
			<td><c:out value="${ven.venDob}"/></td>
			<td><c:out value="${ven.venGender}"/></td>
			<td>
               <a href="venDetails?venId=<c:out value="${ven.venId}"/>" class="blue-text"><i class="glyphicon glyphicon-user"></i></a>
               <a href="updateVen?venId=<c:out value="${ven.venId}"/>" class="teal-text"><i class="glyphicon glyphicon-edit"></i></a>
               <a href="deleteVen?venId=<c:out value="${ven.venId}"/>" class="red-text"><i class="glyphicon glyphicon-trash"></i></a>
            </td>				
	   </c:forEach>
    </tbody>
</table>
	<br><br>
	<%@include file="vdmFooter.jsp" %>