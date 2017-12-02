/**
*  JavaScript is a scripting language for client-side operations
*   != Java. "JS is to Java as ham is to hamster"
*   C-like syntax
*   supports prototypal inheritance
*   loosely typed
*   
 */

/**
* variable types: string, object, boolean, null, NaN(?), undefined
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
 *  var is how to declare variables
 * 'hello' == "hello" return true
 *  var h = "hello";
 *  h.length returns 5
 *  h.charAt(0) returns "h"
 *  h.charAt(10) returns ""
 *  h.toLocaleUpperCase() returns "HELLO"
 *  h returns "hello" (unchanged because didnt set the uppercase value)
 *  var interpol = 'this is a string interpolation ${h}' returns undefined
 *  interpol returns "this is a string interpolation hello"
 *  "this is a string " + h    returns "this is a string hello"
 *  var obj = {name:"myName"}   returns undefined
 *  obj.name  returns "myName
 *  obj.age = 30   returns 30
 *  obj    returns {name: "myName", age: 30}
 *  obj.isAwesome = true    returns true
 *  obj    returns {name: "myName", age: 30, isAwesome: true}
 *  var str = '${obj.name} is ${obj.age} and it is 
 *  	${obj.isAwesome} that they/she/he is awesome'     returns undefined
 *  str    returns "myName is 30 and it is true that they/she/he is awesome'
 *  obj.talk = function(){console.log('hay!');    returns {console.log('hay');
 *  obj.talk    returns 'hay!'
 *  
 */

/*
 * Operators
 */

//Arithmetic: + - * / %
//Bitwise & | >> >>> <<
//Comparison > < >= <= == === != !==

//Logical (includes guard and default) && || ! !!

// = sets value
// == compares value
// === compares value with type

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
	return isLoggedIn && username;  // would return username is 
									// isLoggedIn true, else would return isLoggedIn
}
/*
 * Default Operator - ||
 *  if the first operand is truthy, return the first operand,
 *    otherwise return the second operand
 */
var getsComission = 500;
var getRegSalary = 50;

var getsPaid = function(){
	return getsComission || getsRegSalary;  //  returns 2nd unless first is falsy
}

/*
 * Truthy and Falsy
 * Each value has an inherant boolean value
 * Falsy - null, 0, undefined, NaN, "", false
 * Truthy - anything else
 */
/*
 * Objects
 * 	- can contain data and methods
 *  - can inherit from other objects
 *  - object literal {}
 *  - objects can contain an unordered collection of name/value pairs
 */

/*
 * Arrays
 *  - inherit from object
 *  - array indexes are converted into strings & used as names 
 *  	to retrieve values
 *  - array literal []
 *  - do not specify length/type
 *  - length number - not actual # of elements stored in the array 
 *  	but 1 longer than the last index
 */

/*
 * arr.shift() removes from front of array
 * arr.pop() removes from back of array
 * arr.push(x) adds x to back of array
 * arr.unshift(x) adds x to front of array
 * console.log(arr) to print something to console
 * arr.indexOf(10) return index of value
 * arr.splice(2,3) returns array or removed element 
 * 		from (starting index, amount of elements to remove)
 * var t = arr.splice(1,1) assigns t to removed 
 * 		t = [value]
 * var t = arr.splice(100,1) will return undefined if doesnt exist/out of bounds
 * 		t = []
 * var o = [,,,,,,] empty array
 * o.length = 6
 * o[0] = undefined
 * arr[100] = 9
 * arr.length returns 101
 * arr returns (101) [0, 10, 5, 0, empty x 96, 9]
 */

/*
 * Functions
 */
function add(a, b) {
	return a + b;
}
/*
 * Semicolons not needed, but semicolon injection could mess code up down 
 * 		the road, so safer to just have them
 */
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
/*
 * Looking at the above code, you might expect value to
 * only be created if condition evaluates to true. In fact, 
 * value is created regardless. Behind the scene, the JS
 * engine changes the getValue function to look like:
 */

function getValue(condition){
	var value;     // pulls declaration outside all the way to the start of the function
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
/* limits the variable to block scope. cannot use let to
 *  declare a variable w the same name 
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
/*
 * 
 * 
 */
