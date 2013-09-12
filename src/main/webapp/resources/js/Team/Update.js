$(document).ready(function() {
	var validator = $("#teamEditForm").validate({
		rules: {
			teamName: "required"
		},
		messages: {
			teamName: "Enter a team name"
		},
		errorPlacement: function(error, element) {
			error.appendTo( element.next() );
		},
		submitHandler: function() {
			var jsonData = {
				id : $("input#id").val(),
				teamName : $("input#teamName").val()
			};
			$.ajax({  
				  type: "PUT",  
				  url: "/domain/teams/"+$("input#id").val(),  
				  data: JSON.stringify(jsonData),
				  contentType: "application/json; charset=utf-8",
				  success: function(response,status,xhr) { 
					  document.location.href='/domain/teams/list';
				  }
				});  
			return false; 
		},
		success: function(label) {
		}
	});
	// Handling reset button
	resetButtonHandler();
});


function resetButtonHandler(){
	$("#resetButton").click(function() {
		$("input#teamName").val($("input#teamName").attr("data-reset"));
		  return false;
	});	
}



