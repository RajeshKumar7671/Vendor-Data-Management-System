<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  
    <title>Location</title>  
    <c:if test="${userObj!=null }">
      <%@include file="vdmHeader.jsp" %>
    </c:if>
    <c:if test="${venObj!=null }">
      <%@include file="VendorHeader.jsp" %>
    </c:if>
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
            <span class="glyphicon glyphicon-registration-mark"></span>Register Location</div>
             <div class="panel-body">
              <form  action="insertLoc" method="post" class="form-horizontal"  role="form">
      <!-- Text input-->
   <div class="form-group">
         <label for="inputName3" class="col-sm-4 control-label">Name</label>
      <div class="col-sm-7">
          <input type="text"  name="locName" class="form-control"  placeholder="Location Name" required>
      </div>
   </div>
    <!-- --Radio Button -->
      <div class="form-group">
          <label class="col-sm-4 control-label">Type</label>
             <div class="col-sm-7">
                <div class="row">
                   <div class="col-sm-3">
                      <label class="radio-inline">
                        <input type="radio" name="locType" id="urbanRadio" value="Urban">Urban
                      </label>
                   </div>
                  <div class="col-sm-3">
                     <label class="radio-inline">
                        <input type="radio" name="locType" id="ruralRadio" value="Rural">Rural
                      </label>
                   </div>
                </div>
           </div>
     </div> <!-- /.form-group -->
     <!-- Text input-->
     <div class="form-group">
         <label for="inputDistict3" class="col-sm-4 control-label">Distict</label>
       <div class="col-sm-7">
          <input type="text"  name="locDist" class="form-control"  placeholder="Distict Name" required>
       </div>
   </div>  
  <!-- Select Basic -->
  <div class="form-group">
     <label  for="state" class="col-sm-4 control-label">State</label>
      <div class="col-sm-7">
        <select id="State" name="locState" class="form-control">
             <option value="Andhra Pradesh">Andhra Pradesh</option>
             <option value="Arunachal Pradesh">Arunachal Pradesh</option>
             <option value="Assam">Assam</option>
             <option value="Bihar" selected>Bihar</option>
             <option value="Chandigarh">Chandigarh</option>
             <option value="Chhattisgarh">Chhattisgarh</option>
             <option value="Delhi">Delhi</option>
             <option value="Gujarat">Gujarat</option>
             <option value="Haryana">Haryana</option>
             <option value="Himachal Pradesh">Himachal Pradesh</option>
             <option value="Jharkhand">Jharkhand</option>
             <option value="Karnataka">Karnataka</option>
             <option value="Madhya Pradesh">Madhya Pradesh</option>
             <option value="Maharashtra">Maharashtra</option>
             <option value="Orissa">Orissa</option>
             <option value="Punjab">Punjab</option>
             <option value="Rajasthan">Rajasthan</option>
             <option value="Tamil Nadu">Tamil Nadu</option>
             <option value="Uttar Pradesh">Uttar Pradesh</option>
             <option value="West Bengal">West Bengal</option>
          </select>
       </div>
    </div> 
     <!-- Select Basic -->
  <div class="form-group">
     <label  for="country" class="col-sm-4 control-label">Country</label>
      <div class="col-sm-7">
        <select id="Country" name="locCountry" class="form-control">
           <option value="India">India</option>
           <option value="Nepal">Nepal</option>
        </select>
       </div>
    </div> 
    <!-- Text input-->
    <div class="form-group">
         <label for="inputPinCode3" class="col-sm-4 control-label">Pin Code</label>
       <div class="col-sm-7">
          <input type="text"  name="locPinCode" class="form-control"  placeholder="Pin Code" required>
       </div>
    </div>  
     <!-- Text input-->
     <div class="form-group">
         <label for="DateOfCreated" class="col-sm-4 control-label">Date Of Reg.</label>
        <div class="col-sm-7">
           <input type="date"  name="locDate" class="form-control" required>
        </div>
     </div>    
     <!-- Button -->
       <div class="form-group">
             <label class="col-md-4 control-label" for="Location Registration"></label>
          <div class="col-md-4">
              <button  type="submit" id="logReg" name="locReg" class="btn btn-success">Create Location</button>
          </div>
       </div>
   </form>
</div>
   <div class="panel-footer">
     <p><label>${locRegMsg}</label></p>
   </div>
</div>
</div>
</div>
</div>
<br><br>
<%@include file="vdmFooter.jsp" %>