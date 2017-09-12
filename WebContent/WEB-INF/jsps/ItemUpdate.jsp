<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    <title>Item Approval</title>
 <c:if test="${venObj!=null }">
  <%@include file="VendorHeader.jsp" %>
 </c:if>   
 <c:if test="${userObj!=null}">
  <%@include file="vdmHeader.jsp" %>
 </c:if>    
<div class="container" style="marging-top:0px;">
  <div class="row">
    <!-- left column -->
   <form  name="itemUpdate" action="itemUpdate" method="POST" class="form-horizontal" role="form">
    <div class="col-md-4 col-sm-6 col-xs-12">
      <div class="text-center">
        <img src="http://lorempixel.com/200/200/people/9/" class="img-thumbnail" alt="avatar">
        <img src="http://lorempixel.com/200/200/people/9/" class="img-thumbnail" alt="avatar">
      </div>
    </div>
    <!-- edit form column -->
    <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
            <h3 style="color:#337ab7">Product Information.</h3>
        <div class="form-group">
          <label  for="itemId" class="col-lg-3 control-label"></label>
          <div class="col-lg-2">
            <input class="form-control" name="itemId" value="${itemObj.itemId }" type="hidden" readonly>
          </div>
        </div>
        <div class="form-group">
          <label  for="itemName" class="col-lg-3 control-label">Title</label>
          <div class="col-lg-9">
            <input class="form-control" value="${itemObj.itemName }" type="text" readonly>
          </div>
        </div>
         <!-- Select Basic -->
        <div class="form-group">
           <label  for="itemType" class="col-lg-3 control-label">Type</label>
               <div class="col-lg-4">
                  <input class="form-control" value="${itemObj.itemType}" type="text" readonly>
               </div>
               <div class="col-lg-5">
                  <input class="form-control" value="${itemObj.itemSubType}" type="text" readonly>
               </div>
         </div> 
         <!-- Select Basic -->
          <!-- Select Basic -->
        <div class="form-group">
           <label  for="itemType" class="col-lg-3 control-label">Brand Name</label>
               <div class="col-lg-3">
                  <input class="form-control" value="${itemObj.itemBrand}" type="text" readonly>
               </div>
          <label class="col-lg-3 control-label">MRP</label>
          <div class="col-lg-3">
             <input class="form-control" value="${itemObj.itemMrp}" type="text" readonly></div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Transaction Date</label>
          <div class="col-md-3">
            <input class="form-control" value="${itemObj.transactinDateAndTime}" type="date" id="theDate" readonly >
          </div>
          <label class="col-md-3 control-label">Margin Discount</label>
          <div class="col-md-3">
            <input class="form-control" value="${itemObj.marginDiscount}" type="text" readonly>
          </div>
        </div>
        
         <div class="form-group">
          <label class="col-lg-3 control-label">Service</label>
            <div class="col-lg-3">
                <input class="form-control" value="${itemObj.service}" type="text" readonly>
            </div>
            <label class="col-lg-3 control-label">Rebate Value</label>
          <div class="col-lg-3">
            <input class="form-control" value="${itemObj.rebateValue}" type="text" readonly>
          </div>
        </div>
         <div class="form-group">
           <label  for="itemType" class="col-lg-3 control-label">Shipment Mode</label>
             <div class="col-lg-2">
               <input class="form-control" value="${itemObj.shipmentMode}" type="text" readonly>
             </div>
             <label class="col-lg-4 control-label">Special Services Cost</label>
          <div class="col-lg-3">
            <input class="form-control" value="${itemObj.specialServiceCost}" type="text" readonly>
          </div> 
        </div>
        <div class="form-group">
          <label  for="itemType" class="col-lg-3 control-label">Mode of Payment</label>
             <div class="col-lg-3">
                <input class="form-control" value="${itemObj.modeOfPayment}" type="text" readonly>
             </div>   
           <label class="col-lg-3 control-label">Avaliable Quantity</label>
           <div class="col-lg-3">
             <input class="form-control" value="${itemObj.avaliableQuantity}" type="text" readonly>
           </div>
        </div>
        <div class="form-group">
            <label class="col-lg-9 control-label">Total Amount</label>
          <div class="col-lg-3">
            <input class="form-control" name="" type="text" readonly>
          </div>
        </div>
       <div class="form-group">
             <label class="col-lg-3 control-label">VAT</label>
          <div class="col-lg-3">
             <input class="form-control" value="${itemObj.vat}" type="text" readonly>
          </div>
            <label class="col-lg-3 control-label">Vendor Margin</label>
          <div class="col-lg-3">
            <input class="form-control" value="${itemObj.vendorMargin}" type="text" readonly>
          </div>
        </div> 
        <div class="form-group">
             <label class="col-lg-3 control-label">Descriptions</label>
          <div class="col-lg-9">
             <textarea rows="6" name="details" class="form-control" id="details">${itemObj.details}</textarea>
          </div>
        </div> 
        <div class="form-group">
            <label class="col-lg-9 control-label">Net Total Amount</label>
          <div class="col-lg-3">
            <input class="form-control" name="" type="text" readonly >
          </div>
        </div> 
        <div class="form-group">
         <label class="col-lg-9 control-label"></label>
            <button  class="btn btn-primary" type="submit">Saved</button>
            <span></span>
           <button  class="btn btn-primary" type="button" >Back</button> 
        </div>
        </div>
     </form>
    </div>
 </div>
 <br> <br>
<%@include file="vdmFooter.jsp" %>