<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Setting</title>
<%@include file="vdmHeader.jsp" %>
<div class="container" style="marging-top:0px;">
  <div class="row">
    <!-- left column -->
       <h3 style="color:#337ab7">Current Address  :</h3>
      <form  name="addForm" action="insertAddr" method="post" class="form-horizontal">
        <div class="form-group">
          <label class="col-lg-3 control-label">Address Line1</label>
          <div class="col-lg-8">
            <input  name="addr1" class="form-control" value="" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Address Line1</label>
          <div class="col-lg-8">
            <input name="addr2" class="form-control" value="" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">City Name</label>
          <div class="col-lg-3">
            <input name="city" class="form-control" value="" type="text">
          </div>
          <label class="col-lg-2 control-label">State</label>
          <div class="col-lg-3">
            <input  name="state" class="form-control" value="" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Country</label>
          <div class="col-md-3">
            <input name="country" class="form-control" value="" type="text">
          </div>
          <label class="col-md-2 control-label">Pin Code</label>
          <div class="col-md-3">
            <input name="pinCode" class="form-control" value="" type="text">
          </div>
        </div>
         <div class="form-group">
          <label class="col-md-3 control-label"></label>
          <div class="col-md-8"  align="right">
            <input type="submit" class="btn btn-primary" value="Save Changes" >
            <span></span>
            <input  class="btn btn-default" value="Cancel" type="reset">
          </div>
        </div>
      </form>
    </div>
  </div>
<br><br>
<%@include file="vdmFooter.jsp" %>
       