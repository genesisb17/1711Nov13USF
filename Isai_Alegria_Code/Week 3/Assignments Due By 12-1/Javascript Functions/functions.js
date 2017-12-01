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

function runFib(){

	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.

var arr = [];

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

function runBubble(){
	var display = document.getElementById("bubDisplay");
	bubArray = bubbleSort(array);
	var data = "";
	for(var i = 0; i < bubArray.length; i++) {
		data += " " + bubArray[i];
	}
	display.innerHTML = data;
}

function enterArray(){
	arr.push(document.getElementById("bub").value);
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

function runFact(){
	//alert("HELLO!");
	var display = document.getElementById("facDisplay");
	var n = document.getElementById("fac").value;
	display.innerHTML = factorial(n);
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

function runReverse(){
	//alert("HELLO!");
	var display = document.getElementById("strDisplay");
	var n = document.getElementById("str").value;

	display.innerHTML = reverseString(n);
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

function runEven(){
	var display = document.getElementById("evenDisplay");
	var n = document.getElementById("ev").value;
	display.innerHTML = isEven(n);
}

function runFib(){

	//alert("Yo!");
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
	
}




document.getElementById("doFib").addEventListener("click",runFib);
document.getElementById("doBub").addEventListener("click", runBubble);
document.getElementById("addBub").addEventListener("click", enterArray);
document.getElementById("revStr").addEventListener("click", runReverse);
document.getElementById("fact").addEventListener("click", runFact);
document.getElementById("isEven").addEventListener("click", runEven);

