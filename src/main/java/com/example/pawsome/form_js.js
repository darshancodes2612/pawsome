var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
var dropdown = document.getElementById("month");

for (var i = 0; i < months.length; i++) {
  var optionElement = document.createElement("option");
  optionElement.value = months[i];
  optionElement.textContent = months[i];
  dropdown.appendChild(optionElement);
}

var selectedMonth = document.getElementById("selmonth");

function displaySelected() {
  selectedMonth.innerHTML = "<b>Selected month:</b> " + dropdown.value;}