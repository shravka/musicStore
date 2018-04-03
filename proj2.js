$(document).ready( function() {

	$.get("/jadrn015/servlet/GetVendor", handleVendorData);
  $.get("/jadrn015/servlet/GetCategory", handleCategoryData);
	$.get("/jadrn015/servlet/GetProducts", handleProductData);

  	getCartSize();

		$( "#dialog-modal-addToCart" ).dialog({
             height: 350,
             width: 500,
             modal: true,
             autoOpen: false
      });



// delegated events
	$(document).on("click", ".change" , function() {
	var str= this.id;
		console.log(str);
  var sku = str.replace("change", "");

	console.log(sku);
   console.log("change");
   $('#Quantity'+sku).prop("disabled",false);
   var quantity = $('#Quantity'+sku).value;
	 console.log(quantitiy);
	 $('#Quantity'+sku).focus;

//	$("#dialog-modal-addToCart").dialog('open');
//	 		 $("#addtobag").attr('disabled','disabled');
 });

 // delegated events
 	$(document).on("click", ".delete" , function() {
			var sku= this.name;
   console.log("delete");
	//	$("#dialog-modal-addToCart").dialog('open');
 //	 		 $("#addtobag").attr('disabled','disabled');
  });





//<a href="Online.html">
$(document).on("click", "#cart" , function() {
//CartClientDispatcher
console.log("ggggggggggggggggggggggggggggggggggggggg");
 var urlString="/jadrn015/servlet/CartClientDispatcher?value=";
 console.log(urlString);
 /*$.post(urlString,function(response) {
	 console.log(response);
	 //ajax to replace everything
	//$('body').html(response);
    });*/


    $.ajax({
					url: urlString,
					type: "post",
					success: function(response) {
				          		 console.log(response);
				          		 $('body').html(response);
					},
					error: function(response) {
								 console.log(response);
					}
			});




 });


// delegated events
	$(document).on("click", ".vendor-items" , function() {
		console.log("vendor");
		console.log( $(this).attr('value') );
		// call function for filter
		getAllCheckboxes();
 });

 $(document).on('click', ".category-items", function() {
	 console.log("category");
	 console.log( $(this).attr('value') );
  	getAllCheckboxes();
});


$(document).on('click','.View-Details',function(){
	 console.log("View-Details");
	 var sku = this.id;
	 console.log(sku);
	 var urlString="/jadrn015/servlet/GetSingleProductDetail?sku="+sku;
	 console.log(urlString);
	 $.ajax({
		 url: urlString,
		 type: "get",
		 success: function(response) {
							 getProductDetails(response);
		 },
		 error: function(response) {
				 alert("Some Error occured, please try again");
		 }
	 });


});

/*************for closing the pop up **************/
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  $(".modal").css("display", "none");

}

$(document).on('click', ".add-to-cart", function() {
	console.log("add-to-cart");
	var sku= this.name;
			console.log(sku);
 			  var quantity = $('#qty'+sku).val();
	console.log( quantity );
	console.log("/jadrn015/servlet/AddToCart?sku="+sku+"&quantity="+quantity);
    $.get("/jadrn015/servlet/AddToCart?sku="+sku+"&quantity="+quantity,function(response)
	 	{
	    //if response is sucessful , we would like to change cart number as well
	 	 $("#status").html(response);
  	});

//post all the Product data to servlet
//update the cart item here call that function and show cart number
	getCartSize();
});




});

// getting data from the servlet
 function getProductDetails(response) {
$(".modal").css("display", "block");
console.log(response);
	  $("#description").html(response);
}

// getting vendor data from the servlet
 function handleVendorData(response) {
	 var records = new Array();
   records = response.split("|");
	 var answer = "<a class=active> Vendor</a>";
   for(i=0; i < records.length-1; i++) {
	   console.log(records[i]);
		 console.log(records.length);
        answer += "<input type='checkbox' class='vendor-items' value=" +(i+1)+ ">" + records[i] + "<br>";
				    }
	  $('.vendorall').html(answer);
}

function handleCategoryData(response) {
			var records = new Array();
	    records = response.split("|");
			var answer = "<a class=active> Category</a>";
	    for(i=0; i < records.length-1; i++) {
	 	   console.log(records[i]);
	 		 console.log(records.length);
	         answer += "<input type='checkbox' class='category-items' value=" + (i+1) + ">" + records[i] + "<br>";
	 				    }
	   $('.categoryall').html(answer);
  }

//getting data from jsp and sticking it into html
	 function handleProductData(response) {
		 console.log("here handleProductData")
		  $('#center').html(response);
	}

  var getCartSize=function(){
		$.get("/jadrn015/servlet/CartSize",function(response)
		{
			console.log("im here");
			console.log(response);
		  $('#count').html(response);
		});
	}




// reference : http://bytutorial.com/blogs/jquery/jquery-get-selected-checkboxes
	function getAllCheckboxes()
	{
			var vendorArray = [];
			var categoryArray =[];
			/* look for all checkboes that have a class 'vendor-items' attached to it and check if it was checked */
			var ven_selected='';
			$(".vendor-items:checked").each(function() {
				vendorArray.push($(this).val());
			});
			/* we join the array separated by the comma */
			ven_selected = vendorArray.join(',') ;
			/* check if there is selected checkboxes, by default the length is 1 as it contains one single comma */

      var cat_selected
			$(".category-items:checked").each(function() {
				categoryArray.push($(this).val());
			});
			/* we join the array separated by the comma */
			cat_selected = categoryArray.join(',') ;

       console.log(ven_selected);
       console.log(cat_selected);
       var urlString='/jadrn015/servlet/GetSelectedProducts?category='+cat_selected+'&vendor='+ven_selected;
			 console.log(urlString);
			 $.ajax({
				url: urlString,
				type: "get",
				success: function(response) {
			          	handleProductData(response);
				},
				error: function(response) {
						alert("Some Error occured, please try again");
				}
			});
			     // now send these selected values to servlet to fetch the new records.
      //	$.get("/jadrn015/servlet/GetSelectedProducts?category=cat_selected&vendor=ven_selected", handleProductData);
 console.log("after hre");



	}
