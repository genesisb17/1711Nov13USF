/**
 * 
 *//**
 * JavaScript is a scripting language for client side operations
 * JavaScript != Java
 * C-like syntax
 * JS supports prototypal inheritence
 * loosely typed: does not check variable
 * value types: number string object, boolean, null, NaN(?), undefined
 * null is considered an object in js. i can consider it a bug.
 */

/*
 * Truthy and Falsy
 * Falsy = null, 0, undefined, NaN, "", false
 * Truthy is everything else
 */

/*
 * operators: 
 * Arithmetic = - * / %
 * Bitwise & | >> >>> <<
 * Comparison > < >= <= == === != !==
 * 
 * Guard Operator &&
 * -if the first operand is truthy, return the 2nd operand otherwise return the first operand
 * -instead of returning true or false, it returns the value of the appropriate operand
 * 
 */

var getUser = function(){
	return isLoggedin && username;
}

/*
 * Default operator ||
 */

/*
 * Hoisting
 * Variable declaration using var are treated as if they are at the top of the function
 * (or global scope, if declared in a function) regardless of where the function was written
 */

/* 
 * Objects
 * -Can contain data and methods
 * -can inherit from other objects
 * -object litera{}
 * -objects can contain collections of unordered pairs
 * 
 */

var a = 5;
var b = "hello";
var c = 'hello';
var d = 7/0;
var e = {name: "genesis", age:30};
var f = e,age
var g = [0, 2, 4, 6, 8];
var h = null;
var i;
console.log(typeof(a));

function add(a, b){ return a+b;}

function fib(n){
	//console.log(n)
	if(n<=1) return 1;
	else return fib(n-1) + fib(n-2);
}

function bubbleSort(numArray){
	var n = numArray.length;
	var swapped = false;
	do {
		swapped = false;
		for(i = 1; i < n; i++){
			if (numArray[i-1] > numArray[i]){
				var t = numArray[i-1];
				numArray[i-1] = numArray[i];
				numArray[i] = t;
				swapped = true;
			}
		}
	}
	while(swapped)
}

function reversal(str){
	for (i = 0; i < str.length - 1; i++){
		str = str + str.charAt(i);
	}
	str = str.substring(str.length - 1, (str.length * 2) - 1);
}





