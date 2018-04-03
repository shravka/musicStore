<%@page import ="java.util.*"%>
<%@page import ="sdsu.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <html>
  <head>
	      <!-- Required meta tags always come first -->
	      <meta charset="utf-8">
	      <meta name="viewport" content="width=device-width, initial-scale=1">
	      <meta http-equiv="x-ua-compatible" content="ie=edge">
	      <meta http-equiv='cache-control' content='no-cache'>
	      <meta http-equiv='expires' content='0'>
	      <meta http-equiv='pragma' content='no-cache'>
	      <!-- Bootstrap CSS -->

	     <link rel="stylesheet" href="/jadrn015/css/bootstrap.css">
	     <link rel="stylesheet" href="/jadrn015/css/bootstrap.min.css">
	     <link rel="stylesheet" href="/jadrn015/css/landings.css">
	     <link rel="stylesheet" href="/jadrn015/css/indexcss.css">
	     <link rel="stylesheet" href="/jadrn015/js/jquery-ui-1.12.1.custom/jquery-ui.theme.css">
	     <!-- jQuery first, then Bootstrap JS. -->
	     <script src="http://jadran.sdsu.edu/jquery/jquery.js"></script>
	     <script src="/jadrn015/js/bootstrap.js"></script>
	     <script src="/jadrn015/js/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
	   <script src="/jadrn015/js/proj2.js"></script>
             <script src="/jadrn015/js/cartform.js"></script>
          </head>
	  <body>
	  <div id="top">
	        <div id="header">
	          <nav class="navbar navbar-default .navbar-fixed-top">
	            <div class="container-fluid">
	              <!--  Logo  ---->
	              <div class="navbar-header">
	                  <img id="logo" src="logo.png" width="50px" />
	                  <a class="navbar-brand" href="#">Mu&icWorld</a>
	                  <li class="active"><a href="#">Home</a></li>
	                  <li><a href="#">About</a></li>
	                  <li><a href="#">Contact</a></li>

	                  <input class="formcontrol" type="text" placeholder="Search">
	                  <button class="btn btn-success" type="submit">GO</button>

	                <a href="#">  <img id="cart" src="cart.png" width="50px" /><span id="count">0</span></a>
	              </div>
	            </div>
	         </nav>
	       </div>


	          <div class="container-fluid">
	            <div class="row">
	              <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
	              	<div id="carouselwrapper" class="carousel slide" data-ride="carousel">
	              		<ol class="carousel-indicators">
	              			<li data-target="#carouselwrapper" data-slide-to="0" class="active"></li>
	              			<li data-target="#carouselwrapper" data-slide-to="1"></li>
	              			<li data-target="#carouselwrapper" data-slide-to="2"></li>
	              		</ol>

	              		<div class="carousel-inner" role="listbox">
	              			<div class="carousel-item active">
	              				<img src="header1.jpg" alt="First Slide" />
	              			</div>

	              			<div class="carousel-item">
	              				<img src="header2.jpg" alt="Second Slide" />
	              			</div>

	              			<div class="carousel-item">
	              				<img src="header3.jpg" alt="Third Slide" />
	              			</div>
	              		</div>
	              	</div>
	              </div>
	            </div>
	          </div>
</div>

<div id="prodContainer">
        <div id="confirm"></div>
		<div id="leftitem">

<%------------------     TO CHECK IF CART IS EMPTY DISPLAY NOTHING ELSE SHOW ALL PRODUCTS----------------%>
      <jsp:useBean id="jadrn015" scope="session" class="sdsu.CartHelper" />
      <c:if test="${jadrn015.cartSize==0}">
      <div id='empty'><h3> Your shopping bag is empty , Add items to your bag</h3>
      <input type='button' class='ui-button' id='continue' value='Shop'/> </div>


      </c:if>
      <c:forEach var="cartItem"  items="${jadrn015.cartProducts}" varStatus="counter">
      <div class='singletwo' >
      <img class='buyImages' src="/~jadrn015/proj1/musicStore/${cartItem.image}"  width="200px"  />
        <p>ID <c:out value="${cartItem.vendorModel}"/></p>
        <p>Price <c:out value="${cartItem.retail}" /> </p>
         <p>Quanity <input  type='text' class='Quantity' id='Quantity${cartItem.sku}' disabled  name="Quantity${cartItem.sku}" value='<c:out value="${cartItem.quantity}" />' size=2 /><p>

    <%--  <input type='button' class='ui-button' id='add'  name="add" value='Add' width='7px'/>---%>
        <input  type='button' class='ui-button change' id='change${cartItem.sku}'  name="change${cartItem.sku}" value='Change' width='7px' />
        <input  type='button' class='ui-button delete' id='delete${cartItem.sku}'  name="delete${cartItem.sku}" value='Delete Item' width='7px'/>
        </div>
      </c:forEach>


<%------------------     THIS IS THE CHECKOUT SUMMARY TAB   ----------------%>

    </div>
		<div id="right">
			<div id="orderSummary">
			<h3>ORDER SUMMARY </h3>
			<table>
           	<tr>
			<td>Subtotal</td>
			<td id="subtotal">0</td>
			</tr>
			<tr>
			<td>Shiping Cost*</td>
			<td id="shipcost">0</td>
			</tr>
            <tr>
			<td>*2.0$ per item</td>
			</tr>
			<td>Estimated Tax</td>
			<td id="tax">0</td>
			<tr>
			</tr>
            <td>Estimated Total Cost</td>
			<td id="total">0</td>
			</tr>
			 </table>
			 <div class="buttonheader">
             <input type="button" value="Checkout" id="order_button" />
             </div>
			</div>
		</div>
	</div>

