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
    }
    else if (username.length > 20) {
        document.getElementById('validname').innerText = "*Username too long";
        flag1 = false;
    }
    else {
        document.getElementById('validname').innerText = "";
        flag1 = true;
    }
    if(email == ""){
        document.getElementById('validemail').innerText = "*Email require";
        flag2 = false;
    }
    else if (!filtermail.test(email)){
        document.getElementById('validemail').innerText = "*Email not valid";
        flag2 = false;
    }
    else{
        document.getElementById('validemail').innerText = "";
        flag2 = true;
    }

    if(password == ""){
        document.getElementById('validpassword').innerText = "*Password require";
        flag3 = false;
    }else if(!filterpass.test(password)){
        document.getElementById('validpassword').innerText = "*Password should [8-32]";
        flag3 = false;
    }
    else if(password.length > 32){
        document.getElementById('validpassword').innerText = "*Password too long";
        flag3 = false;
    }
    else if (password.length < 8) {
        document.getElementById('validpassword').innerText = "*Password too short";
        flag3 = false;
    }
    else{
        document.getElementById('validpassword').innerText = "";
        flag3 = true;
    }
    
    if(flag1 && flag2 && flag3)
        return true;
    else{
        return false;
    }
}

function loginvalid() {
    var email = document.forms["loginform"]["email"].value;
    var password = document.forms["loginform"]["password"].value;
    var flag3 = true;
    var flag2 = true;
    var filtermail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var filterpass = /^([a-zA-Z0-9]){8,32}$/;
    if(email == ""){
        document.getElementById('validemail').innerText = "*Email require";
        flag2 = false;
    }
    else if (!filtermail.test(email)){
        document.getElementById('validemail').innerText = "*Email not valid";
        flag2 = false;
    }
    else{
        document.getElementById('validemail').innerText = "";
        flag2 = true;
    }
    if(password == ""){
        document.getElementById('validpassword').innerText = "*Password require";
        flag3 = false;
    }else if(!filterpass.test(password)){
        document.getElementById('validpassword').innerText = "*Password should [8-32]";
        flag3 = false;
    }
    else if(password.length > 32){
        document.getElementById('validpassword').innerText = "*Password too long";
        flag3 = false;
    }
    else if (password.length < 8) {
        document.getElementById('validpassword').innerText = "*Password too short";
        flag3 = false;
    }
    else{
        document.getElementById('validpassword').innerText = "";
        flag3 = true;
    }
    
    if(flag2 && flag3)
        return true;
    else{
        return false;
    }
}