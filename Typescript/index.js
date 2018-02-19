window.onload = test;
function test() {
    var input = document.getElementById("one").nodeValue;
    typeTest(+input);
}
function typeTest(number) {
    document.getElementById("two").innerHTML = String(number);
}
