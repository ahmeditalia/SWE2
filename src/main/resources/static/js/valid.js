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
function addproductvalid() {

	var name = document.forms["addProduct"]["name"].value;
	var type = document.forms["addProduct"]["type"].value;
	var numbers = /^\d+$/;
	var floatnumber = /(^-?\d\d*\.\d\d*$)|(^-?\.\d\d*$)/;
	
	var flag1 = true;
	var flag3 = true;

	if (name == "") {
		document.getElementById('validname').innerText = "*Name required";
		flag1 = false;
	}
	else if (numbers.test(name)){
		document.getElementById('validname').innerText = "*Invlaid Input";
		flag1 = false;
	} else {
		document.getElementById('validname').innerText = "";
		flag1 = true;
	}
	

	if (type == "") {
		document.getElementById('validtype').innerText = "*Type required";
		flag3 = false;
	}
	else if (numbers.test(type)) {
		document.getElementById('validtype').innerText = "*Invlaid Input";
		flag3 = false;
	} else {
		document.getElementById('validtype').innerText = "";
		flag3 = true;
	}
	

	
	if (flag1  && flag3) {
		return true;
	} else {
		return false;
	}
}
function addbrandvalid() {

	var brand = document.forms["addbrand"]["brandname"].value;
	var category = document.forms["addbrand"]["brandcategory"].value;
	var numbers = /^\d+$/;
	var floatnumber = /(^-?\d\d*\.\d\d*$)|(^-?\.\d\d*$)/;
	
	var flag1 = true;
	var flag3 = true;

	if (brand == "") {
		document.getElementById('validname').innerText = "*Name required";
		flag1 = false;
	}
	else if (numbers.test(brand)){
		document.getElementById('validname').innerText = "*Invlaid Input";
		flag1 = false;
	} else {
		document.getElementById('validname').innerText = "";
		flag1 = true;
	}
	

	if (category == "") {
		document.getElementById('validcategory').innerText = "*Category required";
		flag3 = false;
	}
	else if (numbers.test(category)) {
		document.getElementById('validcategory').innerText = "*Invlaid Input";
		flag3 = false;
	} else {
		document.getElementById('validcategory').innerText = "";
		flag3 = true;
	}
	

	
	if (flag1  && flag3) {
		return true;
	} else {
		return false;
	}
}
function addproductstorevalid() {

	var price = document.forms["addProductstore"]["price"].value;
	var quantity = document.forms["addProductstore"]["quantity"].value;
	var numbers = /^\d+$/;
	var floatnumber = /(^-?\d\d*\.\d\d*$)|(^-?\.\d\d*$)/;
	
	var flag1 = true;
	var flag3 = true;

	if (price == "") {
		document.getElementById('validprice').innerText = "*Price required";
		flag1 = false;
	}
	else if (!numbers.test(price)){
		document.getElementById('validprice').innerText = "*Invlaid Input";
		flag1 = false;
	} else {
		document.getElementById('validprice').innerText = "";
		flag1 = true;
	}
	

	if (quantity == "") {
		document.getElementById('validquantity').innerText = "*Quantity required";
		flag3 = false;
	}
	else if (!numbers.test(quantity)) {
		document.getElementById('validquantity').innerText = "*Invlaid Input";
		flag3 = false;
	} else {
		document.getElementById('validquantity').innerText = "";
		flag3 = true;
	}
	

	
	if (flag1  && flag3) {
		return true;
	} else {
		return false;
	}
}
function addstorevalid() {

	var storeName = document.forms["addStore"]["storeName"].value;
	var location = document.forms["addStore"]["location"].value;
	var numbers = /^\d+$/;
	var floatnumber = /(^-?\d\d*\.\d\d*$)|(^-?\.\d\d*$)/;
	
	var flag1 = true;
	var flag3 = true;

	if (storeName == "") {
		document.getElementById('validstorename').innerText = "*StoreName required";
		flag1 = false;
	}
	else if (numbers.test(storeName)){
		document.getElementById('validstorename').innerText = "*Invlaid Input";
		flag1 = false;
	} else {
		document.getElementById('validstorename').innerText = "";
		flag1 = true;
	}
	

	if (location == "") {
		document.getElementById('validstorelocation').innerText = "*Location required";
		flag3 = false;
	}
	else if (numbers.test(location)) {
		document.getElementById('validstorelocation').innerText = "*Invlaid Input";
		flag3 = false;
	} else {
		document.getElementById('validstorelocation').innerText = "";
		flag3 = true;
	}
	

	
	if (flag1  && flag3) {
		return true;
	} else {
		return false;
	}
}
