document.getElementById("doFib").addEventListener("click", runFib);
document.getElementById("doBub").addEventListener("click", runBub);
document.getElementById("doRev").addEventListener("click", runRev);

function fib(n){
	console.log(n);
	if(n<=1) return n;
	else return (fib(n-1)+fib(n-2));
}

function runFib(){
	//alert("HELLO!");
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