$(document).ready(function() {
	var validator = $("#teamForm").validate({
		rules: {
			teamName: {
				required:true,
				remote: "/validator/checkteamname"
			}
		},
		messages: {
			teamName: {
				required : "Enter a team name"
					,
				remote: jQuery.format("{0} is already in use")
					}
		},
		errorPlacement: function(error, element) {
			error.appendTo(element.next());
		},
		submitHandler: function() {
			var jsonData = {
				teamName : $("input#teamName").val()
			};
			$.ajax({  
				  type: "POST",  
				  url: "/domain/teams/",  
				  data: JSON.stringify(jsonData),
				  contentType: "application/json; charset=utf-8",
				  success: function(response,status,xhr) {
					  document.location.href='/domain/teams/list';
				  },
			      error: function (xhr, ajaxOptions, thrownError) {
			          alert(thrownError);
			        }
				});  
			return false; 
		},
		success: function(label) {
		}
	});
	cancelButtonHandler();
});

/**
 * Cancel button handler
 */
function cancelButtonHandler(){
	$("#cancelButton").click(function() {
		document.location.href='/domain/teams/list';
	});	
}
