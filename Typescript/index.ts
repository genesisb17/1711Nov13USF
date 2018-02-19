window.onload=test;

function test(){
    let input = document.getElementById("one").nativeElement.value;
    typeTest(+input);
}

function typeTest(number: Number) {
    document.getElementById("two").innerHTML=String(number);
}