<%------------------     THIS IS MODAL DIALOG FOR ADD TO CART BELOW EACH ITEM   ----------------%>
<div id="dialog-modal-addToCart" class="dialog-modal-addToCart" title="Enter Quantity">
    <input type="text" name="qty"  id="cartquantity" size="3" maxlength="2" />
	<input type="button" name="bag"  class="ui-button" placeholder="quantity" id="addtobag" value="Change " />
</div>


<%------------------     THIS IS MODAL DIALOG FOR BILLING AND SHIPPING  ----------------%>
	<div id="dialog-modal" class="widget-dialog-container" title="CheckOut">
   	<form method="post" action="">

     <fieldset id="shiptable">
     <legend>Shipping Address</legend>
     <table >
			<tr>
				<td class="shiptext">FirstName:</td>
				<td><input class="ship" type="text" name="sfirstname" id="sfirstname" size="20" /></td>
			</tr>
			<tr>
				<td class="shiptext" >LastName:</td>
				<td><input class="ship" type="text" name="slastname" id="slastname" size="20" /></td>
			</tr>
			<tr>
			   <td class="shiptext">Address:</td>
			   <td><input class="ship" type="text" name="saddress" id="saddress" size="20" /></td>
			</tr>
		   	<tr>
			    <td>&nbsp; &nbsp; &nbsp;</td>
               <td><input class="ship" type="text" name="saddress1" id="saddress1" size="20" /></td>
		   	</tr>


		   <tr>
				<td class="shiptext">City:</td>
				<td><input class="ship" type="text" name="scity" id="scity" size="5" /></td>

				<td class="shiptext">State:</td>
			   <td><input class="ship" type="text" name="sstate" id="sstate" size="2" /></td>

			   <td class="shiptext">Zip:</td>
			   <td><input class="ship" type="text" name="szip" id="szip" size="5" maxlength="5"/></td>
		   </tr>


			<tr>
				<td class="shiptext">Phone:*</td>
				<td colspan="5">
				(<input type="text" name="sarea_phone"  id="sarea_phone" size="4" maxlength="3" />)
				<input type="text" name="sprefix_phone" id="sprefix_phone" size="4" maxlength="3" />
				<input type="text" name="sphone"  id="sphone"size="5" maxlength="4" />
				</td>
			</tr>
      </table>
      </fieldset>
	  <input type="checkbox" name="same_address" id="same_address" value="same address" />Same as Shipping Address

        <fieldset id="billtable">
        <legend >Billing Address</legend>

		<table >
			<tr>
				<td class="shiptext">FirstName:</td>
				<td><input class="ship" type="text" name="bfirstname" id="bfirstname" size="20" /></td>
			</tr>
			<tr>
				<td class="shiptext" >LastName:</td>
				<td><input class="ship" type="text" name="blastname" id="blastname" size="20" /></td>
			</tr>
			<tr>
			   <td class="shiptext">Address:</td>
			   <td><input class="ship" type="text" name="baddress" id="baddress" size="20" /></td>
			</tr>
		   	<tr>
			    <td>&nbsp; &nbsp; &nbsp;</td>
               <td><input class="ship" type="text" name="baddress1" id="baddress1" size="20" /></td>
		   	</tr>


		   <tr>
				<td class="shiptext">City:</td>
				<td><input class="ship" type="text" name="bcity" id="bcity" size="5" /></td>

				<td class="shiptext">State:</td>
			   <td><input class="ship" type="text" name="bstate" id="bstate" size="2" /></td>

			   <td class="shiptext">Zip:</td>
			   <td><input class="ship" type="text" name="bzip" id="bzip" size="5" maxlength="5"/></td>
		   </tr>


			<tr>
				<td class="shiptext">Phone:*</td>
				<td colspan="5">
				(<input type="text" name="barea_phone" id="barea_phone" size="4" maxlength="3" />)
				<input type="text" name="bprefix_phone" id="bprefix_phone" size="4" maxlength="3" />
				<input type="text" name="bphone"  id="bphone"size="5" maxlength="4" />
				</td>
			</tr>
      </table>
    </fieldset>

     <fieldset>
     <legend>Payment Details</legend>
     <table>
		<tr>
			<td>Card Number:</td>
			<td><input type="text" name="cardnum" placeholder="xxxxxxxxxxxxxxxx" id="cardnum" size="16" maxlength="16" />
			</td>
		</tr>
		<tr>
			<td>Card Type:</td>
			<td>
			<input type="radio" name="cardtype" value="master" />Master &nbsp;
			<input type="radio" name="cardtype" value="visa" />Visa &nbsp;
			<input type="radio" name="cardtype" value="discover" />Discover &nbsp; &nbsp;
			<input type="radio" name="cardtype" value="american" />American Express &nbsp;
			</td>
		</tr>
        <tr>
       <td>Card Expiration</td>
          <td>
		    <input type="text" name="month" placeholder="mm" id="month" size="2" maxlength="2" />/
            <input type="text" name="year" placeholder="yyyy" id="year" size="4" maxlength="4" />
			 <input type="hidden" name="costtocgi"  id="costtocgi" size="4" value=0 maxlength="10" />
			  <input type="hidden" name="taxtocgi"  id="taxtocgi" size="4" value=0 maxlength="10" />
			   <input type="hidden" name="shippingcosttocgi"  id="shippingcosttocgi" size="4" value=0 maxlength="10" />
          </td>
       </tr>
      </table>
      </fieldset>

	<div id="message_line" >&nbsp;</div>
      <input type="reset"  class="ui-button" value="Clear"/>
      <input type="submit" class="ui-button" value="Submit Order"/>
	</form>
  	</div>

	   </body>

</html>
