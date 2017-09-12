
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
	   margin-top:-20px;
	   margin-bottom:10px;
     }

   .row1{
       margin-left:0px;
       padding-top:0px;
       padding-bottom:0px;
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
  <div class="row row2">
        <div class="col-sm-2">
          <h2 style="margin-left:30px;"><span class="largenav">Vendor App</span></h2>
        </div>
  </div>
<div class="container">
   <div class="row row1">
      <div class="col-dm-2">
            <form class="navbar-form navbar-right" action="loginUser" method="post">
               <div class="form-group">
                     <input type="text" class="form-control" name="userId" placeholder="Username">
               </div>
               <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="Password">
               </div>
                  <button type="submit" class="btn btn-default">Admin Login</button>
             </form>
        </div>
     </div>
   </div>
  <div class="navbar-header ">
      <button type="button" class="navbar-toggle color-white" data-toggle="collapse" data-target="#myNavbarbottom">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
   </div>
  <div class="collapse navbar-collapse" id="myNavbarbottom">
      <ul class="nav navbar-nav">
         <li class="active"><a href="home">HOME</a></li>
         <li><a href="learning">LEARNING</a></li>
         <li><a href="faq">FAQS</a></li>
         <li><a href="http://localhost:8084/PriyakartServiceConsumer/mvc/sells" target='_new'>SELLER HUB</a></li>
         <li><a href="http://localhost:8084/PriyakartServiceConsumer/mvc/priyakart" target='_new'>PRIYAKART.COM </a></li>
      </ul>
   </div>
  </div>	