$(document).ready(function() {
		/*$("#submitbrand").click(function() {
			$.get("/add-brand", { name: $("#namebrand").val(), category: $("#categorybrand").val() } );
		});*/
		$("div#addbrand").hide();
		$("#addbrandtosystem").click(function() {
			$("div#addbrand").show(900);
		});
		$("#addbrandcancel").click(function() {
			$("div#addbrand").hide(500);
		});

		/*<![CDATA[*/
		var N = /*[[${N}]]*/'default';
		if (N < 1) {
			$("div#not").hide(-1500);
		}
		/*]]>*/
	});