<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<%@include file="VendorHeader.jsp" %>

<div class="container" style="marging-top:-10px;">
  <div class="row">
    <!-- left column -->
    <div class="col-md-4 col-sm-6 col-xs-12">
      <div class="text-center">
        <img src="http://lorempixel.com/200/200/people/9/" class="avatar img-circle img-thumbnail" alt="${venObject.venFirstName}">
      </div>
    </div>
    <!-- edit form column -->
    <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
      <div class="alert alert-info alert-dismissable">
        <a class="panel-close close" data-dismiss="alert">×</a> 
        <i class="fa fa-coffee"></i>
         <strong></strong>
      </div>
      <h3 style="color:#337ab7">Personal Information:</h3>
      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label class="col-lg-3 control-label">Name</label>
          <div class="col-lg-8">
            <input class="form-control" value="${venObject.venFirstName}  ${venObject.venLastName}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Username</label>
          <div class="col-md-8">
            <input class="form-control" value="${venObject.venEmail}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Password</label>
          <div class="col-md-8">
            <input class="form-control" value="${venObject.venPwd}" type="password" readonly>
          </div>
        </div>
       <div class="form-group">
          <label class="col-lg-3 control-label">Mobile No</label>
          <div class="col-lg-8">
            <input class="form-control" value="${venObject.venMobile}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label"> Email Address</label>
          <div class="col-lg-4">
            <input class="form-control" value="${venObject.venEmail}" type="text" readonly>
          </div>
          <div class="col-lg-4">
            <input class="form-control" value="${venObject.venSecEmail}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Date of Joining</label>
          <div class="col-md-3">
            <input class="form-control" value="${venObject.venJoinDate}" type="date" readonly>
          </div>
          <label class="col-md-2 control-label">Apply Id</label>
          <div class="col-md-3">
            <input class="form-control" value="${venObject.venAppNo}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Birthday</label>
          <div class="col-lg-3">
            <input class="form-control" value="${venObject.venDob}" type="date" readonly>
          </div>
          <label class="col-lg-2 control-label">Gender</label>
          <div class="col-lg-3">
            <input class="form-control" value="${venObject.venGender}" type="text" readonly>
          </div>
        </div>
      </form>
       <h3 style="color:#337ab7">Working Location  :</h3>
      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label class="col-lg-3 control-label">Area Name</label >
          <div class="col-lg-8">
            <input class="form-control" value="${venObject.loc.locName}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Type</label>
          <div class="col-lg-8">
            <input class="form-control" value="${venObject.loc.locType}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">City Name</label>
          <div class="col-lg-3">
            <input class="form-control" value="${venObject.loc.locDist}" type="text" readonly>
          </div>
          <label class="col-lg-2 control-label">State</label>
          <div class="col-lg-3">
            <input class="form-control" value="${venObject.loc.locState}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Country</label>
          <div class="col-md-3">
            <input class="form-control" value="${venObject.loc.locCountry}" type="text" readonly>
          </div>
          <label class="col-md-2 control-label">Pin Code</label>
          <div class="col-md-3">
            <input class="form-control" value="${venObject.loc.locPinCode}" type="text" readonly>
          </div>
        </div>
      </form>
       <h3 style="color:#337ab7">Current Address  :</h3>
      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label class="col-lg-3 control-label">Address Line1</label >
          <div class="col-lg-8">
            <input class="form-control" value="${venObject.addr.addr1}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Address Line2</label>
          <div class="col-lg-8">
            <input class="form-control" value="${venObject.addr.addr2}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">City Name</label>
          <div class="col-lg-3">
            <input class="form-control" value="${venObject.addr.city}" type="text" readonly>
          </div>
          <label class="col-lg-2 control-label">State</label>
          <div class="col-lg-3">
            <input class="form-control" value="${venObject.addr.state}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Country</label>
          <div class="col-md-3">
            <input class="form-control" value="${venObject.addr.country}" type="text" readonly>
          </div>
          <label class="col-md-2 control-label">Pin Code</label>
          <div class="col-md-3">
            <input class="form-control" value="${venObject.addr.pinCode}" type="text" readonly>
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