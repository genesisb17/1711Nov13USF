/**
 * Clike syntax
 * loosely types
 * 
 * 
 * 
 * 
 * variable types
 * number, string, object, boolean, null, NaN, undefined
 * null is considered an object in JS, can consider it a bug
 */

var a = 5;
var b = "hello";
var c = 'hello';
var d = 7/0;
var e = {name: "genesis", ago: 30};
var f = e.age;
var g = [0 , 2, 4, 6, 8];
var h = null;
var i;
console.log(typeof(a));

/*
* Truth and Falsy
* Falsy - null, 0, undef, NAN, "", false
* Truthy - anything else
* 
* Operators
* 
* arith: + - * / %
* bitwise & | >> >>> <<
* Compare > < >= <= == === != !==
* 
* logical includes guard and default && || ! !!
* 
* 
* 
* Guard Operator &&
* -if the first operand is truthy, return the 2nd operand
* 	otherwise return the first operand
* 
* -Instead of returning true or false, it returns the 
* value of the appropriate operand
*/
var isLoggedIn = true;
var username = "BillyBob";
var getUser = function(){
	return isLoggedIn && username;//if i want the user name, isLoggedIn must be true
}								  //otherwise, ill get false

/*
 * Default Operator - ||
 * if the first operand is truthy, return the first operand
 * otherwise, return the second operand
 */

var getsCommission = 1000;
var getRegSalary = 250;
var getsPaid = function(){
	return getsCommission || getRegSalary;
}


/* 
* Hoisting
* Variable declarations using var are treated as if they are at the top
*  of the function (or global scope, if declared outside of a function)
*  regardless of where the actual declaration occurs;
*  this is called hoisting
*  
*/

function getValue(condition){
	if(condition){
		var value = 'blue';
		return value;
	} else{
		//value exists here with a value of undefined
		return null;
	}
	//value exists 
}
/*
 * The declaration of value is hoisted to the top
 * while the initialization remains in the same spot. That
 * means that the variable value is still accessible elsewhere
 * in the function; it just has a value of undefined. 
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
* 
* Understanding LET keyword
* limits the variable to block scope.
* 
* 
* 
*/
function getValue(condition){
	var value;
	if(condition){
		let value = "blue";
		return value;
	} else{
		//value doesn't exist here
		return null;
	}
}


/* Actual arrays
* >var arr = [1, 3, 5, 6, 7, 9]
* <returns undef
* 
* >arr[3]
* <6
* 
* >arr.pop()
* <returns 9
* 
* >arr
* < [1,3,5,6,7]
* 
* >arr.shift()
* <1
* 
*>arr.push(10)
*<5
*
*>arr.unshift(0)
*<6
*
*arr
*[0,3,5,6,7,10]
*
*arr.indexOf(10)
*5
*
*arr.splice(2,3)
*[5,6,7]
*
*arr
*[0,3,10]
*
*arr.push(5)
*4
*
*var t = arr.splice(1,1)
*undef
*
*t
*[3]
* 
* arr
* [0, 10, 5]
* 
* var t = arr.splice(5,1)
* undef
* 
* t
* []
* 
* arr
* [0, 10, 5]
* 
* arr.indexOf(0)
* 0
* 
* var o = [,,,,,,] (empty array)
* undef
* 
* o.length
* 6
* 
* o.[0]
* undefined
* 
* arr[100] = 9
* 9
* 
* arr.length
* 101
* 
* arr [0,10,5,0, empty * 96]
* 
* Objects contain data and methods
* can inherit from other objects
* object literal {}
* 
* objects can contain an unordered collection of name/value paris
* 
* 
* Arrays
* inheirt from object
* arr indexes are converted into stings & used s names
* 	to retrieve values
* -array literal []
* do not specify length/type
* length number - not the actual# if elements stored in array but larger that the last index
* 
* 
* 
* 
*/

