/**
 * 
 */

/*
*fib
*/
function fib (n){
	//console.log(n);
	if(n<2) return 1;
	return fib(n-1)+fib(n-2);
}
function runFib(){
	//alert("hello!");
	var display= document.getElementById("fibDisplay");
	var n =document.getElementById("fib").value;
	display.innerHTML=fib(n);
}
document.getElementById("doFib").addEventListener("click", runFib);

//bubsort

function bub (arr){
	var n = arr.length;
    for (let i = 0; i < n-1; i++)
        for (let j = 0; j < n-i-1; j++)
            if (arr[j] > arr[j+1])
            {
                // swap temp and arr[i]
            	let temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
	
}

function ReverseString (arr){
	for(let i=arr.length-1; i>-1;i--)
	{
		arr+=arr[i];
		}
	arr=arr.substring(arr.length/2)
//console.log(arr);
return arr;
}


/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/

	function factorial(someNum) {
			if(someNum < 0){ System.out.println("cannot be negative"); return 0;}
			else if(someNum == 0) return 1;
			else{
				return someNum*factorial(someNum-1);
			}
		}

	
	
	/*


5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.

*/
	function substring(someStr, length, offset){
		var n="";
		if(offset>length)
			return alert("incorrect values for length / offset");
		for(let i = offset; i <length; i++)
			n+=someStr[i];
	}
	
	
	
	/*
	 * 6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
	 * 
	 */
	function isEven(someNum)
	{
		let hold= someNum/2;
		hold=Math.floor(hold)
		if(hold*2==someNum)
		return true;
		return false;
	}
	
	
// use let instead of var as var is function scope 
// let is block 
	
	