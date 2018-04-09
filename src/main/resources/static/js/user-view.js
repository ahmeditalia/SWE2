$(document).ready(function() {
	$('#topbar').hide();
	$('#userwindow').hide();
	$('#search').click(function(){
		$('#userwindow').hide(500);
		$('#topbar').toggle(500);
	});
	$("#buyproduct").click(function() {
		$("div#userwindow").hide();
		$("div#userwindow").empty();
	});
});