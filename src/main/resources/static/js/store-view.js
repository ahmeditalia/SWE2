$(document).ready(
		function() {
			$("div#addproduct").hide();
			$("div#statistics").hide();
			$("#addprodcttostore").click(
					function() {
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

			$('#ProductName').change(
					function() {
						$.getJSON("/brandOfProduct", {pname : $('#ProductName').text()}, function(data) {
							$("#Brand").append($("<option></option>").text(data[i].name));
							$("#Category").append($("<option></option>").text(data[i].category));
							alert('e');
						});
					});

			$('#Brand').change(
					function() {
						$.getJSON("/productsOfBrand", {bname : $('#Brand').text()}, function(data) {
							for ( var i in data) {
								$("#ProductName").append($("<option></option>").text(data[i].name));
							}
							alert('f');
						});
					});

			$('#list').change(
					function() {
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