$(document).ready(function() {
	$.getJSON("/brands", function(data) {
		$("#brand option").remove();
		$("#category option").remove();
	    for(var i in data) {
	        $("#brand").append($("<option></option>").text(data[i].name));
	        $("#category").append($("<option></option>").text(data[i].category));
	    }
	});
});