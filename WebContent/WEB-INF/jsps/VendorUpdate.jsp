<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <title>Vendor Update</title>
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
            <span class="fa fa-pencil"></span>Vendor</div>
             <div class="panel-body">
    <form name="venForm" action="venUpdate" method="post"  class="form-horizontal"  role="form">
      <!-- Text input-->
     <div class="form-group">
         <label for="inputName3" class="col-sm-4 control-label"></label>
        <div class="col-sm-7">
          <input type="hidden"  name="venId" class="form-control"  value="${venObject.venId}" required>
        </div>
     </div>
      <!-- Text input-->
   <div class="form-group">
         <label for="inputName3" class="col-sm-4 control-label">First Name</label>
      <div class="col-sm-7">
          <input type="text"  name="venFirstName" class="form-control"  value="${venObject.venFirstName}" required>
      </div>
   </div>
   <!-- Text input-->
    <div class="form-group">
         <label for="inputName3" class="col-sm-4 control-label">Last Name</label>
       <div class="col-sm-7">
          <input type="text"  name="venLastName" class="form-control"  value="${venObject.venLastName}" required>
       </div>
   </div>  
   <!-- Text input-->
     <div class="form-group">
         <label for="inputEmail3" class="col-sm-4 control-label">Email</label>
       <div class="col-sm-7">
           <input type="text"  name="venEmail" class="form-control"   value="${venObject.venEmail}"  readonly required>
        </div>
     </div> 
     <!-- Select Basic -->
      <!-- Text input-->
    <div class="form-group">
         <label for="inputEmail3" class="col-sm-4 control-label">Password</label>
       <div class="col-sm-7">
           <input type="password"  name="venPwd" class="form-control"   value="${venObject.venPwd}"  readonly required>
        </div>
    </div> 
     <!-- Select Basic -->
   <div class="form-group">
     <label  for="country" class="col-sm-4 control-label">Location</label>
      <div class="form-group">
       <label  for="LocationName" class="col-sm-4 control-label"></label>
         <div class="col-sm-7">
           <select id="LocName" name="loc.locId" class="form-control">
             <c:forEach items="${locListObj}" var="loc">
                <c:if test="${loc.locId eq venObject.loc.locId}">
			        <option value="">Select Location</option>
			        <option value="${loc.locId}" selected="selected"><c:out value="${loc.locName},${loc.locDist},${loc.locState}--${loc.locPinCode}"/></option>
                </c:if>
                <c:if test="${loc.locId != venObject.loc.locId}">
                    <option value="${loc.locId}"><c:out value="${loc.locName},${loc.locDist},${loc.locState}--${loc.locPinCode}"/></option>
                 </c:if>
             </c:forEach>    
           </select>
         </div>
       </div>
   </div>
    <!-- Text input-->
     <div class="form-group">
         <label for="inputApplicationNo3" class="col-sm-4 control-label">Application No.</label>
       <div class="col-sm-7">
           <input type="text"  name="venAppNo" class="form-control"  value="${venObject.venAppNo}" required>
        </div>
     </div> 
    <!-- Text input-->
     <div class="form-group">
         <label for="DateOfJoining" class="col-sm-4 control-label">Date of Joining</label>
       <div class="col-sm-7">
           <input type="date"  name="venJoinDate" class="form-control" value="${venObject.venJoinDate}" required>
        </div>
     </div>
    <!-- Text input-->
     <div class="form-group">
         <label for="ProfId" class="col-sm-4 control-label">Attached Id</label>
       <div class="col-sm-7">
           <input type="file"  name="venProfId" title="Adhar Card/Voter Id/Driving Licences" value="${venObject.venProfId}" class="form-control" required>
        </div>
     </div>
   <!-- Text input-->
     <div class="form-group">
         <label for="inputMobile3" class="col-sm-4 control-label">Mobile No</label>
       <div class="col-sm-7">
           <input type="text"  name="venMobile" class="form-control"  value="${venObject.venMobile}" required>
        </div>
     </div> 
    <!-- Text input-->
     <div class="form-group">
         <label for="DateOfBirth" class="col-sm-4 control-label">Date of Birth</label>
       <div class="col-sm-7">
           <input type="date"  name="venDob" class="form-control" value="${venObject.venDob}" required>
        </div>
     </div>    
   <!-- --Test Input -->
      <div class="form-group">
          <label class="col-sm-4 control-label">Gender</label>
             <div class="col-sm-7">
                <div class="row">
                <c:choose>
				 <c:when test="${venObject.venGender eq 'Male'}">
                   <div class="col-sm-3">
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
				<c:otherwise>
				     <div class="col-sm-3">
                      <label class="radio-inline">
                        <input type="radio" name="venGender" id="maleRadio" value="Male">Male
                      </label>
                   </div>
                  <div class="col-sm-3">
                     <label class="radio-inline">
                        <input type="radio" name="venGender" id="femaleRadio" value="Female" checked="checked">Female
                      </label>
                   </div>
				</c:otherwise>
			    </c:choose>
                </div>
           </div>
      </div> <!-- /.form-group -->
     <!-- Button -->
       <div class="form-group">
             <label class="col-md-4 control-label" for="signup"></label>
          <div class="col-md-4">
              <button  type="submit" id="venReg" name="venReg" class="btn btn-success">Update</button>
              <button  type="reset"  class="btn btn-success"><a href="viewAllVen">Cancel</a></button>
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