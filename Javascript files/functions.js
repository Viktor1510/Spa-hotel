let signInBtn = document.getElementById("signInBtn");
let signUpBtn = document.getElementById("signUpBtn");
let closeOverlayBtn = document.getElementById("closeBtn");
let overlayLogin = document.getElementById("overlayLogin");
let overlayRegister = document.getElementById("overlayRegister");

function triggerOverlaySignIn(event){
    signInBtn.classList.remove("disable");
    signUpBtn.classList.add("disable");
    document.getElementById("overlaySignUp").style.display = "none";
    document.getElementById("overlaySignIn").style.display = "block";
    event.preventDefault();
}
function triggerOverlaySignUp(event){
    signInBtn.classList.add("disable");
    signUpBtn.classList.remove("disable");
    document.getElementById("overlaySignIn").style.display = "none";
    document.getElementById("overlaySignUp").style.display = "block";
    event.preventDefault();
}
function closeOverlaySignIn(){
    document.getElementById("overlaySignIn").style.display = "none";
}
function closeOverlaySignUp(){
    document.getElementById("overlaySignUp").style.display = "none";
}
