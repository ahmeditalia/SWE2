$(document).ready(function(){
	$("#requesttable").on('click', "#accept", function () {
	    $(this).closest('tr').remove();
	    var stname= $(this).val();
	    $.get( "/accept", { storename: stname});
	});
	
	$("#requesttable").on('click', "#reject", function () {
	    $(this).closest('tr').remove();
	    var stname= $(this).val();
	    $.get( "/reject", { storename: stname});
	});
});

