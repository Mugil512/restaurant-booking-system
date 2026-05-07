document.getElementById("registerForm").addEventListener("submit", function(e){

e.preventDefault();

let username = document.getElementById("username").value;
let email = document.getElementById("email").value;
let password = document.getElementById("password").value;

fetch("http://localhost:8081/api/auth/register",{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body: JSON.stringify({
username: username,
email: email,
password: password
})
})
.then(response => response.json())
.then(data =>{

document.getElementById("message").innerText="Registration Successful";

})
.catch(error=>{
console.log(error);
});

});