/*
 * JavaScript is a scripting language for client-side operations 
 * JS!-Java JS is to java as ham is to hamster
 * C-like syntax
 * supports prototypal inheritance
 * loosely typed
 * value types: 
 */

/*
 * Variable types
 * number, string, object, boolean, null, NaN, undefined
 * null is considered an object in JS. can consider it a bug
 */
var a =5;
var b = "hello"
var c = 'hello';
var d=7/0;
var e = {name:"genesis",age:30};
var f = e.age;
var g = [0,2,4,6,8];
var h = null;
var i;
console.log(typeof(a));
//=== and !== compares data types
/*
 * 
 * Guard operator &&
 * --If the first operand is truthy, return the 2nd operand
 * 	otherwie return the first operand
 * -instead of returning true or false, 
 * it returns the value of the appropriate operand
 * 
 * always falsy 
 * 0,undefined,[],{}
 * do not compare things to boolean
 * weird with type comparison
 */
var x;
if([])
{
	x=10;
}
else
{
	x=1;
}
//study lms functions
//[]+[]=''
//[]+{}=Object
//{}+[]=0
//{}+{}=NaN
//objects can contain data and methods
/*
 * objects
 * can contain data and methods 
 * can inherit from other objects
 * object literal {}
 * objects can contain an unordered collection of name/value pairs.
*/
function add(a,b)
{
	return a+b;
}
//semi colon injection
function fib(n)
{
	if(n<2)
		return 1;
	return fib(n-1)+fib(n-2);
}

