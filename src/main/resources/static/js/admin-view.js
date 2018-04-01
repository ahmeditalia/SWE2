$(document).ready(function() {

    $.post("/requestNumber",function(data){
    	$("div#not").text(data);
    });
    
    
		$("#addbrandtosystem").click(function() {
			
			$("#adminwindow").empty();
			var v="<form id=\"addbrand\" name=\"addbrand\">"
			+"<p>Brand Name</p>"
			+"<input id=\"namebrand\" name=\"brandname\" type=\"text\"></input>"
			+"<div id=\"validname\" class=\"validadd\"></div>"
			+"<br></br>"
			+"<p>Brand Cateory</p>"
			+"<input id=\"categorybrand\" name=\"brandcategory\" type=\"text\"></input>"
			+"<div id=\"validcategory\" class=\"validadd\"></div>"
			+"<br></br>"
			+"</form>"
			+"<button id=\"submitbrand\"  value=\"Add Brand\">Add Brand</input>"
			+"<button id=\"addbrandcancel\" value=\"Cancel\">Cancel</button>";
		$("#adminwindow").append(v);

		$("#addbrandcancel").click(function() {
			$("div#adminwindow").hide(500);
		});
		
		$("#submitbrand").click(function() {
			if(addbrandvalid()==true)
			{
				var vbrand={"name": $("#namebrand").val() , "category": $("#categorybrand").val()};
				 $.ajax({
				      type: "POST",
				      contentType : 'application/json; charset=utf-8',
				      dataType : 'json',
				      url: "/add-brand",
				      data: JSON.stringify(vbrand)
				  });

			}
		});
		});
		

		$("#addproduct").click(function() {

			$("#adminwindow").empty();
			var v="<h2>Add Product To System</h2>"
				+"<form name=\"addProduct\">"
				+"<p>Name</p>"
				+"<input id=\"pname\" name=\"name\" type=\"text\"></input>"
				+"<div id=\"validname\" class=\"validadd\"></div>"
				+"<br></br>"
				+"<p>Brand</p>"
				+"<br></br>"
				+"<select id=\"brand\" class=\"listbrand\">"
				+"</select>"
				+"<br></br><br></br>"
				+"<p>Category</p>"
				+"<br></br>"
				+"<select id=\"category\" class=\"listbrand\">"
				+"</select>"
				+"<br></br><br></br>"
				+"<p>Type</p>"
				+"<input id=\"ptype\" name=\"type\" type=\"text\"></input>"
				+"<div id=\"validtype\" class=\"validadd\"></div>"
				+"</form>"
				+"<button id=\"create\" value=\"submit\">Submit</button>"
				+"<button id=\"cancel\" value=\"Cancel\">Cancel</button>"
			$("#adminwindow").append(v);
			
			$.getJSON("/brands", function(data) {
				$("#brand option").remove();
				$("#category option").remove();
			    for(var i in data) {
			        $("#brand").append($("<option></option>").text(data[i].name));
			        $("#category").append($("<option></option>").text(data[i].category));
			    }
			});
			
			$("#cancel").click(function() {
				$("div#adminwindow").hide(500);
			});
			$("#create").click(function() {
				if(addproductvalid()==true)
				{
					var vbrand={"name": $("#brand").val() , "category": $("#category").val()};
					var vproduct={"name": $("#pname").val() , "brand": vbrand, "type": $("#ptype").val()};
					 $.ajax({
					      type: "POST",
					      contentType : 'application/json; charset=utf-8',
					      dataType : 'json',
					      url: "/add-product-to-system",
					      data: JSON.stringify(vproduct)
					  });

				}
				
			});
		});
		
		
		$("#Requests").click(function() {

			$("#adminwindow").empty();
			var table="<table id=\"requesttable\" class=\"showtableS\">"
				+"<thead>"
		+"<tr class=\"theader\" style=\"background-color: #008040;\">"
		+"<th class=\"tdshow\">Store owner</th>"
		+"<th class=\"tdshow\">Store</th>"
		+"<th class=\"tdshow\">Accept</th>"
		+"<th class=\"tdshow\">Reject</th>"
		+"</tr></thead>"
		+"<tbody id=\"body\"></tbody>"
		+"</table>";
			$("#adminwindow").append(table);
			$.getJSON("/view-request-stores", function(data) {
				for(var i in data)
				{
					var row="<tr>"
						+"<td>"+data[i].storeOwner.username+"</td>"
						+"<td>"+data[i].storeName+"</td>"
						+"<td>"
						+"	<button id=\"accept\" name=\"btnacc\" value="+data[i].storeName+" >accept</button>"
						+"</td>"
						+"<td>"
						+"	<button id=\"reject\" name=\"btnrej\" value="+data[i].storeName+">reject</button>"
						+"</td>"
						+"</tr>";
					$("#body").append(row);
				}
			});
			$("#body").on('click', "#accept", function () {
			    var stname= $(this).val();
			    $.post( "/accept", { storename: stname});
			    $(this).closest('tr').remove();
			    setTimeout(function(){
			    	$.post("/requestNumber",function(data){
				    	$("div#not").text(data);
				    });
			    }, 500);
			    
			});
			
			$("#body").on('click', "#reject", function () {
			    var stname= $(this).val();
			    $.post( "/reject", { storename: stname});
			    $(this).closest('tr').remove();
			    setTimeout(function(){
			    	$.post("/requestNumber",function(data){
				    	$("div#not").text(data);
				    });
			    }, 500);
			});
		});
		
		$("#showallproducts").click(function() {

			$("#adminwindow").empty();
			var table="<table id=\"showProducts\" class=\"showtable\">"
				+"<thead>"
				+"<tr class=\"theader\" style=\"background-color: #008040;\">"
				+"<th class=\"tdshow\">ID</th>"
				+"<th class=\"tdshow\">Name</th>"
				+"<th class=\"tdshow\">Type</th>"
				+"<th class=\"tdshow\">Brand</th>"
				+"<th class=\"tdshow\">Category</th>"
				+"</tr></thead>"
				+"<tbody id=\"body\"></tbody>"
				+"</table>";
			$("#adminwindow").append(table);
			$.getJSON("/allSystemProduct", function(data) {
				for(var i in data)
				{
					var row="<tr>"
						+"<td>"+data[i].id+"</td>"
						+"<td>"+data[i].name+"</td>"
						+"<td>"+data[i].type+"</td>"
						+"<td>"+data[i].brand.name+"</td>"
						+"<td>"+data[i].brand.category+"</td>"
					+"</tr>";
					$("#body").append(row);
				}
			});	
		});
		
	});