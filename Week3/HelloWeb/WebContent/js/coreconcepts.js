/*
 * JavaScript is a a scripting language for client-side operations
 * 	!= Java. "JS is to Java as ham is to hamster"
 * 	C-like syntax
 * 	supports prototypal inheritance 
 * 	loosely typed
 * Variable types
 * number, string, object, boolean, null, NaN(?), undefined
 * null is considered an object in JS. can consider it a bug
 */

var a = 5;
var b = "hello"
var c = 'hello';
var d = 7/0
var e = {name: "genesis", age:30};
var f = e.age;
var g = [0 , 2, 4, 6, 8];
var h = null;
var i;
console.log(typeof(a));
var interpol = `Hi ${e.name}`;


/*
 * Operators
 */

//Arithmetic: + - * / %
//Bitwise & | >> >>> <<
//Comparison > < >= <= == === != !==

//Logical (includes guard and default) && || ! !!

/*
 * Guard Operator &&
 * - if the first operand is truthy, return the 2nd operand 
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
 * Default Operator - || 
 * 	if the first operand is truthy, return the first operand
 * 		otherwise, return the second operand
 */

var getsCommission = 500;
var getRegSalary = 50;
var getsPaid = function(){
	return getsCommission || getsRegSalary;
}


/*
 * Truthy and Falsy
 * Falsy - null, 0, undefined, NaN, "", false
 * Truthy - anything else 
 */






/*
 * Strings
 */


/*
 * Objects
 * 	-can contain data and functions 
 *  -can inherit from other objects 
 *  -object literal {}
 *  -objects can contain an unordered collection of name/value pairs
 */

/*
 * Arrays
 *  -inherit from object
 *  -array indexes are converted into strings & used as names 
 *  	to retrieve values
 *  -array literal []
 *  -do not specify length/type
 *  -length number - not the actual # of elements stored in the array 
 *  	but 1 larger than the last index
 */

/*
 * functions
 */

function add(a, b){
	return a + b;
}







/**
 * Hoisting 
 * Variable declarations using var are treated as
 *  if they are at the top of the function (or 
 *  global scope, if declared outside of a function)
 *  regardless of where the actual declaration occurs;
 *  this is called hoisting. 
 */

function getValue(condition){
	if(condition){
		var value ="blue";
		return value;
	} else{
		// value exists here with a value of undefined
		return null;
	}
	//value exists with a value of undefined 
}
/* Looking at the above code, you might expect value to
 * only be created if condition evaluates to true. In fact, 
 * value is created regardless. Behind the scene, the JS
 * engine changes the getValue function to look like: */

function getValue(condition){
	var value;
	if(condition){
		value="blue";
		return value;
	}else{
		return null;
	}
}
/*
 * The declaration of value is hoisted to the top 
 * while the initialization remains in the same spot. That
 * means that the variable value is still accessible elsewhere
 * in the function; it just has a value of undefined.
 */

// Understanding the LET keyword
/* limits the variable to block scope
*/
function getValue(condition){
	if(condition){
		let value="blue";
		return value;
	} else{
		//value doesnt exist here
		return null;
	}
	//value doesnt exist here
}

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