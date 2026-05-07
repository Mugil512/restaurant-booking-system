// LOGIN FUNCTION

document.addEventListener("DOMContentLoaded", function () {

    const loginForm = document.getElementById("loginForm");

    if (loginForm) {

        loginForm.addEventListener("submit", function (e) {

            e.preventDefault();

            let username = document.getElementById("username").value;
            let password = document.getElementById("password").value;

            fetch("http://localhost:8081/api/auth/login?username=" + username + "&password=" + password, {
                method: "POST"
            })

            .then(response => {
                if (!response.ok) {
                    throw new Error("Invalid login");
                }
                return response.json();
            })

            .then(data => {

                alert("Login Successful");

                // redirect to dashboard
                window.location.href = "dashboard.html";

            })

            .catch(error => {

                alert("Login Failed");

            });

        });

    }

});


// LOGOUT FUNCTION

function logout() {

    alert("Logged out successfully");

    window.location.href = "login.html";

}

// OPEN BOOKING POPUP

function openBooking(restaurant){

document.getElementById("bookingModal").style.display="flex";

document.getElementById("restaurantName").value=restaurant;

}


// CLOSE BOOKING POPUP

function closeBooking(){

document.getElementById("bookingModal").style.display="none";

}


// BOOKING SUBMIT

document.addEventListener("DOMContentLoaded",function(){

const form=document.getElementById("bookingForm");

if(form){

form.addEventListener("submit",function(e){

e.preventDefault();

let data={

restaurantName:document.getElementById("restaurantName").value,
customerName:document.getElementById("customerName").value,
phone:document.getElementById("phone").value,
date:document.getElementById("date").value,
time:document.getElementById("time").value,
numberOfPeople:document.getElementById("people").value

};

fetch("http://localhost:8081/api/bookings",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify(data)

})

.then(response=>response.json())

.then(result=>{

alert("Booking Successful!");

closeBooking();

})

.catch(error=>{

alert("Booking Failed");

});

});

}

});

function loadBookings(){

fetch("http://localhost:8081/api/bookings")

.then(response => response.json())

.then(data => {

let tableBody = document.querySelector("#bookingTable tbody");

tableBody.innerHTML = "";

data.forEach(booking => {

let row = `
<tr>
<td>${booking.id}</td>
<td>${booking.restaurantName}</td>
<td>${booking.customerName}</td>
<td>${booking.phone}</td>
<td>${booking.numberOfPeople}</td>
<td>${booking.bookingDate}</td>
<td>${booking.bookingTime}</td>
<td>
<button onclick="deleteBooking(${booking.id})">Cancel</button>
</td>
</tr>
`;

tableBody.innerHTML += row;

});

});

}

function deleteBooking(id){

if(confirm("Are you sure you want to cancel this booking?")){

fetch("http://localhost:8081/api/bookings/" + id, {
method: "DELETE"
})

.then(response => {

alert("Booking cancelled successfully");

loadBookings();

})

.catch(error => {
console.log("Error deleting booking", error);
});

}

}

window.onload = function(){

if(window.location.pathname.includes("bookings.html")){
loadBookings();
}

}