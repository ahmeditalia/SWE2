$(document).ready(function() {
	$('#topbar').hide();
	$('#search').click(function(){
		$('#topbar').toggle(500);
	});
});