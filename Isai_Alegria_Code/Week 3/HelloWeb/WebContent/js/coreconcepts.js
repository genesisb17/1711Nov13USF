/**
 * Javascript is a scripting language for client-side operations
 * Js is not java. C-like syntax. Support prototypal inheritance. 
 * loosely-typed. Variable types: number, string, object, boolean, null, NaN(?),
 * undefined null is considered an object in JS. can consider it a bug.
 */

var a = 5;
var b = "hello";
var c = 'hello';
var d = 7/0;
var e = {name: "Isai", age:30};
var f = e.age;
var g = [0,2,4,6,8];
var h = null;
var i;
console.log(type(a));

/*
 * operators 
 *  arithmetic: + - * / %
 * bitwise & | >> << >>>
 * comparison > < >= <= == ==== != !==
 *
 */


/*
 * Guard operator &&
 *  if the first operand is truth, return the 2nd operand
 *  otherwise return the first operator
 *  instead of returning true or false, it returns the value of
 *  the appropriate operand
 * 
 */

var isLoggedin = true;
var username = "user";

var getUser = function(){
	return isLoggedIn && username;
}

/*
 * Default operator - ||
 * if the first operand is truthy, return the first operand
 * 	otherwise, return the second operand
 */

 
 /* 
 * 
 * Truthy and Falsy 
 * Falsy - null, 0, undefined, NaN, "", false
 * Truthy - anything else 
 */

/*
 * Objects 
 *  - can contain data and methods
 *  - can inherit from other objects
 *  - object literal {}
 *  - object can contain an unordered collection of name/value pairs
*/


/*
* Arrays
* - inherit from objects
* - array indexes are converted into string and used as names
* - array literal[]
* - do not specify length/type
* length number - not the actual # of elements stored 
*
*/

/*
 * Hoisting
 * variable declarations using var are treated as 
 * if they are at the top of the function (or
 * global scope, if declared outside of a function)
 * regardless of where the actual declaration occurs
 */
function getvalue(condition){
	
	if(condition){
		var value = "blue";
		return value;
	}
	
	else{
		//var has a value of undefined
			return null;
	}
	//var has a value of undefined
}

/*
 * The declaration of val is hoisted to the top while the
 * initialization remains in the same spot. That means that the
 * variable value is still accessible elsewhere in the function;
 * it just has a value of undefined.
 */


/*
 * understanding the let keyword
 * limits the variable to block scope 
 * opposite of hoisting
 */

function getValue(condition){
	
	if(condition){
		
	}
	
}




