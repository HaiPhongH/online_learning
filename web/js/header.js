var signup = document.getElementById('signup_conversation');
var login = document.getElementById('login_conversation');

var signupbtn = document.getElementById('signupbtn');
var loginbtn = document.getElementById('loginbtn');

var xSignup = document.getElementById('xSignup');
var xLogin = document.getElementById('xLogin');

var cancelSignupBtn = document.getElementById('cancelSignup');
var cancelLoginBtn = document.getElementById('cancelLogin');

signupbtn.onclick = displaySignup;
function displaySignup() {
    signup.style.display = "block";
}

loginbtn.onclick = displayLogin;
function displayLogin() {
    login.style.display = "block";
}

xSignup.onclick = xCloseSignup;
function xCloseSignup() {
    signup.style.display = "none";
}

xLogin.onclick = xCloseLogin;
function xCloseLogin() {
    login.style.display = "none";
}

cancelSignupBtn.onclick = cancelSignup;
function cancelSignup() {
    signup.style.display = "none";
}

cancelLoginBtn.onclick = cancelLogin;
function cancelLogin() {
    login.style.display = "none";
}

window.onclick = close;
function close(event) {
    if (event.target === signup) {
        signup.style.display = "none";
    } else if (event.target === login) {
        login.style.display = "none";
    }
}
/*----------Login admin--------------*/
