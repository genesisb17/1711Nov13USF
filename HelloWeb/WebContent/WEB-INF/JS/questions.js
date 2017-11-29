/**
 * 
 */
function fi(n)
{
	if (n<=1) return n;
	else
		return fib(n-1)+fib(n-2);
}

function runFib()
{
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}
document.getElementById("doFib").addEventListener("click", runFib)
document.getElementById("outer").addEventListener("click",function(){alert("In outer");},true)
document.getElementById("middle").addEventListener("click",function(){alert("In middle");},true)
document.getElementById("inner").addEventListener("click",function(){alert("In inner");},true)
//event propagation is where elements are 

function count()
{
	counter = counter+1;
	document.getElementById("count").innerHTML=counter;
}
function bs(a)
{
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
function f(n)
{
	if(n==1||n==0)
		return 1;
	else
		return n*f(n-1);
}
f(5);

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
function e(n)
{
	var e=["0","2","4","6","8"]
	var i;
	var s = n.toString();
	for(i=0;i<e.length;i++)
	{
		if(s[s.length-1]==e[i])
			{
			return true;
			}
	}
	return false;
}
e(2);
e(3);