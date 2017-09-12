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
            <th>LocId</th>
			<th>Name</th>
			<th>Type</th>
			<th>City</th>
			<th>State</th>
			<th>Country</th>
			<th>Pin Code</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
       <c:forEach items="${locListObj}" var="loc">
       <tr>
            <th scope="row">1</th>
            <td><c:out value="${loc.locId}"/></td>
			<td><c:out value="${loc.locName}"/></td>
			<td><c:out value="${loc.locType}"/></td>
			<td><c:out value="${loc.locDist}"/></td>
			<td><c:out value="${loc.locState}"/></td>
			<td><c:out value="${loc.locCountry}"/></td>
			<td><c:out value="${loc.locPinCode}"/></td>
			<td>
               <a  class="blue-text"><i class="glyphicon glyphicon-user"></i></a>
               <a href="updateLoc?LocId=<c:out value="${loc.locId}"/>" class="teal-text"><i class="glyphicon glyphicon-edit"></i></a>
               <a href="deleteLoc?LocId=<c:out value="${loc.locId}"/>" class="red-text"><i class="glyphicon glyphicon-trash"></i></a>
            </td>				
	   </c:forEach>
    </tbody>
</table>
	<br><br>
	<%@include file="vdmFooter.jsp" %>