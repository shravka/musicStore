  /**
  Sravani Kandarpa
  jadrn015 Proj2
  ***/

 var proj4_data;
 //var cartArray;
 //var cart;
  // Is field empty
  function isEmpty(fieldValue) {
    return $.trim(fieldValue).length == 0;
  }
  // US state list
  function isValidState(state) {
        var stateList = new Array("AK","AL","AR","AZ","CA","CO","CT","DC",
        "DE","FL","GA","GU","HI","IA","ID","IL","IN","KS","KY","LA","MA",
        "MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ",
        "NM","NV","NY","OH","OK","OR","PA","PR","RI","SC","SD","TN","TX",
        "UT","VA","VT","WA","WI","WV","WY");
        for(var i=0; i < stateList.length; i++)
            if(stateList[i] == $.trim(state))
                return true;
        return false;
        }
 // only alphabets and space and hypen
  function allLetter(city)
      {
		var letters= /^[a-zA-Z\s_-]+$/;
		if(city.match(letters))
			return true;
	    else
		   return false;
      }

/****** start of ready function *********/
$(document).ready(function() {

       /********TO MAKE POP UP OF FORM ***********/
	$( "#dialog-modal" ).dialog({
            height: 1000,
            width: 800,
            modal: true,
            autoOpen: false
    });

        $('#order_button').on('click', function($e) {
	            $("#dialog-modal").dialog('open');
            });
			
			
	
	 $( "#dialog-modal-addToCart" ).dialog({
            height: 350,
            width: 500,
            modal: true,
            autoOpen: false
     });		

 });
