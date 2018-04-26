function updatediv()
{
	var select = [$("#list").val()];
	var selected = $("#list").val();
	if (select[0] == "All")
	{
		$("#list > option").each(function(index, element)
		{
			if ($(element).val() != "All")
			{
				select[index - 1] = $(element).val();
			}
		});
	}
	$.ajax({
		type : 'POST',
		contentType : 'application/json; charset=utf-8',
		url : '/statistics',
		data : JSON.stringify(select),
		dataType : 'json',
		success : function(data)
		{
			var i = 0;
			var interval;
			function stat()
			{
				if ($("#list").val() != selected)
				{
					clearTimeout(interval);
					return;
				}
				$("#statistics p").remove();
				var divcontent = "<p>Store: " + select[i] + "</p>" + "<p>Number Of Views: " + data[i].numUserView
						+ "</p>" + "<p>Number Of Buyers: " + data[i].numUserBuy + "</p>" + "<p>Number Of Sold Products: "
						+ data[i].soldProducts + "</p>";
				$("div#statistics").append(divcontent);
				i = (i + 1) % data.length;
				interval = setTimeout(stat, 5000);
			}
			interval = setTimeout(stat, 100);
		}
	});
}
$(document).ready(function(){
						$.getJSON("/view-store-collaborator", function(data) {
							for ( var i in data) {
								var option="<option value="+data[i].storeName+">"+data[i].storeName+"</option>"
								$("#list").append(option);
							}
							updatediv();
						});
						$('#addprodcttostore').click(function(){
							$("div#storeownerwindow").hide(500);
							$("div#storeownerwindow").empty();
							if($("#list option:selected").val() == "All"){
								alert('No Choosen Store !');
								return;
							}
							$('#storeownerwindow').empty();
							var addproduct ="<div id=\"addproduct\" class=\"addproducttostore\">"
										+"<form name=\"addProductstore\">"
										+"<h2>Add Product To Store</h2>"
										+"<p>Product Name</p>"
										+"<select id=\"ProductName\" class=\"listproducts\">"
										+"<option ></option>"
										+"</select>"
										+"<p>Price</p>"
										+"<input id=\"price\" name=\"price\" type=\"text\"></input>"
										+"<div id=\"validprice\" class=\"validadd\"></div>"
										+"<p>Quantity</p>"
										+"<input id=\"quantity\" name=\"quantity\" type=\"text\"></input>"
										+"<div id=\"validquantity\" class=\"validadd\"></div>"
										+"</form>"
										+"<button id=\"submitprodcttostore\" value=\"Submit\">Submit</button>"
									+"<button id=\"addproductcancel\" value=\"Cancel\">Cancel</button>"
								+"</div>";
								$("div#storeownerwindow").show(500);
								$("div#storeownerwindow").empty();
								$('#storeownerwindow').append(addproduct);
								$("#ProductName option").remove();
								var divinfo = "<div id=\"info\" class=\"productinfo\"></div>";
								$('#storeownerwindow').append(divinfo);
								$.getJSON("/allSystemProduct", function(data) {
									var ch=0;
									for ( var i in data) {
										$("#ProductName").append($("<option></option>").text(data[i].name));
										if(ch==0)
										{
												$('#info').empty();
												var pro="Product Name:   "+data[i].name+"<br></br> Product Brand:   "+data[i].brand.name
												+"<br></br> Product Category:   "+data[i].brand.category+"<br></br> Product Type:   "+data[i].type;
												$('#info').append(pro);
											ch=1;
										}
									}
								});
								$('#ProductName').change(function() {	
									$('#info').empty();
									$.getJSON("/ShowProductByName/"+$("#ProductName option:selected").val(), function(product) {
										var pro="Product Name:   "+product.name+"<br></br> Product Brand:   "+product.brand.name
										+"<br></br> Product Category:   "+product.brand.category+"<br></br> Product Type:   "+product.type;
										$('#info').append(pro);
									});
								});
								$("#submitprodcttostore").click(function() {
									if(addproductstorevalid()==true)
									{
										var vproduct={"name": $("#ProductName option:selected").val(), "price": $("#price").val(),
												"quantity": $("#quantity").val()};
										$.ajax({
										      type: "POST",
										      contentType : 'application/json; charset=utf-8',
										      dataType : 'json',
										      url: "/add-product-store/"+$("#list option:selected").val(),
										      data: JSON.stringify(vproduct),
										      success : function(data){
										    	  if(data==true)
										    		  alert('Add Product Success :)');
										    	  else
										    		  alert('Product already exits :)');
										      }
										 });
										$("div#storeownerwindow").hide(500);
										$("div#storeownerwindow").empty();
									}
								});
								$("#addproductcancel").click(function() {
									$("div#storeownerwindow").hide(500);
									$("div#storeownerwindow").empty();
								});
						});			
					
						$('#list').change(function() {
							$("#storeownerwindow").empty();
							$("div#storeownerwindow").hide();
									var table= "<table id=\"products\" class=\"showtable\">"
										+"<thead>"
											+"<tr class=\"theader\" style=\"background-color: #008040;\">"
												+"<th class=\"tdshow\">ID</th>"
												+"<th class=\"tdshow\">Name</th>"
												+"<th class=\"tdshow\">Price</th>"
												+"<th class=\"tdshow\">Type</th>"
												+"<th class=\"tdshow\">Brand</th>"
												+"<th class=\"tdshow\">Category</th>"
												+"<th class=\"tdshow\">Quantity</th>"
												+"<th class=\"tdshow\"></th>"
												+"<th class=\"tdshow\"></th>"
											+"</tr>"
										+"</thead>"
										+"<tbody id=\"body\">"
											
										+"</tbody>"
									+"</table>";
									$("#storeownerwindow").append(table);
									$("div#storeownerwindow").show(500);
									var select = [$("#list").val()];
									if (select[0] == "All")
									{
										$("#list > option").each(function(index, element)
										{
											if ($(element).val() != "All")
											{
												select[index - 1] = $(element).val();
											}
										});
									}
									$.ajax({
									      type: "POST",
									      contentType : 'application/json; charset=utf-8',
									      dataType : 'json',
									      url: "/Store-products",
									      data: JSON.stringify(select),
									      success: function(data)
									      {
									    	  $("#body").empty();
												for ( var i in data) {
													var tblRow = "<tr>" + "<td>" + data[i].id
															+ "</td>" + "<td>" + data[i].name
															+ "</td>" + "<td>" + data[i].price
															+ "</td>" + "<td>" + data[i].type
															+ "</td>" + "<td>" + data[i].brand.name
															+ "</td>" + "<td>" + data[i].brand.category
															+ "</td>" + "<td>" + data[i].quantity
															+ "</td>" + "<td><button id=\"edit\" name=\"btnedit\" value="+data[i].id+">edit</button>"
															+ "</td>" + "<td><button id=\"delete\" name=\"btnadelete\" value="+data[i].id+">delete</button>"
															+ "</td>" + "</tr>"
													$("#body").append(tblRow);
												}
									      }
									 });
									$("#body").on('click', "#delete", function () {
									    var productid= $(this).val();
									    $.post( "/delete-store-product", { id: productid});
									    $(this).closest('tr').remove();
									});
									$("#body").on('click', "#edit", function () {
									    var productid= $(this).val();
									    $(this).text("done");
									    $(this).closest('tr').find('td').eq(2).prop('contenteditable', true);
									    $(this).closest('tr').find('td').eq(6).prop('contenteditable', true);
									    $(this).text("done");
									    $(this).attr('id','done');
									});
									$("#body").on('click', "#done", function () {
									    $(this).closest('tr').find('td').eq(2).prop('contenteditable', false);
									    $(this).closest('tr').find('td').eq(6).prop('contenteditable', false);
									    alert($(this).val());
									    var productid= $(this).val();
									    var vprice=$(this).closest('tr').find('td').eq(2).text();
									    var vquantity=$(this).closest('tr').find('td').eq(6).text();
									    $.post( "/edit-store-product", { id: productid, quantity: vquantity , price: vprice});
										$(this).text("edit");
										$(this).attr('id','edit');
									});
									updatediv();
						});	
});