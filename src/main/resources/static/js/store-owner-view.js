function updatediv() {
	$("#statistics p").remove();
	$.getJSON("/stat", function(data) {
		var divcontent = "<p>Number Of Views " + data.numUserView + "</p>"
				+ "<p>Number Of Buyers " + data.numUserBuy + "</p>"
				+ "<p>Number Of Sold Products " + data.soldProducts + "</p>";
		$("div#statistics").append(divcontent);
		window.setTimeout(updatediv, 10000);
	});
}

$(document).ready(function() {	
	$('#storepanelview').hide();
	$("#stotrpanel").click(function() {
		$('#storepanelview').toggle(700);
//		$.getJSON("/store-view", function(data) {
//			for ( var i in data) {
//				$("#list").append($("<option></option>").text(data[i].name));
//			}
//		});
		$('#addproduct').click(function(){
			var addproduct = 
				"<div id=\"addproduct\" class=\"Box\">"
					+"<h2>Add Product To Store</h2>"
					+"<form>"
						+"<p>Product Name</p>"
						+"<br></br>"
						+"<select id=\"ProductName\" class=\"lists\">"
						+"<option ></option>"
						+"</select>"
						+"<br></br><br></br>"
						+"<p>Price</p>"
						+"<input name=\"price\" type=\"text\"></input>"
						+"<div id=\"validprice\" class=\"validadd\"></div>"
						+"<br></br>"
						+"<p>Brand</p>"
						+"<br></br>"
						+"<select id=\"Brand\" class=\"lists\">"
						+"<option ></option>"
						+"</select>"
						+"<br></br><br></br>"
						+"<p>Category</p>"
						+"<br></br>"
						+"<select id=\"Category\" class=\"lists\">"
						+"<option ></option>"
						+"</select>"
						+"<br></br><br></br>"
						+"<p>Quantity</p>"
						+"<input name=\"quantity\" type=\"text\"></input>"
						+"<div id=\"validquantity\" class=\"validadd\"></div>"
						+"<br></br>"
						+"<input type=\"submit\" value=\"Submit\"></input>"
					+"</form>"
					+"<button id=\"addproductcancel\" value=\"Cancel\">Cancel</button>"
				+"</div>"
		});
		$("#addprodcttostore").click(function() {
					$("div#table").hide(500);
					$("div#addproduct").show(900);
					$("#ProductName option").remove();
					$("#Brand option").remove();
					$("#Category option").remove();
					$.getJSON("/brands", function(data) {
						for ( var i in data) {
							$("#Brand").append($("<option></option>").text(data[i].name));
							$("#Category").append($("<option></option>").text(data[i].category));
							alert(data[i].name);
						}
					});
					$.getJSON("/allSystemProduct", function(data) {
						for ( var i in data) {
							$("#ProductName").append($("<option></option>").text(data[i].name));
						}
					});
				});
		$("#addproductcancel").click(function() {
			$("div#addproduct").hide(500);
			$("div#table").show(900);
		});
		$('#ProductName').change(function() {
					$.getJSON("/brandOfProduct", {pname : $('#ProductName').text()}, function(data) {
						$("#Brand").append($("<option></option>").text(data[i].name));
						$("#Category").append($("<option></option>").text(data[i].category));
						alert('e');
					});
		});
		$('#Brand').change(function() {
					$.getJSON("/productsOfBrand", {bname : $('#Brand').text()}, function(data) {
						for ( var i in data) {
							$("#ProductName").append($("<option></option>").text(data[i].name));
						}
						alert('f');
					});
		});
		$('#list').change(function() {
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
							+"</tr>"
						+"</thead>"
						+"<tbody>"
							
						+"</tbody>"
					+"</table>";
				$('#storepanelview').append(table);
					$.getJSON("/products", function(data) {
						$("#products tbody").remove();
						$("#products").append('<tbody></tbody>');
						for ( var i in data) {
							var tblRow = "<tr>" + "<td>" + data[i].id
									+ "</td>" + "<td>" + data[i].name
									+ "</td>" + "<td>" + data[i].price
									+ "</td>" + "<td>" + data[i].type
									+ "</td>" + "<td>" + data[i].brand
									+ "</td>" + "<td>" + data[i].category
									+ "</td>" + "<td>" + data[i].quantity
									+ "</td>" + "</tr>"
							$("#products tbody").append(tblRow);
						}
					});
					updatediv();
		});
	});
	
	$("#addstore").click(function() {
		$("div#addstore").show(1000);
	});
	$("#show-all-products").click(function() {
		var table = "<table id=\"allproducts\" class=\"showtable\">"
			+"<thead>"
				+"<tr class=\"theader\" style=\"background-color: #008040;\">"
					+"<td class=\"tdshow\">ID</td>"
					+"<td class=\"tdshow\">Name</td>"
					+"<td class=\"tdshow\">Type</td>"
					+"<td class=\"tdshow\">Brand</td>"
					+"<td class=\"tdshow\">Category</td>"
				+"</tr>"
			+"</thead>"
		+"</table>";
		$.getJSON("/products", function(data) {
			$("#allproducts tbody").remove();
			$("#products").append('<tbody></tbody>');
			for ( var i in data) {
				var tblRow = "<tr>" + "<td>" + data[i].id
						+ "</td>" + "<td>" + data[i].name
						+ "</td>" + "<td>" + data[i].type
						+ "</td>" + "<td>" + data[i].brand.name
						+ "</td>" + "<td>" + data[i].brand.quantity
						+ "</td>" + "</tr>"
				$("#allproducts tbody").append(tblRow);
			}
		});
	});
	$("#addcancel").click(function() {
		$("div#addstore").hide(1000);
	});
});