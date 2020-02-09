var form = document.getElementById("search_form");
var startDate = document.getElementById("start_date");
var directorID = document.getElementById("director_id");
var error = document.querySelector(".error");

startDate.addEventListener("input", function (event) {
   if(!startDate.validity.valid) {
       error.innerHTML = "I expected DATE";
       error.className = "error active";
   }
},false);
directorID.addEventListener("input", function (event) {
    if(directorID.validity.valid) {
        error.innerHTML = "everything IS GOOD";
        error.className = "error";
    }
},false);
form.addEventListener("submit", function (event) {
    if(!directorID.validity.valid) {
        error.innerHTML = "I EXPECTED";
        error.className = "error active";
        event.preventDefault();
    }
}, false);