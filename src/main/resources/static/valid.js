function registervalid() {
	var username = document.forms["Registrationform"]["username"].value;
	var email = document.forms["Registrationform"]["email"].value;
	var password = document.forms["Registrationform"]["password"].value;
	var flag1 = true;
	var flag2 = true;
	var flag3 = true;
	var filtermail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var filterpass = /^([a-zA-Z0-9]){8,32}$/;

	if (username == "") {
		document.getElementById('validname').innerText = "*Username require";
		flag1 = false;
	} else if (username.length > 20) {
		document.getElementById('validname').innerText = "*Username too long";
		flag1 = false;
	} else {
		document.getElementById('validname').innerText = "";
		flag1 = true;
	}
	if (email == "") {
		document.getElementById('validemail').innerText = "*Email require";
		flag2 = false;
	} else if (!filtermail.test(email)) {
		document.getElementById('validemail').innerText = "*Email not valid";
		flag2 = false;
	} else {
		document.getElementById('validemail').innerText = "";
		flag2 = true;
	}

	if (password == "") {
		document.getElementById('validpassword').innerText = "*Password require";
		flag3 = false;
	} else if (!filterpass.test(password)) {
		document.getElementById('validpassword').innerText = "*Password should [8-32]";
		flag3 = false;
	} else if (password.length > 32) {
		document.getElementById('validpassword').innerText = "*Password too long";
		flag3 = false;
	} else if (password.length < 8) {
		document.getElementById('validpassword').innerText = "*Password too short";
		flag3 = false;
	} else {
		document.getElementById('validpassword').innerText = "";
		flag3 = true;
	}

	if (flag1 && flag2 && flag3)
		return true;
	else {
		return false;
	}
}

function loginvalid() {
	var username = document.forms["loginform"]["username"].value;
	var password = document.forms["loginform"]["password"].value;
	var flag3 = true;
	var flag2 = true;
	var filtermail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var filterpass = /^([a-zA-Z0-9]){8,32}$/;
	if (username == "") {
		document.getElementById('validname').innerText = "*UserName require";
		flag2 = false;
	} else {
		document.getElementById('validname').innerText = "";
		flag2 = true;
	}
	if (password == "") {
		document.getElementById('validpassword').innerText = "*Password require";
		flag3 = false;
	} else if (!filterpass.test(password)) {
		document.getElementById('validpassword').innerText = "*Password should [8-32]";
		flag3 = false;
	} else if (password.length > 32) {
		document.getElementById('validpassword').innerText = "*Password too long";
		flag3 = false;
	} else if (password.length < 8) {
		document.getElementById('validpassword').innerText = "*Password too short";
		flag3 = false;
	} else {
		document.getElementById('validpassword').innerText = "";
		flag3 = true;
	}

	if (flag2 && flag3)
		return true;
	else {
		return false;
	}
}

function isString (value) {
	return typeof value === 'string' || value instanceof String;
}

function addproductvalid() {
	var name = document.forms["addProduct"]["name"].value;
	var price = document.forms["addProduct"]["price"].value;
	var type = document.forms["addProduct"]["type"].value;
	var brand = document.forms["addProduct"]["brand"].value;
	var quantity = document.forms["addProduct"]["quantity"].value;
	var category = document.forms["addProduct"]["category"].value;
	var numbers = /^\d+$/;
	var floatnumber = /(^-?\d\d*\.\d\d*$)|(^-?\.\d\d*$)/;
	
	var flag1 = true;
	var flag2 = true;
	var flag3 = true;
	var flag4 = true;
	var flag5 = true;
	var flag6 = true;

	if (name == "") {
		document.getElementById('validname').innerText = "*Name require";
		flag1 = false;
	}
	else if (numbers.test(name)){
		document.getElementById('validname').innerText = "*Invlaid Input";
		flag1 = false;
	} else {
		document.getElementById('validname').innerText = "";
		flag1 = true;
	}
	
	if (price == "") {
		document.getElementById('validprice').innerText = "*Price require";
		flag2 = false;
	}
	else if (!floatnumber.test(price)) {
		document.getElementById('validprice').innerText = "*Invlaid Input";
		flag2 = false;
	} else {
		document.getElementById('validprice').innerText = "";
		flag2 = true;
	}
	
	if (type == "") {
		document.getElementById('validtype').innerText = "*Type require";
		flag3 = false;
	}
	else if (numbers.test(type)) {
		document.getElementById('validtype').innerText = "*Invlaid Input";
		flag3 = false;
	} else {
		document.getElementById('validtype').innerText = "";
		flag3 = true;
	}
	if (brand == "") {
		document.getElementById('validbrand').innerText = "*Brand require";
		flag4 = false;
	}
	else if (numbers.test(brand)) {
		document.getElementById('validbrand').innerText = "*Invlaid Input";
		flag4 = false;
	} else {
		document.getElementById('validbrand').innerText = "";
		flag4 = true;
	}
	if (category == "") {
		document.getElementById('validcategory').innerText = "*Category require";
		flag5 = false;
	}
	else if (numbers.test(category)) {
		document.getElementById('validcategory').innerText = "*Invlaid Input";
		flag5 = false;
	} else {
		document.getElementById('validcategory').innerText = "";
		flag5 = true;
	}
	if (quantity == "" ) {
		document.getElementById('validquantity').innerText = "*Quantity require";
		flag6 = false;
	}
	else if (!numbers.test(quantity)) {
		document.getElementById('validquantity').innerText = "*Invlaid Input";
		flag6 = false;
	} else {
		document.getElementById('validquantity').innerText = "";
		flag6 = true;
	}

	
	
	if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6) {
		return true;
	} else {
		return false;
	}
}