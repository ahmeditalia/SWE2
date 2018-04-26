function viewproducts(search)
{
	$("#userwindow").empty();
	var table = "<table id=\"allproducts\" class=\"showtable\">" + "<thead>"
			+ "<tr class=\"theader\" style=\"background-color: #008040;\">" + "<th class=\"tdshow\">Name</th>"
			+ "<th class=\"tdshow\">Price</th>" + "<th class=\"tdshow\">Type</th>" + "<th class=\"tdshow\">Brand</th>"
			+ "<th class=\"tdshow\">Category</th>" + "<th class=\"tdshow\">Store</th>"
			+ "<th class=\"tdshow\">Quantity</th>" + "<th class=\"tdshow\">Add To Cart</th>" + "</tr>" + "</thead>"
			+ "<tbody id=\"body\">" + "</tbody>";
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
						+ data[i].brand.category + "</td>" + "<td>" + data[i].store.storeName + "</td>" + "<td>"
						+ data[i].quantity + "</td>" + "<td>" + "	<button id=\"addcart\" name=\"btnacc\" value="
						+ data[i].name + "-" + data[i].store.storeName + ">Add Cart</button>" + "</td>" + "</tr>"
				$("#body").append(tblRow);
			}
		}
	});
	$("#body").on('click', "#addcart", function()
	{
		$.post("/addtocart", {
			spname : $(this).val()
		});
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
			$('#searchTxt').keydown(function(e)
			{
				if (e.keyCode == 13)
				{
					viewproducts($("#searchTxt").val());
				}
			});
			$("#viewcart").click(
					function()
					{
						$("div#userwindow").empty();
						var table = "<table  style=\"margin-top:25px\" id=\"cartTable\" class=\"showtable\">"
								+"<thead><tr class=\"theader\" style=\"background-color: #008040;\">"
								+"<th class=\"tdshow\">Name</th>"
								+"<th class=\"tdshow\">Price</th>"
								 +"<th class=\"tdshow\">Type</th>"
								 +"<th class=\"tdshow\">Brand</th>"
								 +"<th class=\"tdshow\">Category</th>"
								 +"<th class=\"tdshow\">Store</th>"
								 +"<th class=\"tdshow\">Quantity</th>"
								 +"<th class=\"tdshow\">Total Price</th>"
								 +"<th class=\"tdshow\"></th>"
								+"</tr></thead><tbody id=\"body\"></tbody>";
						+"</table>";
						var div="<div>"
								+"<input id=\"totalprice\" readOnly=\"true\" value=\"0\"></input>"
								+"<button id=\"Buy\">Purchase</button>"
								+"</div>";
						$("#userwindow").append(table);
						$("#userwindow").append(div);
						$.ajax({
							type : "POST",
							contentType : 'application/json; charset=utf-8',
							dataType : 'json',
							url : "/viewProductsCart",
							success : function(data)
							{
								$("#body").empty();
								for ( var i in data)
								{
									var q="<div class=\"input-group plus-minus-input\">"
									    +"<button id=\"minus\" class=\"input-group-button\">"
									    +"<i class=\"fa fa-minus\" aria-hidden=\"true\"></i>"
									    +"</button>"
									    +"<input class=\"input-group-field\" type=\"number\" readOnly=\"true\" name=\"quantity\" value=\"1\" min=\"1\" max=\""+data[i].quantity+"\"></input>"
									    +"<button id=\"plus\" class=\"input-group-button\">"
									    +"<i class=\"fa fa-plus\" aria-hidden=\"true\"></i>"
									    +"</button>"
									    +"</div>";
									var tblRow = "<tr><td name=\"name\">" + data[i].name 
											+ "</td><td name=\"price\">" + data[i].price
											+ "</td><td name=\"type\">" + data[i].type 
											+ "</td><td name=\"name\">" + data[i].brand.name
											+ "</td><td name=\"category\">" + data[i].brand.category 
											+ "</td><td name=\"storeName\">"+ data[i].store.storeName 
											+ "</td><td name=\"name\">"+ q
											+ "</td><td name=\"name\">"+ data[i].price
											+"</td><td name=\"name\"><button id=\"RemoveFromCart\" name=\"btnacc\" value=" + data[i].name
											+ "-" + data[i].store.storeName + ">Remove</button></td></tr>";
									$("#body").append(tblRow);
									$("#totalprice").val(parseFloat($("#totalprice").val())+data[i].price);
								}
							}
						});
						$("#body").on('click', "#plus", function()
								{
						    if ($(this).closest('tr').find("input").val() < parseInt($(this).closest('tr').find("input").attr("max"))) {
								$(this).closest('tr').find("input").val(parseInt($(this).closest('tr').find("input").val()) + 1);
							    $(this).closest('tr').find('td').eq(7).text(parseFloat($(this).closest('tr').find('td').eq(7).text())+parseFloat($(this).closest('tr').find('td').eq(1).text()));
						    	$("#totalprice").val(parseFloat($("#totalprice").val())+parseFloat($(this).closest('tr').find('td').eq(1).text()));
						    	$("#totalprice").val();
						    	return;
						    	}
						    $(this).closest('tr').find("input").val($(this).closest('tr').find("input").attr("max"));
								});
						$("#body").on('click', "#minus", function()
								{
						    if ($(this).closest('tr').find("input").val() > parseInt($(this).closest('tr').find("input").attr("min"))) {
						    	$(this).closest('tr').find("input").val(parseInt($(this).closest('tr').find("input").val()) - 1);
							    $(this).closest('tr').find('td').eq(7).text(parseFloat($(this).closest('tr').find('td').eq(7).text())-parseFloat($(this).closest('tr').find('td').eq(1).text()));
						    	$("#totalprice").val(parseFloat($("#totalprice").val())-parseFloat($(this).closest('tr').find('td').eq(1).text()));
						    	return;
						    }
						    $(this).closest('tr').find("input").val($(this).closest('tr').find("input").attr("min"));
								});
						$("#body").on('click', "#RemoveFromCart", function()
						{
							$("#totalprice").val(parseFloat($("#totalprice").val())-parseFloat($(this).closest('tr').find('td').eq(7).text()));
							$(this).closest('tr').remove();
							$.post("/removefromcart", {
								spname : $(this).val()
							});
						});
						$("#userwindow").on('click', "#Buy", function()
						{
							var arr=[];
							$("#cartTable tbody tr").each(function (i) {
							var brand={
									"name": $(this).find("td").eq(3).text(),
									"category": $(this).find("td").eq(4).text()
									};
							var row={"name": $(this).find("td").eq(0).text(),
							"price":$(this).find("td").eq(7).text(),
							"type": $(this).find("td").eq(2).text(),
							"brand": brand,
							"store": {"storeName": $(this).find("td").eq(5).text()},
							"quantity": $(this).find("input").val()
							};
								arr[i]=row;
							});

							$.ajax({
							      type: "POST",
							      contentType : 'application/json; charset=utf-8',
							      dataType : 'json',
							      url: "/buyProduct",
							      data: JSON.stringify(arr)
							 });
						});
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