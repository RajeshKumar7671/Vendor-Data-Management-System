<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   <title>Dashboard</title>     
<c:if test="${userObj!=null }">
  <%@include file="vdmHeader.jsp" %>
 </c:if>
 <c:if test="${venObj!=null }">
  <%@include file="VendorHeader.jsp" %>
 </c:if>
<table class="table">
    <thead>
        <tr>
            <th></th>
            <th>Name</th>
			<th>Monthly(Total)</th>
			<th>Weekly(Total)</th>
			<th>Today(Total)</th>
			<th>Yesterday(Total)</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
         <tr> 
            <td></td>
            <td>Seller Registered</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
               <a  class="blue-text"><i class="fa fa-user"> </i></a>
            </td>
        </tr>
         <tr> 
            <td></td>
            <td>Consumer Registered</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
               <a  class="blue-text"><i class="fa fa-user"> </i></a>
            </td>
        </tr>
         <tr> 
            <td></td>
            <td>Location Registered</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
               <a  class="blue-text"><i class="fa fa-user"> </i></a>
            </td>
        </tr>
        <tr> 
            <td></td>
            <td>Visitor</td>
            <td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
               <a  class="blue-text"><i class="fa fa-user"> </i></a>
            </td>
        </tr>	
        <tr> 
            <td></td>
            <td>Feedback</td>
            <td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
               <a  class="blue-text"><i class="fa fa-user"> </i></a>
            </td>
        </tr>	
        <tr> 
            <td></td>
            <td>Complain</td>
            <td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
               <a  class="blue-text"><i class="fa fa-user"> </i></a>
            </td>
        </tr>				
	</tbody>
</table>
	<br><br>
	<%@include file="vdmFooter.jsp" %>