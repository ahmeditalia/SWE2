function viewproducts()
{
	$('#topbar').hide();
	$('#userwindow').hide();
	var table= "<table id=\"allproducts\" class=\"showtable\">"
		+"<thead>"
			+"<tr class=\"theader\" style=\"background-color: #008040;\">"
				+"<th class=\"tdshow\">Name</th>"
				+"<th class=\"tdshow\">Price</th>"
				+"<th class=\"tdshow\">Type</th>"
				+"<th class=\"tdshow\">Brand</th>"
				+"<th class=\"tdshow\">Category</th>"
				+"<th class=\"tdshow\">Quantity</th>"
				+"<th class=\"tdshow\">Select</th>"
			+"</tr>"
		+"</thead>"
		+"<tbody>"
		+"</tbody>";
	+"</table>";
	$("#userwindow").append(table);
	$("div#userwindow").show(500);
	$.getJSON("/products", function(data) {
	    	$("#allproducts tbody").remove();
			$("#allproducts").append('<tbody></tbody>');
			for ( var i in data) {
				var tblRow = "<tr>" + "<td>" + data[i].name
						+ "</td>" + "<td>" + data[i].price
						+ "</td>" + "<td>" + data[i].type
						+ "</td>" + "<td>" + data[i].brand.name
						+ "</td>" + "<td>" + data[i].brand.category
						+ "</td>" + "<td>" + data[i].quantity
						+ "</td>" + "<td>"
						+"<label class=\"container2\">"
						+"<input type=\"check\" name=\"type\"></input>"
						+"<span class=\"checkmark2\"></span>"
						+"</label>"
						+ "</td>" + "</tr>"
				$("#allproducts tbody").append(tblRow);
			}
	 });
}
$(document).ready(function() {
	viewproducts();
	var fl=true;
	$('#search').click(function(){
		if(fl==true)
		{
			$('#userwindow').hide(500);
			$('#topbar').toggle(500);
			viewproducts();
		}
		else{
			$('#userwindow').hide(500);
			$('#topbar').toggle(500);
		}
	});
	$("#buyproduct").click(function() {
		$('#topbar').hide();
		$("div#userwindow").empty();
		var buyproduct="<div id=\"buyproductuser\" class=\"buyproductuser\">"
					+"<h2>Buy Product</h2>"
					+"<p>Total Price :  "+5481553+"</p>"
					+"<p>Payment Method :</p>"
					+"<label class=\"container\">Visa Card"
					+"<input type=\"radio\" name=\"type\" value=\"visacard\"></input>"
					+"<span class=\"checkmark\"></span>"
					+"</label> <br></br>"
					+"<label class=\"container\">Vocher Key"
					+"<input type=\"radio\" name=\"type\" value=\"voucherkey\"></input>"
					+"<span class=\"checkmark\"></span>"
					+"</label><br></br>"
					+"</form>"
				+"<button id=\"next\" value=\"Add\">Next</button>"
				+"<button id=\"cancel\" value=\"Cancel\">Cancel</button>"
			+"</div>";
		$("div#userwindow").toggle(500);
		$("div#userwindow").empty();
		$('#userwindow').append(buyproduct);
		$('#cancel').click(function(){
			$('#userwindow').hide(500);
			viewproducts();
		});
	});
});