/*
 * Functions 1-3 shall be implemented using normal JavaScript Syntax.
 */

// 1. Fibonacci Function
function fib(n) {
	if(n<= 1)
		return 1
	else
		return (fib(n-1) + fib(n-2));
}

function runFib() {
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

document.getElementById("doFib").addEventListener("click", runFib);



// 2. Bubble Sort
var array = [];
function bubbleSort() {
	var num = document.getElementById("bub").value;
	array.push(num);
	document.getElementById("bub").value = "";
	var disp = document.getElementById("bubDisplay");
	
	var sorted = false;
	var current = "";
	var temp,i,j;
	
	for (i = 0; i < array.length-1 && !sorted; i++) {
		sorted = true;
		for (j = 0; j < array.length - 1 - i; j++) {
			if (array[j] > array[j+1]) {
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				sorted = false;
			}
		}
	}
	
	for (i=0;i<array.length;i++) {
	    value = array[i];
	    current = current + " " + value;
	}
	disp.innerHTML = current;
}

document.getElementById("doBub").addEventListener("click", bubbleSort);



// 3. Reverse String
function reverseString() {
	var out = document.getElementById("strDisplay");
	var str = document.getElementById("str").value;
	var rev =  str.split("").reverse().join("");
	out.innerHTML = rev;
}

document.getElementById("reverseStr").addEventListener("click", reverseString);



/*
 * Functions 4-6 shall be implemented using jQuery.
 */

// 4. Factorial Function
$('#doFact').on('click',function() {
	$('#factDisplay').empty();
	var num = $('#fact').val();
	var fact = num;
	var i;
	
	for (i=num-1;i>0;i--)
		fact = fact*(num-i);
	
	$('#factDisplay').append(fact);
	$('#fact').val('');
});

// 5. Substring
$('#subStr').on('click',function() {
	$('#subStrDisplay').empty();
	var s = $('#fullstr').val();
	var l = $('#len').val();
	var o = $('#offset').val();
	var substr = s.substring(o,l);
	$('#subStrDisplay').append(substr);
});

// 6. Even Number without Modulus Operator
$('#doEven').on('click',function() {
	$('#evenDisplay').empty();
	var num = $('#even').val();
	
	if (!(num & 1))
		$('#evenDisplay').append('true');
	else
		$('#evenDisplay').append('false');
});






/*
var counter = 0;
function count(){
	counter += 1;
	document.getElementById("count").innerHTML = counter;
}

document.getElementById("count").addEventListener("mouseover", count);

document.getElementById("outer").addEventListener("click", function(){alert("In Outer!");}, false);

document.getElementById("middle").addEventListener("click", function() {alert("In Middle!");}, false);

document.getElementById("inner").addEventListener("click", function() {alert("In Inner!");}, false);
*/