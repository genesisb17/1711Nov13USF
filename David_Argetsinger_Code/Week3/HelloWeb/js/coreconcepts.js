/**
 * javascript is a scripting language for clientside operations 
 * javascript != java
 * c- like syntax 
 * js supports prototypal inheritance 
 * looslytype- don't specify datatype
 * value types: number, string object boolean null NaN(?) undefined
 * null is consisted an object
 */
 var a=5;
 var b="hello";
 var c='hello';
 var d = 7/0;
 var e= {name: "david", age:26};
 var w=e.age;
 
 /*
  * truthy and falsy 
  * falsy = null 0 undefined NAN "" false
  * truthy- all else 
  */
 
/*
 *arithamatic + - *  / %
 *bitwize & |  >> >>> <<
 * comparison > < >= <= == === != !==
 */
 
 //logical gaurd and efault || && ! !! 
 
 
 /*
  * GAURD OPERATOR && IF THE FIRST OPERAnd is truthy 
  * return 2nd operand otherwise return first operand 
  * -- isntead of returning true or false it returns the  value of the appropriate operand 
 */
 
 /*
 * objects can contain data and methods - can inherit from other objects 
 * - object literal {} can contain an  unordered collection of name / value pairs 
 */
 
 /*
  * arrays - inherit form objects -array indexes are converted into string and used as name to retrive values
  * array literal []- do not specify length/type - length number - not # of elemntes stored in the array but + 1 than size 
  * 
  */
 
 
 /*
  * functions 
  */
function add(a,b) {return (a+b)}

/*
*fib
*/
function fib (n){
	if(n<2) return 1;
	return fib(n-1)+fib(n-2);
}


var isLoggedIn=true;
var username="pink"
var getUser= function() { return isLoggedIn && username;} 
//if i am logged in the username comes in else returns false 
// if FIRST OPERATOR is true then  do second 


// || default operand , if first is truthly return first 
var getsCommision= 500;
var getRegSalary = 50;
var getsPaid= function(){return getsCommision || getRegSalary};


// hoisting varabile dec using var s trated are at the top of the function or 
// global scope 
// use let to keep in the scope ! 