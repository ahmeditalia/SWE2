$(document).ready(function() {
	$("div#addproduct").hide();
		$("#addprodcttostore").click(function() {
			$("div#table").hide(500);
			$("div#addproduct").show(900);
		});
		$("#addproductcancel").click(function() {
			$("div#addproduct").hide(500);
			$("div#table").show(900);
		});
		$('#list').change(function() {
			$.getJSON("/products",function(data){
				$("#products tbody").remove();
				$("#products").append('<tbody></tbody>');
				for(var i in data)
				{
					var tblRow = "<tr>" 
				+ "<td>" + data[i].id + "</td>" 
				+ "<td>" + data[i].name + "</td>" 
	           	+ "<td>" + data[i].price + "</td>"
	           	+ "<td>" + data[i].type + "</td>" 
	           	+ "<td>" + data[i].brand + "</td>" 
	           	+ "<td>" + data[i].category + "</td>" 
	           	+ "<td>" + data[i].quantity + "</td>" 
	           	+ "</tr>"
	           	$("#products tbody").append(tblRow);
				}
		});
		});	
});