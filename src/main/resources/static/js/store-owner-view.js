function updatediv() {
	var select=$("#list option:selected").val();
	if(select == "ALL"){
		$("#list > option").each(function() {
			if(this.value!="ALL")
				{
			setTimeout(function(){
				$("#statistics p").remove();
				$.getJSON("/stat", {sname:this.value},function(data) {
					var divcontent = "<p>Number Of Views " + data.numUserView + "</p>"
							+ "<p>Number Of Buyers " + data.numUserBuy + "</p>"
							+ "<p>Number Of Sold Products " + data.soldProducts + "</p>";
					$("div#statistics").append(divcontent);
				});
		    }, 5000);
		}});
		window.setTimeout(updatediv, 10000);
	}else{
		$("#statistics p").remove();
		$.getJSON("/stat", {sname:select},function(data) {
			var divcontent = "<p>Number Of Views " + data.numUserView + "</p>"
					+ "<p>Number Of Buyers " + data.numUserBuy + "</p>"
					+ "<p>Number Of Sold Products " + data.soldProducts + "</p>";
			$("div#statistics").append(divcontent);
		});
		window.setTimeout(updatediv, 10000);
	}
}

$(document).ready(function() {	
	updatediv();
		$.getJSON("/store-view", function(data) {
			for ( var i in data) {
				$("#list").append($("<option></option>").text(data[i].name));
			}
		});
		$('#addprodcttostore').click(function(){
			if($("#list option:selected").val() == "All"){
				alert('No Choosen Store !');
				return;
			}
			$('#storeownerwindow').empty();
			var addproduct = 
				"<div id=\"addproduct\" class=\"Box\">"
					+"<h2>Add Product To Store</h2>"
					//+"<form>"
						+"<p>Product Name</p>"
						+"<br></br>"
						+"<select id=\"ProductName\" class=\"lists\">"
						+"<option ></option>"
						+"</select>"
						+"<br></br><br></br>"
						+"<p>Price</p>"
						+"<input id=\"price\" name=\"price\" type=\"text\"></input>"
						+"<div id=\"validprice\" class=\"validadd\"></div>"
						+"<br></br>"
						+"<p>Brand</p>"
						+"<br></br>"
						+"<select id=\"Brand\" class=\"lists\">"
						+"<option ></option>"
						+"</select>"
						+"<br></br><br></br>"
						+"<div style=\"display:none\">"
						+"<p>Category</p>"
						+"<br></br>"
						+"<select id=\"Category\" class=\"lists\">"
						+"<option ></option>"
						+"</select>"
						+"</div>"
						+"<br></br><br></br>"
						+"<p>Quantity</p>"
						+"<input id=\"quantity\" name=\"quantity\" type=\"text\"></input>"
						+"<div id=\"validquantity\" class=\"validadd\"></div>"
						+"<br></br>"
						+"<button id=\"submitprodcttostore\" value=\"Submit\">Submit</button>"
					//+"</form>"
					+"<button id=\"addproductcancel\" value=\"Cancel\">Cancel</button>"
				+"</div>"
				$('#storeownerwindow').append(addproduct);
				$("#ProductName option").remove();
				$("#Brand option").remove();
				$("#Category option").remove();
				$.getJSON("/brands", function(data) {
					for ( var i in data) {
						$("#Brand").append($("<option></option>").text(data[i].name));
						$("#Category").append($("<option></option>").text(data[i].category));
					}
				});
				$.getJSON("/allSystemProduct", function(data) {
					for ( var i in data) {
						$("#ProductName").append($("<option></option>").text(data[i].name));
					}
				});
				$('#ProductName').change(function() {
					$.getJSON("/brandOfProduct", {pname : $('#ProductName').text()}, function(data) {
						$("#Brand").append($("<option></option>").text(data[i].name));
						$("#Category").append($("<option></option>").text(data[i].category));
				});
				});
				$('#Brand').change(function() {
						$.getJSON("/productsOfBrand", {bname : $('#Brand').text()}, function(data) {
							for ( var i in data) {
								$("#ProductName").append($("<option></option>").text(data[i].name));
						}
				});
				$("#submitprodcttostore").click(function() {
					var vbrand={"name": $("#Brand option:selected").val() , "category": $("#Category option:selected").val()};
					var vproduct={"name": $("#ProductName option:selected").val() , "brand": $("#Brand option:selected").val(),
							"price": $("#price").val(),"quantity": $("#quantity").val(),"store":{"storeName": $("#list option:selected").val()}};
					$.ajax({
					      type: "POST",
					      contentType : 'application/json; charset=utf-8',
					      dataType : 'json',
					      url: "/add-product-store",
					      data: JSON.stringify(vproduct)
					 });
				});
				$("#addproductcancel").click(function() {
					$('#storeownerwindow').empty();
				});
		});
		
		
		});
		$('#list').change(function() {
			$('#storeownerwindow').empty();
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
	
	$("#addstore").click(function() {
		$('#storeownerwindow').empty();
		var addstore="<div id=\"addstore\" class=\"addstore\">"
					+"<h2>Add Store</h2>"
					+"<p>Store Name:</p>"
					+"<input id=\"storename\" type=\"text\" name=\"storeName\"></input>"
					+"<p>Store Location:</p>"
					+"<input id=\"location\" type=\"text\" name=\"location\"></input>"
					+"<p>Store Type:</p>"
					+"<input id=\"storetype\" type=\"text\" name=\"type\" ></input>"
					+"<h3>Store Type:</h3>"
					+"<label class=\"container\">Onsite"
					+"<input type=\"radio\" name=\"type2\" value=\"onsite\"></input>"
					+"<span class=\"checkmark\"></span>"
					+"</label> <br></br>"
					+"<label class=\"container\">Online"
					+"<input type=\"radio\" name=\"type2\" value=\"online\"></input>"
					+"<span class=\"checkmark\"></span>"
					+"</label> <br></br>"
				+"<button id=\"adddone\" value=\"Add\">Submit</button>"
				+"<button id=\"addcancel\" value=\"Cancel\">Cancel</button>"
			+"</div>";
		$('#storeownerwindow').append(addstore);
		$("#adddone").click(function() {
			var store = {"storeName": $("#storename").val() , "location": $("#location").val()
					,"type": $("#storetype").val(),"status": "Onhold"};
			$.ajax({
			      type: "POST",
			      contentType : 'application/json; charset=utf-8',
			      dataType : 'json',
			      url: "/add-store",
			      data: JSON.stringify(store)
			 });
		});
		$("#addcancel").click(function() {
			$('#storeownerwindow').empty();
		});
	});
	
});