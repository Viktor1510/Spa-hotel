let signInBtn = document.getElementById("signInBtn");
let signUpBtn = document.getElementById("signUpBtn");
let emailInput = document.getElementById("emailInput");

// праща user-a в менюто за "регистрация"
signUpBtn.onclick = function(){
    signInBtn.classList.add("disable");
    signUpBtn.classList.remove("disable");
    window.location.href = "../html/signup.html";
}

// праща user-a в менюто за "вход"
signInBtn.onclick = function(){
    signInBtn.classList.remove("disable");
    signUpBtn.classList.add("disable");
    window.location.href = "../html/signin.html";
}