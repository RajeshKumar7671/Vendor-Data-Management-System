<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Setting</title>
<c:if test="${userObj!=null }">
  <%@include file="vdmHeader.jsp" %>
 </c:if>
 <c:if test="${venObj!=null }">
  <%@include file="VendorHeader.jsp" %>
 </c:if>
<div class="container" style="marging-top:0px;">
  <div class="row">
    <!-- left column -->
    <div class="col-md-4 col-sm-6 col-xs-12">
      <div class="text-center">
        <img src="http://lorempixel.com/200/200/people/9/" class="avatar img-circle img-thumbnail" alt="avatar">
        <input type="file" class="text-center center-block well well-sm">
      </div>
    </div>
    <!-- edit form column -->
    <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
      <div class="alert alert-info alert-dismissable">
        <a class="panel-close close" data-dismiss="alert">×</a> 
        <i class="fa fa-coffee"></i>
        Fill the <strong>Correct</strong>  information.
      </div>
      <h3 style="color:#337ab7">Personal Information</h3>
      <form action="venSettUpdate" method="post" class="form-horizontal" role="form">
         <div class="form-group">
          <label class="col-lg-3 control-label"></label>
          <div class="col-lg-8">
            <input  name="venId" class="form-control" value="${venObj.venId}" type="hidden" readonly>
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-lg-3 control-label">First name</label>
          <div class="col-lg-8">
            <input  name="venFirstName" class="form-control" value="${venObject.venFirstName}" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Last name</label>
          <div class="col-lg-8">
            <input name="venLastName" class="form-control" value="${venObject.venLastName}" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Username</label>
          <div class="col-md-8">
            <input name="venEmail" class="form-control" value="${venObject.venEmail}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Password</label>
          <div class="col-md-8">
            <input  name="venPwd" class="form-control" value="${venObject.venPwd}" type="password" readonly>
          </div>
        </div>
       <div class="form-group">
          <label class="col-md-3 control-label">Date of Joining</label>
          <div class="col-md-3">
            <input name="venJoinDate" class="form-control" value="${venObject.venJoinDate}" type="date" readonly>
          </div>
          <label  class="col-md-2 control-label">Apply Id</label>
          <div class="col-md-3">
            <input name="venAppNo" class="form-control" value="${venObject.venAppNo}" type="text" readonly>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Email Id</label>
          <div class="col-lg-4">
            <input class="form-control" value="${venObject.venEmail}" type="text" readonly>
          </div>
          <div class="col-lg-4">
            <input name="venSecEmail" class="form-control" value="${venObject.venSecEmail}" type="text" placeholder="Enter Secondry Email Id">
          </div>
        </div>
         <div class="form-group">
          <label class="col-lg-3 control-label">Mobile No</label>
          <div class="col-lg-3">
            <input name="venMobile" class="form-control" value="${venObject.venMobile}" type="text">
          </div>
          <label class="col-lg-2 control-label">Birthday</label>
          <div class="col-lg-3">
            <input name="venDob" class="form-control" value="${venObject.venDob}" type="date">
          </div>
        </div>
       <!-- --Test Input -->
      <div class="form-group">
          <label class="col-sm-3 control-label">Gender</label>
             <div class="col-sm-8">
                <div class="row">
                <c:choose>
				 <c:when test="${venObject.venGender eq 'Male'}">
                   <div class="col-sm-2">
                      <label class="radio-inline">
                        <input type="radio" name="venGender" id="maleRadio" value="Male" checked="checked">Male
                      </label>
                   </div>
                  <div class="col-sm-3">
                     <label class="radio-inline">
                        <input type="radio" name="venGender" id="femaleRadio" value="Female">Female
                      </label>
                   </div>
                  </c:when>
                  <c:when test="${venObject.venGender eq 'Female'}">
                     <div class="col-sm-2">
                      <label class="radio-inline">
                        <input type="radio" name="venGender" id="maleRadio" value="Male">Male
                      </label>
                   </div>
                  <div class="col-sm-3">
                     <label class="radio-inline">
                        <input type="radio" name="venGender" id="femaleRadio" value="Female" checked="checked">Female
                      </label>
                   </div>
                  </c:when>
				<c:otherwise>
				     <div class="col-sm-2">
                      <label class="radio-inline">
                        <input type="radio" name="venGender" id="maleRadio" value="Male">Male
                      </label>
                   </div>
                  <div class="col-sm-3">
                     <label class="radio-inline">
                        <input type="radio" name="venGender" id="femaleRadio" value="Female">Female
                      </label>
                   </div>
				</c:otherwise>
			    </c:choose>
                </div>
           </div>
      </div> <!-- /.form-group -->
        <div class="form-group">
          <label class="col-md-3 control-label"></label>
          <div class="col-md-8"  align="right">
            <input  class="btn btn-primary" value="Save Changes" type="submit">
            <span></span>
            <input  class="btn btn-default" value="Cancel" type="reset">
          </div>
        </div>
      </form>
       <h3 style="color:#337ab7">Current Address  </h3>
      <form  action="venAddrUpdate" method="post" class="form-horizontal" role="form">
        <div class="form-group">
          <label class="col-lg-3 control-label"></label>
          <div class="col-lg-8">
            <input  name="venId" class="form-control" value="${venObject.venId}" type="hidden">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Address Line1</label>
          <div class="col-lg-8">
            <input  name="addr1" class="form-control" value="${venObject.addr.addr1}" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Address Line2</label>
          <div class="col-lg-8">
            <input name="addr2" class="form-control" value="${venObject.addr.addr2}" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">City Name</label>
          <div class="col-lg-3">
            <input name="city" class="form-control" value="${venObject.addr.city}" type="text">
          </div>
          <label class="col-lg-2 control-label">State</label>
          <div class="col-lg-3">
            <input  name="state" class="form-control" value="${venObject.addr.state}" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Country</label>
          <div class="col-md-3">
            <input name="country" class="form-control" value="${venObject.addr.country}" type="text">
          </div>
          <label class="col-md-2 control-label">Pin Code</label>
          <div class="col-md-3">
            <input name="pinCode" class="form-control" value="${venObject.addr.pinCode}" type="text">
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
</div>
<br><br>
<%@include file="vdmFooter.jsp" %>