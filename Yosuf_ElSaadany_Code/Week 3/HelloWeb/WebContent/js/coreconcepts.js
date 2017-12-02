/**
 *  JavaScript is a scripting language for client-side operations
 *   != Java. "JS is to Java as ham is to hamster"
 *   C-like syntax
 *   supports prototypal inheritance
 *   loosely typed
 *   
 */




/**
 * value types: string, object, boolean, null, NaN(?), undefined
 * null is considered an object in JS. can consider it a bug
 */

var a = 5;
var b = "hello";
var c = 'hello';
var d = 7/0;
var e = {name: "genesis", age:30}; // objects
var f = e.age;
var g = [0, 2, 4, 6, 8]; // arrays
var h = null;
var i;
console.log(typeof(a));


/*
 * Arithmetic: + - * / %
 * Bitwise & | >> >>> <<
 * Comparison > < >= <= == === != !==
 * 
 * Logical (includes guard and default) && || ! !!
 */

/*
 * Guard operator &&
 * if the first operand is truthy, return the 2nd operand
 * otherwise return the first operand
 * 
 * instead of returning true or false, it returns the
 * value of the appropriate operand
 */

var isLogged = true;
var username = 'Yosuf';
var getUser = function(){
	return isLoggedIn && username;
}

/*
 * Default operator - ||
 * if the first operand is truthy, return the first operand
 * otherwise, return the second operand
 */
var getsCommision = 500;
var getsRegSalary = 50;
var getsPaid = function(){
	return getsCommision || getsRegSalary;
}

/*
 * Truthy and Falsy
 * Falsy - null, 0, undefined, NaN, "", false
 * Truthy - anything else 
 */


/*
 * Objects
 * 	- Can contain data and functions
 * 	- can inherit from other objects
 * 	- Object literal {}
 * 	- Objects can contain an unordered collection of name/value pairs
 */


/*
 * Arrays
 * 	- inherit from object
 * 	- array indexes are converted to strings & used 
 */

/*
 * Functions
 */

function add(a, b){
	return a + b;
}


/*
 * Hoisting
 * Variable declarations using var are treated as
 * if they are at the top of the function (or 
 * global scope, if declared outside of a function)
 * regardless of where the actual declaration occurs;
 * this is called hoisting
 */

/*
 * LET keyword
 * limits the variable to block scope
 */



