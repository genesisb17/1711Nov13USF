function fib(n){
	if(n <= 2) return 1;
	return fib(n-1)+fib(n-2);
}

function bubble(l){
	for(let i = 1; i < l.length; i++){
		for(let j = 1; j < i; j++){
			if(l[j] < l[j-1]){
				let temp = l[j];
				l[j] = l[j-1];
				l[j-1] = temp;
			}
		}
	}
}

document.getElementById("doFib").addEventListener("click", function(){
	//alert("hello");
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
});

function reverse(s){
	if(s.length < 2) return s;
	return s.charAt(s.length-1) + reverse(s.slice(0, s.length-1));
}

function factorial(n){
	if(n < 2) return 1;
	return n * factorial(n-1);
}

function substring(s, len, offset){
	return s.slice(offset, offset + len);
}

function isEven(n){
	return (n & 1) == 0;
}