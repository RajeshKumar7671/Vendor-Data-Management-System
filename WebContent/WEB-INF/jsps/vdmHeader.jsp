<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <meta name="keywords" content="footer, address, phone, icons" />
   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
   <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
 
  <style>
   body{
	    margin: 0;
	    padding: 0;
	    line-height: 1.5em;
	    font-family: Georgia, "Times New Roman", Times, serif;
	    font-size: 17px;
	    color: #555a4a;
        background: #e9e9e9;
     }
   .priyakart-navbar {
       background-color:#337ab7;
       color: #FFFFFF;
	   margin-top:-19px;
	   margin-bottom:50px;
     }

   .row1{
       margin-right:50px;
       margin-top:20px;
       padding-bottom:0px;
      }

   .row2 {
       margin-left:63px;
       margin-top:-40px;
       padding-bottom:20px;
      }
	   
   @media screen and (max-height: 450px) {
       .sidenav a {font-size: 18px;}
    }

    .container{
	    margin-top:-20px;
		margin-bottom:0px;
		margin-left:40px;
		
	}
	/* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-top: -1px;
      border-radius: 0;
    }
    
	.container-fluid{
	 background-color:#FFFFFF;
		color:black;
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
</style>
  
 <div class="priyakart-navbar">
<div class="row row1">
  <div class="col-dm-1">
    <c:choose>
	    <c:when test="${userObj eq null}">   
	    </c:when>
		<c:otherwise>
		<ul class="nav navbar-nav navbar-right">
          <li class="dropdown">
		     <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span><b>Your Account<span class="caret"></span></b></a>
		     <ul class="dropdown-menu">
               <li><a href="adminPro?userId=<c:out value="${userObj.userId}"/>"><span class="glyphicon glyphicon-user"></span>Profile</a></li>
               <li><a href="adminSett?userId=<c:out value="${userObj.userId}"/>"><span class="glyphicon glyphicon-cog"></span>Setting</a></li>
               <li><a href="adminChangePwd?userId=<c:out value="${userObj.userId}"/>"><span class="glyphicon glyphicon-edit"></span>Change Password</a></li>
                <li><a href="userLogout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
            </ul>
		 </li>
	    </ul> 
		</c:otherwise>
	</c:choose>
   </div>
   </div>
   <div class="row row2">
        <div class="col-sm-2">
          <h2><span class="largenav">Vendor Hub</span></h2>
        </div>
    </div>
    <div class="container">
     <div class="navbar-header ">
      <button type="button" class="navbar-toggle color-black" data-toggle="collapse" data-target="#myNavbarbottom">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbarbottom">
      <ul class="nav navbar-nav navbar-left">
		<li><a class="dropdown-toggle" href="vdmHome">HOME</a> </li>
        <li class="dropdown" >
		   <a class="dropdown-toggle" data-toggle="dropdown" href="#">LOCATION<span class="caret"></span></a>
		  <ul class="dropdown-menu">
            <li><a href="regLoc">Register</a></li>
            <li><a href="viewAllLoc">View All</a></li>
          </ul> 
		</li>
		<li class="dropdown" >
		  <a class="dropdown-toggle" data-toggle="dropdown" href="#">VENDOR<span class="caret"></span></a>
		   <ul class="dropdown-menu">
            <li><a href="regVen">Register</a></li>
            <li><a href="viewAllVen">View All</a></li>
          </ul> 
		</li>
		<li class="dropdown" >
		   <a class="dropdown-toggle" data-toggle="dropdown" href="#">CUSTOMER<span class="caret"></span></a>
		   <ul class="dropdown-menu">
            <li><a href="viewAllSeller">Seller</a></li>
            <li><a href="viewAllCons">Consumer</a></li>
          </ul> 
		</li>
		<li class="dropdown" >
		   <a class="dropdown-toggle" data-toggle="dropdown" href="#">DOCUMENT <span class="caret"></span></a>
		   <ul class="dropdown-menu">
            <li><a href="uploadFile">Upload&Download</a></li>
          </ul> 
		</li>
		<li class="dropdown" >
		   <a class="dropdown-toggle" data-toggle="dropdown" href="#">REPORT<span class="caret"></span></a>
		   <ul class="dropdown-menu">
            <li><a href="locRep">Location</a></li>
            <li><a href="#">Vendor</a></li>
            <li><a href="#">Seller</a></li>
            <li><a href="#">Consumer</a></li>
            <li><a href="#">Item</a></li>
          </ul> 
		</li>
		<li class="dropdown" >
		   <a class="dropdown-toggle" data-toggle="dropdown" href="#">APPROVAL<span class="caret"></span></a>
		   <ul class="dropdown-menu">
            <li><a href="showAllPendingItem">Pending Item</a></li>
            <li><a href="showAllApprovalItem">Approval Item</a></li>
            <li><a href="showAllRejectItem">Reject Item</a></li>
          </ul> 
		</li>
		<li class="dropdown" >
		   <a class="dropdown-toggle" data-toggle="dropdown" href="#">ITEM<span class="caret"></span></a>
		   <ul class="dropdown-menu">
            <li><a href="showAllItem">Item List</a></li>
          </ul> 
		</li>
      </ul>
    </div>
  </div>		
</div>