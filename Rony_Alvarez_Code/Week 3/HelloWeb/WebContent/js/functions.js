var a = [34, 203, 3, 746, 200, 984, 198, 764, 9];
var bubArray = [];
function bubbleSort(a)
{
	var swapped;
	do {
		swapped = false;
		for (var i=0; i < a.length-1; i++) {
			if (a[i] > a[i+1]) {
				var temp = a[i];
				a[i] = a[i+1];
				a[i+1] = temp;
				swapped = true;
			}
		}
	} while (swapped);
}

function populateArray(){
	bubArray.push(document.getElementById("bub").value);
}

function runBub(){
	var display = document.getElementById("bubDisplay");
	array = bubbleSort(bubArray);
	var data = "";
	for(var i = 0; i < bubArray.length; i++) {
		data += " " + bubArray[i];
	}
	display.innerHTML = data;
}

document.getElementById("doBub").addEventListener("click", runBub);
document.getElementById("addBub").addEventListener("click", populateArray);


var counter = 0;
function count() {
	counter = counter + 1;
	document.getElementById("count").innerHTML = counter;
}

document.getElementById("count").addEventListener("mouseover", count);

document.getElementById("outer").addEventListener("click", function() {
	alert("IN OUTER!");}, false);

document.getElementById("middle").addEventListener("click", function() {
	alert("IN MIDDLE!");}, true);

document.getElementById("inner").addEventListener("click", function() {
	alert("IN INNER!");}, true);



function reverseString(str) {
	var splitString = str.split("");

	var reverseArray = splitString.reverse();

	var joinArray = reverseArray.join("");

	return joinArray;
}

function runStr(){
	var display = document.getElementById("strDisplay");
	var n = document.getElementById("str").value;
	display.innerHTML = reverseString(n);
}
document.getElementById("revStr").addEventListener("click", runStr);


function factorial(num) {
	if (num < 0) 
		return -1;

	else if (num == 0) 
		return 1;

	else {
		return (num * factorial(num - 1));
	}
}

function runFac(){
	var display = document.getElementById("facDisplay");
	var n = document.getElementById("fac").value;
	display.innerHTML = factorial(n);
}
document.getElementById("fact").addEventListener("click", runFac);


function fib(n) {
	if(n <= 1) return n;
	return fib(n-1) + fib(n-2);
}

function runFib(){
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

document.getElementById("doFib").addEventListener("click", runFib);

function isEven(num) {
	if((num & 1) == 0)
		return true;
	return false;
}

function runEven(){
	var display = document.getElementById("evenDisplay");
	var n = document.getElementById("ev").value;
	display.innerHTML = isEven(n);
}
document.getElementById("isEven").addEventListener("click", runEven);
