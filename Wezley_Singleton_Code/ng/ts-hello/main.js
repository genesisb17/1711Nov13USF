//-- TypeScript (TS) is a superset of JavaScript (JS);
//-- TS is transpiled into JS for viewing in browsers (see main.js)
/*function log(message) {
    console.log(message);
}

var message = "Hello World!";

log(message);*/
//----------------------------------------------------------
//-- Declaring variables
//-- Scope
/*var number = 1; // scope of var extends to nearest function
let count = 2; // scope of let is restricted to current block

function doSomething() {
    for(var i = 0; i < 5; i++) {
        console.log(i);
    }

    console.log('Finally: ' + i); // i is still in scope (var)
}

function doSomethingElse() {
    for(let j = 0; j < 5; j++) {
        console.log(j);
    }

    console.log('Finally: ' + j); // i is out of scope (let)
    // BUT the TS compiler corrects this for you!
}

doSomething();
doSomethingElse();*/
//-----------------------------------------------------------
//-- Data Types
/*issues a warning since TS is strongly typed; but still
generates valid JS code*/
//let counter = 5;
//counter = '1';
//creates a variable reference of any type
//let a;
/*use 'type annotations' to create a variable of a certain
type without initializing it*/
//let b: number;
//b = 1;      // valid TS, valid JS
//b = 'a';    // invalid TS, valid JS
//let c: boolean;
//let d: string;
//let e: any;
//let f: number[] = [1, 2, 3];
//let g: any[] = [1, 'two', 3];
//enum Color { Red, Green, Blue };
//let backgroundColor = Color.Red;
//--------------------------------------------------------
//-- Type Assertions
/*let message;        // message is of data type: any
message = 'abc';    // still 'any'

// type assertion: method 1 (most common)
let endsWithC = (<string>message).endsWith('c');


let message2;       // message2 is of data type: any
message = 'cba';    // still 'any'

// type assertion: method 2
let endswithA = (message as string).endsWith('a');*/
/* NOTE: type assertion DOES NOT change the data type of
the variable at runtime; it merely gives us access to the
properties and methods of the asserted type*/
//------------------------------------------------------------
//-- Arrow Functions (Think: Java lambda functions)
/*
// old-school way
let log = function(message) {
    console.log(message);
}

// arrow way: ex 1
let doLog = (message) => {
    console.log(message);
}

// arrow way: ex 2 (when function block is one line)
let doLog2 = (message) => console.log(message);

// arrow way: ex 3 (no parameters)
let doLog3 = () => console.log('Hi');*/
//---------------------------------------------------------
//-- Interfaces
/*
// without an interface
// inline annotation (very verbose, too be avoided)
let drawPoint = (point: { x: number, y: number}) => {
    // ...
}

drawPoint({
    x: 1,
    y: 2
})

// with interface

interface Coordinate {
    x: number,
    y: number
}

let drawCoordinate = (coordinate: Coordinate) => {

}*/
/* Just like in Java, interfaces cannot contain implemented methods,
though the can have abstract methods (without implementation)*/
//--------------------------------------------------------
//-- Classes, Objects, Constructors, Access Modifers
// cohesion - things that are related should go into a single unit
// consider the Coordinate interface and functions above.
// they are related, so best to put them in a class:
// Access modifiers:
//      - public (default)
//      - protected
//      - private
var Coordinate = /** @class */ (function () {
    // FIELDS CAN OPTIONALLY BE DECLARED IN THE CONSTRUCTOR
    /*private x: number;          //private field (use getters and setters to access)
    private y: number;          //private field (use getters and setters to access)*/
    // YOU CAN ONLY HAVE ONE CONSTRUCTOR IN TYPESCRIPT
    // to mimic multiple constructors, make parameters optional (? after variable name)
    // access modifiers can be used in the constructor to declare fields
    function Coordinate(x, y) {
        this.x = x;
        this.y = y;
        //this.x = x;       //unnecessary if the field is declared in the constructor
        //this.y = y;       //unnecessary if the field is declared in the constructor
    }
    Coordinate.prototype.getX = function () {
        return this.x;
    };
    Coordinate.prototype.getY = function () {
        return this.y;
    };
    Coordinate.prototype.setX = function (x) {
        this.x = x;
    };
    Coordinate.prototype.setY = function (y) {
        this.y = y;
    };
    Coordinate.prototype.draw = function () {
        console.log('x: ' + this.x + ', y: ' + this.y);
    };
    Coordinate.prototype.getDistance = function (another) {
        // ...
    };
    return Coordinate;
}());
// Ineffective way of initializing class fields
//let coordinate = new Coordinate();      // create an instance with the constructor
//coordinate.x = 1;
//coordinate.y = 2;
//coordinate.draw();
// Class field initialization using constructor
var coordinate = new Coordinate();
coordinate.draw();
//  
