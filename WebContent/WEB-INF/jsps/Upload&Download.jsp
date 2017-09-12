    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <title>Document</title>
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
     <div class="col-md-5 col-md-offset-8">
        <div class="panel panel-default">
          <div class="panel-heading">
            <span class="glyphicon glyphicon glyphicon-file"></span>Document Uploading</div>
             <div class="panel-body">
              <form  action="uploadData" method="post" enctype="multipart/form-data" class="form-horizontal"  role="form">
           
           <!-- Text input-->
           <div class="form-group">
              <label for="textArea" class="col-sm-3 control-label">Description</label>
              <div class="col-sm-5">
                 <textarea rows="2" class="form-control" id="fileDesc" name="fileDesc"></textarea>
             </div>
           </div>
           <!-- Text input-->
           <div class="form-group">
              <label for="inputName3" class="col-sm-3 control-label">Document</label>
              <div class="col-sm-5">
                 <input type="file"  name="filessobj" class="form-control" required>
             </div>
             <div>
                 <button  type="submit" id="DocUpload" name="DocUpload" class="btn btn-success">Upload</button>
             </div>
          </div>
       </form>
    </div>
       <div class="panel-footer">
         <p><label>${msg}</label></p>
      </div>
     </div>
   </div>
</div>
<div class="row">
   <div class="col-md-11 col-md-offset-1">
       <div class="panel panel-default">
         <div class="panel-heading">
            <span class="glyphicon glyphicon glyphicon-file"></span>Document Download</div>
             <div class="panel-body">
                <table class="table">
                  <thead>
                    <tr>
                      <th>DocId</th>
			          <th>Name</th>
			          <th>Description</th>
                      <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                  <c:forEach items="${obList}" var="fOb">
                   <tr>
                     <td><c:out value="${fOb[0]}"/></td>
                     <td><c:out value="${fOb[1]}"/></td>
                     <td><c:out value="${fOb[2]}"/></td>
			         <td>
                        <a href='downloadFile?fileId=<c:out value="${fOb[0]}"/>' class="teal-text"><i class="glyphicon glyphicon-download-alt"></i></a>
                        <a href='deleteFile?FileId=<c:out value="${fOb[0]}"/>' class="red-text"><i class="glyphicon glyphicon-trash"></i></a>
                    </td>				
	             </c:forEach>
               </tbody>
          </table>
       </div>
     </div>
   </div>
</div>
</div>
<br><br>

<%@include file="vdmFooter.jsp" %>
