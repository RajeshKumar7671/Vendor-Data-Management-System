<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consumer Details</title>
<c:if test="${userObj!=null }">
  <%@include file="vdmHeader.jsp" %>
 </c:if>
 <c:if test="${venObj!=null }">
  <%@include file="VendorHeader.jsp" %>
 </c:if>
<div class="container" style="marging-top:-10px;">
  <div class="row">
    <!-- left column -->
    <div class="col-md-4 col-sm-6 col-xs-12">
      <div class="text-center">
        <img src="http://lorempixel.com/200/200/people/9/" class="avatar img-circle img-thumbnail" alt="avatar">
      </div>
    </div>
    <!-- edit form column -->
    <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
      <h3 style="color:#337ab7">Personal Information:</h3>
      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label class="col-lg-3 control-label">Name</label>
          <div class="col-lg-8">
            <input class="form-control" value="${consObject.consFirstName} ${consObject.consLastName}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Primary Email</label>
          <div class="col-lg-8">
            <input class="form-control" value="${consObject.consEmail}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Secondary Email</label>
          <div class="col-lg-8">
            <input class="form-control" value="" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Mobile No</label>
          <div class="col-lg-8">
            <input class="form-control" value="${consObject.mobileNo}" type="text" readonly>
          </div>
        </div>
      </form>
       <h3 style="color:#337ab7">Current Address  :</h3>
      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label class="col-lg-3 control-label">Address Line1</label>
          <div class="col-lg-8">
            <input class="form-control" value="${consObject.addr.addr1}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Address Line2</label>
          <div class="col-lg-8">
            <input class="form-control" value="${consObject.addr.addr2}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">City Name</label>
          <div class="col-lg-3">
            <input class="form-control" value="${consObject.addr.city}" type="text" readonly>
          </div>
          <label class="col-lg-2 control-label">State</label>
          <div class="col-lg-3">
            <input class="form-control" value="${consObject.addr.state}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Country</label>
          <div class="col-md-3">
            <input class="form-control" value="${consObject.addr.country}" type="text" readonly>
          </div>
          <label class="col-md-2 control-label">Pin Code</label>
          <div class="col-md-3">
            <input class="form-control" value="${consObject.addr.pinCode}" type="text" readonly>
          </div>
        </div>
      </form>
         <h3 style="color:#337ab7">Others :</h3>
      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label class="col-lg-3 control-label">Birthday</label>
          <div class="col-lg-3">
            <input class="form-control" value="${consObject.dob}" type="text" readonly>
          </div>
          <label class="col-lg-2 control-label">Gender</label>
          <div class="col-lg-3">
            <input class="form-control" value="${consObject.gender}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Language</label>
          <div class="col-lg-3">
            <input class="form-control" value="" type="text" readonly>
          </div>
          <label class="col-lg-2 control-label">Interest</label>
          <div class="col-lg-3">
            <input class="form-control" value="" type="text" readonly>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
<br><br>
<%@include file="vdmFooter.jsp" %>