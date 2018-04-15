function viewproducts(search)
{
	$("#userwindow").empty();
	var table = "<table id=\"allproducts\" class=\"showtable\">" + "<thead>"
			+ "<tr class=\"theader\" style=\"background-color: #008040;\">" + "<th class=\"tdshow\">Name</th>"
			+ "<th class=\"tdshow\">Price</th>" + "<th class=\"tdshow\">Type</th>" + "<th class=\"tdshow\">Brand</th>"
			+ "<th class=\"tdshow\">Category</th>" + "<th class=\"tdshow\">Store</th>"
			+ "<th class=\"tdshow\">Quantity</th>" + "<th class=\"tdshow\">Add To Cart</th>"
			+ "</tr>" + "</thead>" + "<tbody id=\"body\">" + "</tbody>";
	+"</table>";
	$("#userwindow").append(table);
	$.ajax({
		type : "POST",
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		url : "/ShowAllProductsByName",
		data : search,
		success : function(data)
		{
			$("#body").empty();
			for ( var i in data)
			{
				var tblRow = "<tr>" + "<td>" + data[i].name + "</td>" + "<td>" + data[i].price + "</td>" + "<td>"
						+ data[i].type + "</td>" + "<td>" + data[i].brand.name + "</td>" + "<td>"
						+ data[i].brand.category + "</td>"+ "<td>"+ data[i].store.storeName+ "</td>" + "<td>" + data[i].quantity + "</td>" 
						+"<td>"
						+"	<button id=\"addcart\" name=\"btnacc\" value="+data[i].name+"-"+data[i].store.storeName+">Add Cart</button>"
						+"</td>" + "</tr>"
				$("#body").append(tblRow);
			}
		}
	});
	$("#body").on('click', "#addcart", function () {
		console.log($(this).val());
	    $.post("/addtocart", { spname: $(this).val()});
	});
}
$(document).ready(
		function()
		{
			viewproducts("all");
			$('#search').click(function()
			{
				viewproducts($("#searchTxt").val());
			});
			$('#searchTxt').keydown(function (e){
			    if(e.keyCode == 13){
			    	viewproducts($("#searchTxt").val()); 
			    }
			});
			
			$("#buyproduct").click(
					function()
					{
						$("div#userwindow").empty();
						var buyproduct = "<div id=\"buyproductuser\" class=\"buyproductuser\">"
								+ "<h2>Buy Product</h2>" + "<p>Total Price :  " + 5481553 + "</p>"
								+ "<p>Payment Method :</p>" + "<label class=\"container\">Visa Card"
								+ "<input type=\"radio\" name=\"type\" value=\"visacard\"></input>"
								+ "<span class=\"checkmark\"></span>" + "</label> <br></br>"
								+ "<label class=\"container\">Vocher Key"
								+ "<input type=\"radio\" name=\"type\" value=\"voucherkey\"></input>"
								+ "<span class=\"checkmark\"></span>" + "</label><br></br>" + "</form>"
								+ "<button id=\"next\" value=\"Add\">Next</button>"
								+ "<button id=\"cancel\" value=\"Cancel\">Cancel</button>" + "</div>";
						$("div#userwindow").empty();
						$('#userwindow').append(buyproduct);
						$('#cancel').click(function()
						{
							$('#userwindow').empty();
							viewproducts("all");
						});
					});
		});