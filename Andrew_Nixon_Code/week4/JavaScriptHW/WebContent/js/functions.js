/**
 * 
 */

function fib(n){
	//console.log(n)
	if(n<=1) return 1;
	else return fib(n-1) + fib(n-2);
}

function bubbleSort(numArray){
	var n = numArray.length;
	var swapped = false;
	do {
		swapped = false;
		for(i = 1; i < n; i++){
			if (numArray[i-1] > numArray[i]){
				var t = numArray[i-1];
				numArray[i-1] = numArray[i];
				numArray[i] = t;
				swapped = true;
			}
		}
	}
	while(swapped)
}

function reversal(str){
	var result = str;
	for (i = 0; i < str.length - 1; i++){
		result = result + str.charAt(str.length - 2 - i);
	}
	result = result.substring(str.length - 1);
	return result;
}

function factorial(num){
	var fnum = 1;
	for(j = 1; j <= num; j++){
		fnum = fnum * j;
	}
	return fnum;
}

function substring(someStr, length, offset){
	var result = "";
	for (i = offset; i < (length + offset); i++){
		result = result + someStr.charAt(i);
	}
	return result;
}

function isEven(someNum){
	var ieresult = false;
	var temp = someNum / 2;
	while(temp >= 1) {
		temp--;
	}
	if (temp === 0) {
		ieresult = true;
	}
	
	return ieresult;
}

function isPalindrome(someStr){
	var ipresult = false;
	for (i = 0; i < (someStr.length / 2); i++){
		console.log(someStr.charAt(i));
		console.log(someStr.charAt(someStr.length - 1 - i));
		console.log(someStr.charAt(i) === someStr.charAt(someStr.length - 1 - i));
		if (someStr.charAt(i) === someStr.charAt(someStr.length - 1 - i)) {
			ipresult = true;
		}		
	}
	return ipresult;
}

function printShape(shape, height, character){
	switch (shape.toLowerCase()){
	case "square":
		for (i = 0; i < height; i++){
			var temp = "";
			for (j = 0; j < height; j++){
				temp = temp + character;
			}
			console.log(temp);
		}
		break;
	case "triangle":
		for (i = 1; i <= height; i++){
			var temp = "";
			for (j = 0; j < i; j++){
				temp = temp + character;
			}
			console.log(temp);
		}
		break;
	case "diamond":
		for (i = 1; i <= height; i++){
			var temp = "";
			for (j = 0; j < i; j++){
				temp = temp + character;
			}
			console.log(temp);
		}
		break;
	}
	
	
		
	
}