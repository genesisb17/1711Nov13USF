

//--------------------------------- Fibonacci -----------------------------------//

function fib(n){
	if(n<=1) return n;
	else return (fib(n-1) + fib(n-2));
}


function runFib(){
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

document.getElementById("doFib").addEventListener("click", runFib); 


//------------------------------- Reverse String ---------------------------------//

function  ReverseString(S) {
	for(var i = 0; i < S.length(); i++) {
		S = S.substring(1, S.length() - i) 
		  + S.substring(0,1) 
		  + S.substring(S.length() - i, S.length());	
	}
	return S;
}

function runReverseString(){
	var display2 = document.getElementById("ReverseStringDisplay");
	var S = document.getElementById("RS").value;
	display2.innerHTML = ReverseString(S);
	
}
document.getElementById("doRS").addEventListener("click", runReverseString);


// -------------------------------  Factorial -------------------------------------//

function Fact(x){
	if(x <= 1) return 1;
	else return x * Fact(x - 1);
}

function runFact(){
	var display3 = document.getElementById("FactorialDisplay");
	var X = document.getElementById("Fact").value;
	display3.innerHTML = Fact(X);
	
}
document.getElementById("doFact").addEventListener("click", runFact);



// ---------------------------------- Substring -------------------------------------//

function subString(S, length, offset) {
	var T = "";
	for(var i = offset; i <= offset + length; i++){
		T += S.charAt(i);
	}
	return T;
}

function runsubString(){
	var display4 = document.getElementById("SubStringDisplay");
	var Z = document.getElementById("String").value;
	var W = document.getElementById("Length").value;
	var v = document.getElementById("offset").value;
	display3.innerHTML = subString(Z, W, V);
	
}
document.getElementById("doSub").addEventListener("click", runsubString);

// -------------------------------------- Even ---------------------------------------//

function Even(num) {
	  if((num & 1) == 0) 
		  return true;
	  else
	 
		 return false;
}


function runEven(){
	var display5 = document.getElementById("EvenDisplay");
	var J = document.getElementById("Even").value;
	display5.innerHTML = Even(J);
	
}
document.getElementById("doEven").addEventListener("click", runEven);


// -------------------------------- Splice Element -------------------------------//

function Splice(Arr){
	console.log(Arr.length);
	var newArr = Arr.splice(2,1);
	console.log(newArr.length);	
	return newArr;
}

function runSplice(){
	var display6 = document.getElementById("SpliceDisplay");
	var I = document.getElementById("Splice").value;
	display5.innerHTML = Splice(I);
	
}
document.getElementById("doSplice").addEventListener("click", runSplice);

/*
 * 
 * var counter = 0;
function count(){
	counter = counter + 1;
	document.getElementById("count").innerHTML = counter;
}

document.getElementById("count").addEventListener("mouseover", count);
 
document.getElementById("outer").addEventListener("click", function(){
	alert("IN OUTER");}, true)

document.getElementById("middle").addEventListener("click", function(){
	alert("IN MIDDLE");}, false);

document.getElementById("inner").addEventListener("click", function(){
	alert("IN INNER");}, true);
*/
	

