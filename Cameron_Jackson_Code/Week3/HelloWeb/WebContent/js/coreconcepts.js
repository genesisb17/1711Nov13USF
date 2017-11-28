/**
 * Javascript Stuff
 */

var a = 5;
var b = "hello";
var c = 'hello';
var d = 7/0;
var e = {name: "Bo", age:30}
var f = e.age;
var g = [0, 2, 4, 6, 8];
var h = null;
var i;
console.log(typeof(a))

function add(a,b) {
	return a + b;
}

/*
 * Guard Operator &&
 */
var isLoggedIn = true;
var username = "user";
var getUser = function() {
	return isLoggedIn && username;
}

/*
 * Default Operator - ||  
 */
var getsCommission = 500;
var getRegSalary = 50;
var getsPaid = function() {
	return getsCommission || getsRegSalary;
}

/*
 * Hoisting
 */
function getVal(condition) {
	if (condition) {
		var value = "blue";
		return value;
	} else {
		// value exists here with a value of undefined
		return null;
	}
	// value exists here with a value of undefined
}

// Understanding the Let keyword
// limits the variable to block scope
function getVal(condition) {
	if (condition) {
		let value = "blue";
		return value;
	} else {
		// value doesn't exists here
		return null;
	}
	// value doesn't exists here
}