/* 
 * 
 * 
 */


/**
 * 
 */
/*1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.*/

function fib(n)
{
	if(n<=1) return n;
	else return (fib(n-1) + fib(n-2));
}

function runFib()
{
	//alert("HELLO!");
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

var counter = 0;

function count()
{
	counter = counter + 1;
	document.getElementById("count").innerHTML = counter;
}

document.getElementById("count").addEventListener("mouseover",count);

document.getElementById("doFib").addEventListener("click", runFib);

document.getElementById("outer").addEventListener("click", 
		function(){	alert("IN OUTER!");}, true);
		
document.getElementById("middle").addEventListener("click", 
		function() {alert("MIDDLE!");}, false);

document.getElementById("inner").addEventListener("click", function() {
	alert("INNER");}, true);

function runbs()
{
	var display = document.getElementById("bs");
	var n=document.getElementById("bubble").value;
	display.innerHTML = bs(n);
}

function bs()
{
	a = [2,1,3,4,7,5];
	var i =0;
	var j;
	var temp;
	for(i=0;i<a.length;i++)
		{
		for(j=0;j<a.length;j++)
			{
				if (a[j] >a[j+1])
					{
						temp = a[j+1];
						a[j+1]=a[j];
						a[j]=temp;
					}
			
			}
		}
	return a;
}


document.getElementById("dobs").addEventListener("click", runbs);

function r(s)
{
	var i;
	var s1="";
	for(i = s.length-1 ;i>=0;i--)
	{
		s1 += s[i];
		
	}
	return s1
}
function runr()
{
	var display = document.getElementById("br");
	var n=document.getElementById("reverse").value;
	display.innerHTML = r(n);
}
document.getElementById("dor").addEventListener("click", runr);

/*
 * 
 */

function f(n)
{
	if(n==1||n==0)
		return 1;
	else
		return n*f(n-1);
}


function runf()
{
	var display = document.getElementById("bf");
	var n=document.getElementById("fact").value;
	display.innerHTML = f(n);
}
document.getElementById("dof").addEventListener("click", runf);

function ss(s,l,o)
{
	var s1="";
	try
	{
	for(var i =o;i<o+l;i++)
		{
		s1 += s[i];
		}
	return s1;
	}
	catch(e)
	{
		alert("incorrect input");
	}
}

function runss()
{
	var display = document.getElementById("bss");
	var n=document.getElementById("sub").value;
	var l =document.getElementById("sub1").value;
	var o =document.getElementById("sub2").value;
	display.innerHTML = ss(n,l,o);
}
document.getElementById("doss").addEventListener("click", runss);

function e(n)
{
	var e=["0","2","4","6","8"]
	var i;
	var s = n.toString();
	for(i=0;i<e.length;i++)
	{
		if(s[s.length-1]==e[i])
			{
			return "even";
			}
	}
	return "odd";
}
function rune()
{
	var display = document.getElementById("be");
	var n=document.getElementById("even").value;
	display.innerHTML = e(n);
}
document.getElementById("doe").addEventListener("click", rune);