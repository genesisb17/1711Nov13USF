/**
 * JavaScript is a scripting language for client-side operations
 * !=Java, "JS is to Java as ham is to hamster"
 * C-like syntax
 * supports prototypal inheritance
 * loosely typed
 * 
 * Variable types
 * number, string, object, boolean, null, NaN(?), undefined
 * null is considered an object in JS. can consider it a bug
 */

var a = 5;
var b = "hello";
var c = 'hello';
var d = 7 / 0;
var e = {
	name : "Marshall",
	age : 30
};
var f = e.age;
var g = [ 0, 2, 4, 6, 8 ];
var h = null;
var i;
console.log(typeof (a));

/**
 * Truthy and Falsy
 * Falsy - null, 0, undefined, NaN, "", false
 * Truthy - anything else
 */

/**
 * Operators
 * Arithmetic: + - * / %
 * Bitwise & | >> >>> <<
 * Comparison > < >= <= == === != !==
 */

//Logical (includes guard and default) && || ! !!

/**
 * Guard Operator &&
 * - if the first operand is truthy, return the 2nd operand
 * 			otherwise return the first operand
 * - instead of returning true or false, it returns the
 * 			value of the appropriate operand
 */

var isLoggedIn=true;
var username="user";
var getUser = function(){
	return isLoggedIn && username;
}

/*
 * Default Operator - ||
 * if the first operand is truthy, return the first operand
 * 		otherwise, return the second operand
 */

var getsCommission=500;
var getsRegSalary =50;
var getsPaid = function (){
	return getsCommission || getsRegSalary;
}

/**
 * Objects
 *  -can contain data and methods
 *  -can inherit from other objects
 *  -object literal{}
 *  -objects can contain an unordered collection of name/value pairs
 */

/**
 * Arrays
 * -inherit from object
 * -array indexes are converted into strings & used as names
 * 		to retrieve values
 * -array literal []
 * -do not specify length/type
 * -length number - not the actual # of elements stored in the array
 * 		but 1 larger then the last index
 */

/**
 * functions
 */

function add(a, b){
	return a+b;
}

/**
 * Hoisting
 * Variable declarations using var are treated as
 * if they are at the top of the function (or 
 * global scope, if declared outside of a function)
 * regardless of where the actual declaration occurs;
 * this is called hoisting.
 */

function getValue(condition){
	if(condition){
		var value = "blue";
		return value;
	} else{
		//value exists here with a value of undefined
		return null;
	}
	//value exists with a value of undefined
}

/**
 *Looking at the above code, you might expect value to
 *only be created if condition evaluates to true. In fact,
 *value is created regardless. Behind the scene, the JS
 *engine changes the getValue function to look like:
 */

function getValue(condition){
	var value;
	if(condition){
		value="blue";
		return value;
	} else{
		return null;
	}
}
/**
 * The declaration of the value si hoisted to the top
 * while the initialization remains in the same spot. That
 * means that the variable value is still accessible elsewhere
 * in the function; it just has a value of undefined.
 */

//Understanding the LET keyword
/*
 * limits the variable to block scope. cannot use let to
 * declare a variable w the same name
 */

function getValue(condition){
	if(condition){
		let value="blue";
		return value;
	}else{
		//value doesnt exist here
		return null;
	}
	//value doesnt exist here
}