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
 * = sets value
 * == compares value
 * === compares value with type
 */
/*
 * Operators
 */

/*
 * Guard Operator &&
 * - If the first operand is truthy, return the 2nd operand 
 * 		otherwise return the first operand
 * - instead of returning true or false, it returns the 
 * 		value of the appropriate operand
 */

/*
 * Truthy and Falsy
 * Each value has an inherant boolean value
 * Falsy - null, 0, underfined,NaN, "", false
 * Truthy - everything else
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
 * 
 * 
 */
/*
 * Functions
 * 
 */
function add(a, b) {
	return a+b
}
/*
 * Semicolons not needed, but semicolon injection could mess code up down 
 * 		the road, so safer to just have them
 */

/*
 * 
 * 
 */
