/**
 * 1. fibonacci 
 *  Define function: fib(n)
 *  return the nth number in the fibonacci sequence.
 */

function fib(n){
	//console.log(n);
	if(n<=1) return n;
	return fib(n-1)+fib(n-2);
	
}

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.

function bubblesort(numArray){
	
	var n = numArray.length;
      for (i = 0; i < n-1; i++)
          for (j = 0; j < n-i-1; j++)
              if (numArray[j] > numArray[j+1])
              {
                  // swap temp and arr[i]
                  var temp = numArray[j];
                  numArray[j] = numArray[j+1];
                  numArray[j+1] = temp;
              }
      
      return numArray;
      
  }

//+3. Reverse String
//+Define function: reverseStr(someStr)
//+Reverse and return the String.

function reverseStr(someStr){
	
	var len = someStr.length;
	var count = len;
	//console.log(len);
	var temp = "";
	
	for(i = 0; i < len; i++){
		console.log(i);
		//console.log(someStr.charAt(i));
		temp += someStr.charAt(count-1);
		count--;
		
	}
	return temp	
}

//+4. Factorial
//+Define function: factorial(someNum)
//+Use recursion to compute and return the factorial of someNum.
function factorial(someNum){
	
	var result;
	if(someNum==0 || someNum ==1)
		return 1;
	
	result = factorial(someNum-1) * someNum;
	return result
	
	
}

//+5. Substring
//+Define function substring(someStr, length, offset)
//+Return the substring contained between offset and (offset + length) inclusively.
//+If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset){
	
	var string = "string";
	if( typeof someStr != typeofsomeStr)
		alert("a string wasn't passed in");
	var ret = someStr.substring(offset, offset+length);
	return ret;
	
}
//
//+6. Even Number
//+Define function: isEven(someNum)
//+Return true if even, false if odd.
//+Do not use % operator.
function isEven(someNum){
	
	if((someNum & 1)==0)
		return true;
	else
		return false;
	
}

function runFib(){

	//alert("Yo!");
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
	
}

var counter = 0;

function count(){
	
	counter = counter + 1;
	document.getElementById("count").innerHTML=counter;
}

dcoument.getElementById("count").addEventListener("mouseover",count);


document.getElementById("doFib").addEventListener("click",runFib);

document.getElementById("middle").addEventListener("click", 
		function(){alert("MIDDLE!");}, false);

document.getElementById("inner").addEventListener("click", 
		function(){alert("INNER!");}, false);

document.getElementById("outer").addEventListener("click", 
		function(){alert("OUTER!");}, false);
