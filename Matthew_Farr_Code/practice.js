function fibRec(n) {
  if (n<3)
    return 1;
  else
    return fibRec(n-1) + fibRec(n-2);
}

function fibItr(n){
  var a = 1;
  var b = 1;
  if (n<3)
    return 1;
  for (var i=2; i<n; i++) {
    var temp = b;
    b = a + b;
    a = temp;
  }
  return b;
}

function bubbleSort(arr) {
  var n = arr.length;
  for (var i=0; i<n; i++) {
    for (var j=0; j<n-1-i; j++) {
      if (arr[j] > arr[j+1]) {
        // Use bitwise XOR to swap array elements
        arr[j] = arr[j] ^ arr[j+1]
        arr[j+1] = arr[j] ^ arr[j+1];
        arr[j] = arr[j] ^ arr[j+1]
      }
    }
  }
  return arr;
}

function reverseStr(str) {
  var charArr = str.split('');
  var n = charArr.length;
  for (var i=0; i<n/2; i++) {
    var temp = charArr[n-1-i];
    charArr[n-1-i] = charArr[i];
    charArr[i] = temp;
  }
  return charArr.join('');
}

function factorial(n) {
  return (n<2) ? 1 : n * factorial(n-1);
}

function substr(str, idx, len) {
  charArr = str.split('');
  if (idx < 0) {
    alert ("Index cannot be negative.");
    return -1;
  }
  else if (idx >= charArr.length) {
    alert ("Index outside of string bounds.");
    return -1;
  }
  else if (len < 1) {
    alert ("Length must be a positive integer");
  }
  else if (idx+len > charArr.length) {
    alert ("Substring would extend past string bounds.");
    return -1;
  }
  var tempArr = [];
  for (var i=idx; i<idx+len; i++) {
    tempArr.push(charArr[i]);
  }
  return tempArr.join('');
}

function isEven(num) {
  return (num & 1) === 0;
}
