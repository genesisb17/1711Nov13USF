/**
 * 1. Fibonacci
 * Define function: fib(n)
 * Return the nth number in the fibonacci sequence
 */
function fib(n) {
	if (n<1) return 1;
	return fib(n-1)+fib(n-2);
}


//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.
function bubbleSort(numArray) {
	var swapped;
	if (typeof(numArray) != "object") 
		return null;
	
	do {
		swapped = false;
		for (x = 0; x < numArray.length-1; ++x) {
			if (numArray[x] > numArray[x+1]) {
				var temp = numArray[x];
				numArray[x] = numArray[x+1];
				numArray[x+1] = temp;
				swapped = true;
			}
		}
	} while (swapped == true);
	return numArray;
}

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.
function reverseStr(someStr) {
	var x = 0;
	var temp;
	var charArr = someStr.split("");
	var newArr = []
	for (y = someStr.length; y > 0; --y) {
		newArr[y] = charArr[x];
		++x;
	}
	return newArr.join("");
}

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.


//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.


//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.