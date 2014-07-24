
window.onload=function sessionPopup(){
	
   //document.getElementById("session_popup").click();
	var sessionhref=document.getElementById("session_popup");
	if (sessionhref != null)
		window.location.href=sessionhref;
};

//onload=sessionPopup;
function verifyextn()
{
	var fileelement = document.getElementById("datafile");
	var fileextn="";
	if (fileelement != null)
	{
		if (fileelement.value.lastIndexOf(".") > 0)
		{
			fileextn=fileelement.value.substr(fileelement.value.lastIndexOf("."));
		}
				
		if (fileextn==".xls" || fileextn==".xlsx"){
			return true;
		}
		else {	
			alert("Please select an excel based datafile");
			return false;
		}
	}
	else
	{
		alert("No file is selected");
		return false;
	}
	
}

$(function()
{
	var numOfProfileSelects=0;
	$("#datagrid").on('change','input[type=checkbox]', function(event)
	{
		event.stopPropagation();
		var checkbox = $(this);
		if (checkbox.is(':checked'))
		{
			numOfProfileSelects++;
			if (numOfProfileSelects > 1){
		 		alert("More than one profile selected");
		 		//return false;
		 	}
		 	else
		 	{
		 		var $spaceid=checkbox.parent().siblings().eq(1).text();		 		
		 		$.post('setSPACEID.htm',{'spaceid':$spaceid});
		 	}
		 		
		}
		else
		{
			numOfProfileSelects--;
			if (numOfProfileSelects > 1){
		 		alert("More than one profile selected");
		 		//return false;
		 	}
		 	else if (numOfProfileSelects == 0){
		 		alert("No profile selected");
		 	}
		 	else
		 	{
		 		var $spaceid=checkbox.parent().siblings().eq(1).text();		 		
		 		$.post('setSPACEID.htm',{'spaceid':$spaceid});
		 	}
			
		}
		
	});
		
});
 
 