<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<%@include file="VendorHeader.jsp" %>
<script type="text/javascript">
  var pwd=document.adminform.venPwd.value;
if (!(document.adminForm.venConfPwd.value.match(pwd))) {
	document.getElementById("venPwdErr").innerHTML = '*Please entered correct conform Pwd';
	return false;
	}
	
</script>
<div class="container" style="marging-top:-0px;">
  <div class="row">
    <!-- left column -->
    <div class="col-md-4 col-sm-6 col-xs-12">
      <div class="text-center">
        <img src="http://lorempixel.com/200/200/people/9/" class="avatar img-circle img-thumbnail" alt="avatar">
      </div>
    </div>
    <!-- edit form column -->
    <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
      <div class="alert alert-info alert-dismissable">
        <a class="panel-close close" data-dismiss="alert">×</a> 
        <i class="fa fa-coffee"></i>
          <strong></strong>
      </div>
      <h3>Personal Information</h3>
       <form name="venForm" action="venChangePassword" method="post" class="form-horizontal" role="form">
         <div class="form-group">
          <label class="col-lg-3 control-label"></label>
          <div class="col-lg-8">
            <input  name="venId" class="form-control" value="${venObj.venId}" type="hidden" readonly required>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Name</label>
          <div class="col-lg-8">
            <input  class="form-control" value="${venObject.venFirstName} ${venObject.venLastName}" type="text" readonly required>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Email Id</label>
          <div class="col-lg-4">
            <input  class="form-control" value="${venObject.venEmail}" type="text" readonly>
          </div>
          <div class="col-lg-4">
            <input  class="form-control" value="${venObject.venSecEmail}" readonly type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Username</label>
          <div class="col-md-8">
            <input class="form-control" value="${venObject.venEmail}" type="text" readonly required>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Old Password</label>
          <div class="col-md-8">
            <input name="oldPwd" class="form-control" value="" type="password" required>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Password</label>
          <div class="col-md-8">
            <input name="pwd" class="form-control" value="" type="password" required>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Confirm password</label>
          <div class="col-md-8">
            <input name="conformPwd" class="form-control" value="" type="password" required>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label"></label>
          <div class="col-md-8" align="right">
            <input class="btn btn-primary" value="Save Changes" type="submit"><span id="venPwdErr"></span>
            <span></span>
            <input class="btn btn-default" value="Cancel" type="reset">
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
<br><br>
<%@include file="vdmFooter.jsp" %>