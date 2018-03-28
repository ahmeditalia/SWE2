$(document).ready(
		function() {
			$("div#addproduct").hide();
			$("div#statistics").hide();
			$("#addprodcttostore").click(function() {
				$("div#table").hide(500);
				$("div#addproduct").show(900);
					$.getJSON("/brandstore", {pname : "product1"},  function(data) {
                				for ( var i in data) {
                					$("#Brand").append($("<option></option>").text(data[i].name));
                					$("#Brand").append($("<option></option>").text(data[i].category));
                				}
                			});

                			$.getJSON("/productstore", {
                				bname : "1"
                			}, function(data) {
                				for ( var i in data) {
                					$("#ProductName").append($("<option></option>").val(data[i].name));
                				}
                			});

			});
			$("#addproductcancel").click(function() {
				$("div#addproduct").hide(500);
				$("div#table").show(900);
			});

			$('#ProductName').change(
					function() {
						$.getJSON("/brandstore", {pname : $('#ProductName').text()}, function(data) {
							$("#Brand").append($("<option></option>").text(data[i].name));
							$("#Brand").append($("<option></option>").text(data[i].category));
						});
					});

			$('#Brand').change(
					function() {
						$.getJSON("/productstore", {bname : $('#Brand').text()}, function(data) {
							for ( var i in data) {
								$("#ProductName").append($("<option></option>").text(data[i].name));
							}
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
					});
		});