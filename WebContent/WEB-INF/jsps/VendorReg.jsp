<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <title>Vendor</title>
<c:if test="${userObj!=null }">
  <%@include file="vdmHeader.jsp" %>
 </c:if>
 <c:if test="${venObj!=null }">
  <%@include file="VendorHeader.jsp" %>
 </c:if>
 
 <script type="text/javascript">
  $(document).ready(function() {
    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    if (month < 10) month = "0" + month;
    if (day < 10) day = "0" + day;

    var today = year + "-" + month + "-" + day;       
    $("#theDate").attr("value", today);
   });
</script> 
<style>
     body { 
          background: url(http://lorempixel.com/1920/1920/city/9/) no-repeat center center fixed; 
         -webkit-background-size: cover;
         -moz-background-size: cover;
         -o-background-size: cover;
         background-size: cover;
         }
     .panel-default {
           opacity: 0.9;
           margin-top:30px;
           margin-left:0px;
         }
     .form-group.last { margin-bottom:0px; }
</style>

<div class="container">
  <div class="row">
     <div class="col-md-6 col-md-offset-7">
        <div class="panel panel-default">
          <div class="panel-heading">
            <span class="glyphicon glyphicon-registration-mark"></span> Register to Vendor</div>
             <div class="panel-body">
    <form name="venForm" action="insertVen" method="post"  class="form-horizontal"  role="form">
      <!-- Text input-->
   <div class="form-group">
         <label for="inputName3" class="col-sm-4 control-label">First Name</label>
      <div class="col-sm-7">
          <input type="text"  name="venFirstName" class="form-control"  placeholder="first name" required>
      </div>
   </div>
   <!-- Text input-->
    <div class="form-group">
         <label for="inputName3" class="col-sm-4 control-label">Last Name</label>
       <div class="col-sm-7">
          <input type="text"  name="venLastName" class="form-control"  placeholder="last Name" required>
       </div>
   </div>  
   <!-- Text input-->
     <div class="form-group">
         <label for="inputEmail3" class="col-sm-4 control-label">Email</label>
       <div class="col-sm-7">
           <input type="text"  name="venEmail" class="form-control"  placeholder="email" required>
        </div>
     </div> 
     <!-- Select Basic -->
   <div class="form-group">
     <label  for="country" class="col-sm-4 control-label">Location</label>
      <div class="form-group">
       <label  for="LocationName" class="col-sm-4 control-label"></label>
         <div class="col-sm-7">
           <select id="LocName" name="loc.locId" class="form-control">
			        <option value="">Select Location</option>
                 <c:forEach items="${locListObj}" var="loc">
                   <option value="${loc.locId}"><c:out value="${loc.locName},${loc.locDist},${loc.locState}--${loc.locPinCode}"/></option>
                 </c:forEach>
           </select>
         </div>
       </div>
   </div>
    <!-- Text input-->
     <div class="form-group">
         <label for="inputApplicationNo3" class="col-sm-4 control-label">Application No.</label>
       <div class="col-sm-7">
           <input type="text"  name="venAppNo" class="form-control"  placeholder="Application No" required>
        </div>
     </div> 
    <!-- Text input-->
     <div class="form-group">
         <label for="DateOfJoining" class="col-sm-4 control-label">Date of Joining</label>
       <div class="col-sm-7">
           <input type="date"  name="venJoinDate" class="form-control" id="theDate" required>
        </div>
     </div>
    <!-- Text input-->
     <div class="form-group">
         <label for="ProfId" class="col-sm-4 control-label">Attached Id</label>
       <div class="col-sm-7">
           <input type="file"  name="venProfId" title="Adhar Card/Voter Id/Driving Licences"class="form-control" required>
        </div>
     </div>
   <!-- Text input-->
     <div class="form-group">
         <label for="inputMobile3" class="col-sm-4 control-label">Mobile No</label>
       <div class="col-sm-7">
           <input type="text"  name="venMobile" class="form-control"  placeholder="mobile no" required>
        </div>
     </div> 
    <!-- Text input-->
     <div class="form-group">
         <label for="DateOfBirth" class="col-sm-4 control-label">Date of Birth</label>
       <div class="col-sm-7">
           <input type="date"  name="venDob" class="form-control" required>
        </div>
     </div>    
   <!-- --Test Input -->
      <div class="form-group">
          <label class="col-sm-4 control-label">Gender</label>
             <div class="col-sm-7">
                <div class="row">
                   <div class="col-sm-3">
                      <label class="radio-inline">
                        <input type="radio" name="venGender" id="maleRadio" value="Male">Male
                      </label>
                   </div>
                  <div class="col-sm-3">
                     <label class="radio-inline">
                        <input type="radio" name="venGender" id="femaleRadio" value="Female">Female
                      </label>
                   </div>
                </div>
           </div>
      </div> <!-- /.form-group -->
     <!-- Button -->
       <div class="form-group">
             <label class="col-md-4 control-label" for="signup"></label>
          <div class="col-md-4">
              <button  type="submit" id="venReg" name="venReg" class="btn btn-success">Submit</button>
              <button  type="reset" id="venReset" name="venReset" class="btn btn-success">Reset</button>
          </div>
       </div>
   </form>
</div>
   <div class="panel-footer">
     <p><label>${venRegMsg}</label></p>
   </div>
</div>
</div>
</div>
</div>
<br><br>
<%@include file="vdmFooter.jsp" %>