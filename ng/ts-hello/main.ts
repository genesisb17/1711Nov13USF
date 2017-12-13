function log(message){
    console.log(message);
}

var message = "hellooooooooo world!";

log(message);

//tsc main.ts "Transpiles" our ts file to js

////////////////TYPESCRIPT VAR DECLARATIONS
var number = 1; // ES5 - supported by essentially all browsers 
let num = 2; // ES6



function doSomething(){
    for (var i=0; i < 5; i++){
        console.log(i);
    }
    console.log('Finally: ' + i);
}

doSomething();


// types
let count = 5; // behind the scenes says let count: number
//count = 'a'; //cannot be assigned to type var; typescript is strongly typed
//better to write code in TS so we get compilation errors 

let x; // let x: any

//if we don't know the type of var ahead of time, we use type annoyations

let a: number;
let b: boolean;
let c: string;
let d: number[];
let e: any[];
e = [1, true, 'a', false];


//can also define enums
const ColorRed = 0;
const ColorGreen = 1;
const ColorBlue = 2;

//enum Color {Red, Green, Blue}; // values auto get values of 0,1,2... ; but we should explicitly set them
enum Color{Red =0, Green= 1, Blue = 2};
let backgroundColor = Color.Red;

//type assertions - talks to compiler so we can use "intellisense"
let m;
m= 'abc';
let endsWithC = (<string>m).endsWith('c');
let alt = (m as string).endsWith('c');

//arrow functions 
let logger = function(message){
    console.log(message);
}

let arrowLogger = (message)  =>  console.log(message);
let printer = () => console.log("hi");

// custom types in TS
let drawPoint = (x: number, y:number) =>{
    // dont care about algorithm we just want to think about the declaration
}

interface Point{
    x:number,
    y:number
}

let point2 = (point: Point)=>{
    // things 
}

//access modifiers 
//public, private, protected