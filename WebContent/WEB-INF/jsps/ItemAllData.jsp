<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <meta charset="utf-8">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   <title>Item Approved</title>
 <c:if test="${venObj!=null }">
  <%@include file="VendorHeader.jsp" %>
 </c:if>   
 <c:if test="${userObj!=null}">
  <%@include file="vdmHeader.jsp" %>
 </c:if>  
<table class="table">
    <thead>
        <tr>
            <th>#</th>
			<th>Name</th>
			<th>Sub-Type</th>
			<th>B-Name</th>
			<th>MRP</th>
			<th>T-Date</th>
			<th>Discount</th>
			<th>V-Margin</th>
			<th>R-Value</th>
			<th>Quantity</th>
			<th>Status</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
       <c:forEach items="${itemListObj}" var="item">
       <tr>
            <th scope="row">1</th>
            <td><c:out value="${item.itemName}"/></td>
			<td><c:out value="${item.itemSubType}"/></td>
			<td><c:out value="${item.itemBrand}"/></td>
			<td><c:out value="${item.itemMrp}"/></td>
			<td><c:out value="${item.transactinDateAndTime}"/></td>
			<td><c:out value="${item.marginDiscount}%"/></td>
			<td><c:out value="${item.vendorMargin}"/></td>
			<td><c:out value="${item.rebateValue}"/></td>
			<td><c:out value="${item.avaliableQuantity}"/></td>
			<td><c:out value="${item.status}"/></td>
			<td>
               <a href="showSeller?sellerId=<c:out value="${item.sellerId}"/>" class="blue-text"><i class="glyphicon glyphicon-user"></i></a>
               <a href="showItemUpdate?itemId=<c:out value="${item.itemId}"/>" class="teal-text"><i class="glyphicon glyphicon-edit"></i></a>
               <a href="deleteItemByAdmin?itemId=<c:out value="${item.itemId}"/>" class="red-text"><i class="glyphicon glyphicon-trash"></i></a>
            </td>
            </tr>			
	   </c:forEach>
    </tbody>
</table>
	<br><br>
	<%@include file="vdmFooter.jsp" %>