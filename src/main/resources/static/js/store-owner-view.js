$(document).ready(function() {
		$("div#adds").hide();
		$("#addstore").click(function() {
			$("div#adds").show(1000);
		});
		$("#addcancel").click(function() {
			$("div#adds").hide(1000);
		});
	});