<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">  
  <title>Admin</title>
<style>
   body { 
          background: url(http://lorempixel.com/1920/1920/city/9/) no-repeat center center fixed; 
         -webkit-background-size: cover;
         -moz-background-size: cover;
         -o-background-size: cover;
          background-size: cover;
          }

   a:link, a:visited { 
       color:black; 
       text-decoration: none; 
       font-weight:900px;; 
     } 
   a:active, a:hover { 
       color:black; 
      text-decoration:none;
   }
   .panel-default {
           opacity: 0.9;
           margin-top:30px;
           margin-left:0px;
           }
   .form-group.last { margin-bottom:0px; }
 
   .priyakart-navbar {
       background-color:#337ab7;
       color: #FFFFFF;
	   margin-top:-20px;
	   margin-bottom:50px;
     }

   .row2 {
       margin-left:30px;
       padding-top: 20px;
       padding-bottom:0px;
      }
	  
   @media screen and (max-height: 450px) {
       .sidenav a {font-size: 18px;}
    }

    .container{
	    margin-top:-16px;
		margin-bottom:0px;
		
	}
 

</style>   
<div class="priyakart-navbar">	
  <div class="row row2">
        <div class="col-sm-2">
          <h2 style="margin-left:30px;"><span class="largenav">Vendor Hub</span></h2>
        </div>
  </div>
</div>	
<div class="container">
  <div class="row">
     <div class="col-md-6 col-md-offset-7">
        <div class="panel panel-default">
          <div class="panel-heading">
            <span class="glyphicon glyphicon-registration-mark"></span>Admin Registration</div>
             <div class="panel-body">
           <form  action="insertUser" method="post" class="form-horizontal" align="center" role="form">
            <!-- Text input-->
             <div class="form-group">
                 <label for="inputName3" class="col-sm-4 control-label">First Name</label>
             <div class="col-sm-7">
          <input type="text"  name="userFirstName" class="form-control"  placeholder="first name" required>
      </div>
   </div>
   <!-- Text input-->
    <div class="form-group">
         <label for="inputName3" class="col-sm-4 control-label">Last Name</label>
       <div class="col-sm-7">
          <input type="text"  name="userLastName" class="form-control"  placeholder="last Name" required>
       </div>
   </div>  
   <!-- Text input-->
     <div class="form-group">
         <label for="inputEmail3" class="col-sm-4 control-label">Email</label>
       <div class="col-sm-7">
           <input type="text"  name="userEmail" class="form-control"  placeholder="email" required>
        </div>
     </div> 
     
   <!-- Text input-->
     <div class="form-group">
         <label for="inputMobile3" class="col-sm-4 control-label">Mobile No</label>
       <div class="col-sm-7">
           <input type="text"  name="mobileNo" class="form-control"  placeholder="mobile no" required>
        </div>
     </div> 
    <!-- Text input-->
     <div class="form-group">
         <label for="DateOfBirth" class="col-sm-4 control-label">Date of Birth</label>
       <div class="col-sm-7">
           <input type="date"  name="dob" class="form-control" required>
        </div>
     </div>    
   <!-- --Test Input -->
      <div class="form-group">
          <label class="col-sm-4 control-label">Gender</label>
             <div class="col-sm-7">
                <div class="row">
                   <div class="col-sm-3">
                      <label class="radio-inline">
                        <input type="radio" name="gender" id="maleRadio" value="Male">Male
                      </label>
                   </div>
                  <div class="col-sm-3">
                     <label class="radio-inline">
                        <input type="radio" name="gender" id="femaleRadio" value="Female">Female
                      </label>
                   </div>
                </div>
           </div>
      </div> <!-- /.form-group -->
     <!-- Button -->
       <div class="form-group">
             <label class="col-md-4 control-label" for="signup"></label>
          <div class="col-md-4">
              <button  type="submit" id="signup" name="signup" class="btn btn-success">Submit</button>
               <button  type="reset" id="signup" name="signup" class="btn btn-success">Reset</button>
          </div>
       </div>
   </form>
</div>
     <div class="panel-footer">
        You Registred? <a href="home">Admin Login here</a></div>
     </div>
</div>
</div>
</div>
<br><br>
<%@include file="vdmFooter.jsp" %>

