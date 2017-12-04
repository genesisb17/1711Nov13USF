document.getElementById("doFib").addEventListener("click", runFib);
document.getElementById("doBub").addEventListener("click", runBub);
document.getElementById("doRev").addEventListener("click", runRev);
document.getElementById("doFac").addEventListener("click", runFac);
document.getElementbyId("doSub").addEventListener("click", runSub);
document.getElementById("doEven").addEventListener("click", runEven);

function fib(n){
	console.log(n);
	if(n<=1) return n;
	else return (fib(n-1)+fib(n-2));
}

function runFib(){
	var display = document.getElementById("fibDisplay");
	var n=document.getElementById("fib").value;
	display.innerHTML=fib(n);
}

function bubbleSort(numArray){
	let extra = 0;
	for (let i=0; i < numArray.length; i++) {
		for (let j=0; j < numArray.length; j++) {
			if (numArray[j] > numArray[i]) {
				extra = numArray[j];
				numArray[j] = numArray[i];
				numArray[i] = extra;
			}
		}
	}
	return numArray;
}

function runBub(){
	var numArray = [5,4,6,2,7,1,9,3,8];
	var display = document.getElementById("bubDisplay");
	display.innerHTML=bubbleSort(numArray);
}

function runRev(){
	var display=document.getElementById("revDisplay");
	var s=document.getElementById("str").value;
	display.innerHTML=reverse(s);
}

function reverse(s){
	console.log(s);
	for(let i=0; i<s.length;i++)
		s=s.substring(1, s.length-i)+s.substring(0,1)+s.substring(s.length-i);
	return s;
}

function fac(n){
	console.log(n);
	if(n==1) return 1;
	else return (n*fac(n-1));
}

function runFac(){
	var display = document.getElementById("facDisplay");
	var n=document.getElementById("fac").value;
	display.innerHTML=fac(n);
}

function runSub(){
	var display = document.getElementById("subDisplay");
	var s=docuemnt.getElementbyId("subStr").value;
	var n=document.getElementById("subLen").value;
	//if(typeof(n)=="String")
		//alert("Wrong value for Substring");
	var a=document.getElementById("subOff").value;
	//if(typeof(a)=="String")
		//alert("Wrong value for Substring");
	display.innerHTML=sub(s,n,a);
}

function sub(s,n,a){
	return s.substring(n, n+a);
}

function runEven(){
	//var display = document.getElementById("evenDisplay");
	//var n=document.getElementById("eve").value;
	//display.innerHTML=even(n);
	alert(even(5));
}

function even(n){
	return 2 % 0 ==0;
}
