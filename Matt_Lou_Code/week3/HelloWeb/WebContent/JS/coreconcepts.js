/**
 * Javascript is a scripting language for client-side operations
 * != JAVA
 * C-like syntax
 * supports prototypal inheritance
 * loosely typed (no need to define int, double etc
 */

/*
 * Variable types
 * TRUTHY AND FALSY
 * number, string, object, boolean, null, NaN(?), undefined
 * null is considered an object in JS. can consider it a bug
 */

/*
 * operators
 * Arithmetic: + - *  / %
 * Bitwise & | >> >>> <<
 * comparison > < >= <= == === != !==
 */

/*
 * Guard operator &&
 * -if the first operand is truthy, return the 2nd operand
 * 		otherwise return the first operand
 * -instead of returning true or false, it returns the 
 * 		value of the appropriate operand
 */


/*
 *Objects  - can contain data and methods
 *		   -can inherit from other object
 *		   -object literal {}
 *		   -objects can contain an unordered collection of name/value pairs 
 */

/*
 * Arrays inherit from objects
 * -array indexes are converted into strings & used as names to retrieve values
 * -array literal []
 * do not specify length/type
 * -length number - not the actual # of elements stored in the array
 * but 1 larger than the last index
 */

/*
 * functions
 */
function add(a, b) {
	return a + b;
}

//Logical (includes guard and default) && || ! !!

/*
 * Guard Operator &&
 * -if the first operand is truthy, return the 2nd operand
 * 		otherwise return the first operand
 * - instead of returning true or false, it returns the 
 * 		value of the appropriate operand
 */
var isLoggedIn = true;
var username = "user";
var getUser = function(){
	return isLoggedIn && username;
}

/*
 * Default operator - ||
 * if the first operand is truthy, return the first operand
 * 		otherwise, return the second operand
 */
// if getsCommission is 0, then it is falsy and will not return getsCommission
// it will only return getsRegSalary
var getsCommission = 500;
var getsRegSalary = 50;
var getsPaid = function(){
	return getsCommission || getsRegSalary;
}

/*
 * Hoisting
 * Variable declarations using var are treated as if
 * they are at the top of the function (or global scope,
 * if declared outside of a function) regardless of where the actual
 * declaration occurs;
 * Called hoisting.
 */

function getValue(condition){
	if(condition){
		var value = "blue";
		return value;
	} else{
		//value exits here with a value of undefined
		return null;
	}
//	value exists with a value of undefined
}
// BUT what is really happening is THIS
/*notice that because of hoisting, the var value is
pull outside of the {} implicitly, allowing access of value
even inside the "else" statement
*/
function getValue(condition){
	var value;
	if(condition){
		value = "blue";
		return value;
	} else{
		return null;
	}
}
/*
 * The declaration of value is hoisted to the top
 * while the initialization remains in the same spot. That
 * means that the variable value is still accessible elsewhere
 * in the function; it just has a value of undefined.
 */

/*
 * Understanding LET keyword
 * limits the variable to block scope
 */

function getValue(condition) {
	if(condition) {
		let value = "blue"
	} else{
		return null;
	}
}



var a = 5;
var b = "hello";
var c = 'hello';
var d = 7/0;
var e = {name: "genesis, age:30"};
var f = e.age;
var g = [0,2,4,6,8];
var h = null;
var i;
console.log(typepf(a));


/*
 * Inheritance and classes
 * Prior to ES6, JS did not support OO design. Inheritance was
 * prototypal, but now classes and constructors exist, 
 */

//First, what this looked like in ES6:
function vehicle(name, type){
	this.name = name;
	this.type = type;
}
vehicle.prototype.getName = function getName(){
	return this.name;
}
vehicle.prototype.getType = function getType(){
	return this.type;
}
var car = new vehicle('Tesla', 'car');
console.log(car.getName()); // prints Tesla
console.log(car.getType()); // prints car

//Now, in ES6:
class Vehicle{
	constructor(name, type){
		this.name = name;
		this.type = type;
	}
	getName(){return this.name;}
	getType(){return this.type;}
}

let car = new Vehicle('BMW', 'car');
console.log()