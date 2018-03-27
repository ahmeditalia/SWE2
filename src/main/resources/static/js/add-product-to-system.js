$(document).ready(function() {
	$.getJSON("/brands", function(data) {
		$("#brand").remove();
		$("#category").remove();
	    for(var i in data) { 
	        $("#brand").append($("<option></option>").text(data[i].name));
	        $("#category").append($("<option></option>").text(data[i].category));
	    });
	});
});