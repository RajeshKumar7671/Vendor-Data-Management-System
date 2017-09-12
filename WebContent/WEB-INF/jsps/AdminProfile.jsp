<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<%@include file="vdmHeader.jsp" %>

<div class="container" style="marging-top:-10px;">
  <div class="row">
    <!-- left column -->
    <div class="col-md-4 col-sm-6 col-xs-12">
      <div class="text-center">
        <img src="http://lorempixel.com/200/200/people/9/" class="avatar img-circle img-thumbnail" alt="${userObject.userFirstName}">
      </div>
    </div>
    <!-- edit form column -->
    <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
      <h3 style="color:#337ab7">Personal Information:</h3>
      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label class="col-lg-3 control-label">Name</label>
          <div class="col-lg-8">
            <input class="form-control" value="${userObject.userFirstName} ${userObject.userLastName}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Primary Email</label>
          <div class="col-lg-8">
            <input class="form-control" value="${userObject.userEmail}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Secondary Email</label>
          <div class="col-lg-8">
            <input class="form-control" value="${userObject.userSecEmail}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Mobile No</label>
          <div class="col-lg-8">
            <input class="form-control" value="${userObject.mobileNum}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Username</label>
          <div class="col-md-8">
            <input class="form-control" value="${userObject.userEmail}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Password</label>
          <div class="col-md-8">
            <input class="form-control" value="${userObject.userPwd}" type="password" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Birthday</label>
          <div class="col-lg-3">
            <input class="form-control" value="${userObject.dob}" type="text" readonly>
          </div>
          <label class="col-lg-2 control-label">Gender</label>
          <div class="col-lg-3">
            <input class="form-control" value="${userObject.userGender}" type="text" readonly>
          </div>
        </div>
      </form>
       <h3 style="color:#337ab7">Current Address  :</h3>
      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label class="col-lg-3 control-label">Address Line1</label >
          <div class="col-lg-8">
            <input class="form-control" value="${userObject.addr.addr1}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Address Line1</label>
          <div class="col-lg-8">
            <input class="form-control" value="${userObject.addr.addr2}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">City Name</label>
          <div class="col-lg-3">
            <input class="form-control" value="${userObject.addr.city}" type="text" readonly>
          </div>
          <label class="col-lg-2 control-label">State</label>
          <div class="col-lg-3">
            <input class="form-control" value="${userObject.addr.state}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Country</label>
          <div class="col-md-3">
            <input class="form-control" value="${userObject.addr.country}" type="text" readonly>
          </div>
          <label class="col-md-2 control-label">Pin Code</label>
          <div class="col-md-3">
            <input class="form-control" value="${userObject.addr.pinCode}" type="text" readonly>
          </div>
        </div>
      </form>
        <h3 style="color:#337ab7">Others :</h3>
      <form class="form-horizontal" role="form">
        
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