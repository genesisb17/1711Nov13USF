/**
 * Homework file for JavaScript
 */

//Part 1

/*
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
 */
function fib(n){
	if (n<=1){
		return n;
	} else {
		return fib(n-2)+fib(n-1);
	}

}

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array. 
 */
function bubbleSort(numArray){
	swaps=0;
	do {
		for(i=0;i<numArray.length-1;i++){
			if(numArray[i]>numArray[i+1]){
				swaps++;
				temp=numArray[i+1];
				numArray[i+1]=numArray[i];
				numArray[i]=temp;
			}
		}
	} while (swaps>0)
		return numArray;
}

/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
 */
function reverseStr(someStr){
	rev="";
	while(someStr.length>0){
		rev+=someStr.charAt(someStr.length-1);
	}
	return rev;
}

/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
 */
function factorial(someNum){
	if(someNum<1){
		fact=1;
	} else {
		fact=someNum+factorial(someNum-1);
	}
	return fact;
}

/*
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
 */
function substring(someStr, length, offset){
	sub="";
	if(offset+length>someStr.length){
		alert("Substring out of bounds.");
	} else if (offset<0 || offset>someStr.length-1){
		alert("Beginnng index out of bounds.");
	} else {
		for(i=offset; i<=offset+length;i++){
			sub+=someStr.charAt(i);
		}
	}
	return sub;
}

/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
 */
function isEven(someNum){
	check=true;
	if(someNum&1){
		check=false;
	}
	return check;
}

/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
 */
function isPalindrome(someStr){
	check=false;
	if(someStr.length>=1){
		check=true;
	} else{
		if(someStr.charAt(0)==someStr.charAt(someStr.length-1)){
			isPalindrome(someStr.subString(1,someStr.length-1));
		}
	}

	return check;
}

/*
8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%
Example for printShape("Triangle", 3, "$");
$
$$
$$$
Example for printShape("Diamond", 5, "*");
   *
  ***
 *****
  ***
   *
 */
function printShape(shape,height,character){
	switch(shape){
	case "Square":
		for(i=0;i<height;i++){
			row="";
			for(j=0;j<height;j++){
				row+=character;
			}
			console.log(row);
		}
		break;
	case "Triangle":
		for(i=0;i<height;i++){
			row="";
			for(j=0;j<i+1;j++){
				row+=character;
			}
			console.log(row);
		}

		break;
	case "Diamond":
		if(height>0 && height%2==0){
				height--;
		}
			expanding=height/2+0.5;
			tapering=height/2-0.5;
			maxWhite=height/2-0.5;
			maxChar=height;

			numWhite=maxWhite;
			numChar=1;
				for(i=0;i<expanding;i++){
					row="";
					for(j=0;j<numWhite;j++){
						row+=" ";
					}
					for(j=0;j<numChar;j++){
						row+=character;
					}
					numChar=numChar+2;
					numWhite--;
					console.log(row);
				}
				
				numWhite=1;
				numChar=maxChar-2;
				for(i=0;i<tapering;i++){
					row="";
					for(j=0;j<numWhite;j++){
						row+=" ";
					}
					for(j=0;j<numChar;j++){
						row+=character;
					}
					numChar=numChar-2;
					numWhite++;
					console.log(row);
				}
		break;
	default:
		console.log('Options are Square, Triangle or Diamond');
	}
}

/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/
function traverseObject(someObj){
	for(var property in someObj){
		if(someObj.hasOwnProperty(property)){
			console.log(property+': '+`${anObject[property]}`);
		}
	}
}

/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
 */
function deleteElement(someArr){
	console.log('Array length: '+someArr.length);
	delete someArr[3];
	console.log('Array length: '+someArr.length);
}

/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
 */
function spliceElement(someArr){
	console.log('Array length: '+someArr.length);
	someArr.splice(3,1);
	console.log('Array length: '+someArr.length);
}

/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
var john = new Person("John", 30);
*/
function Person(name,age){
	this.name=name;
	this.age=age;
}

/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
var john = getPerson("John", 30);
*/
function getPerson(name,age){
	return {name: name, age: age};
}

//Part 2
