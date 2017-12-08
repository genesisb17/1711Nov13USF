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

/*
//-- Classes, Objects, Constructors, Access Modifers

// cohesion - things that are related should go into a single unit
// consider the Coordinate interface and functions above.
// they are related, so best to put them in a class:

// Access modifiers:
//      - public (default)
//      - protected
//      - private

class Coordinate {
   // FIELDS CAN OPTIONALLY BE DECLARED IN THE CONSTRUCTOR
   //private x: number;          //private field (use getters and setters to access)
   //private y: number;          //private field (use getters and setters to access)
   
    // YOU CAN ONLY HAVE ONE CONSTRUCTOR IN TYPESCRIPT
    // to mimic multiple constructors, make parameters optional (? after variable name)
    // access modifiers can be used in the constructor to declare fields
    constructor(private x?: number, private y?: number, private _z?: number) {
        //this.x = x;       //unnecessary if the field is declared in the constructor
        //this.y = y;       //unnecessary if the field is declared in the constructor
    }

    // traditional way of using getters and setters
    public getX() {     // 'public' declaration not needed, since it is default
        return this.x;
    }

    setX(x) {
        if (x < 0) {
            throw new Error('x value cannot be less than 0!');
        }

        this.x = x;
    }

    // TypeScript way of using gettings and setter
    get Y() {           // Y must be capitalized, otherwise we get naming collisions
        return this.y;  // to avoid this declare the variable initially with an '_'
    }

    set Y(y: number) {
        this.y = y;
    }

    get z() {           // NOTICE: no naming collision, since z was declared with an _
        return this._z; // this is proper naming convention in TypeScript
    }

    set z(z: number) {
        this._z = z;
    }

    draw() {            //function
        console.log('x: ' + this.x + ', y: ' + this.y);
    }

    getDistance(another: Coordinate) {  // function
        // ...
    }
}

// Ineffective way of initializing class fields
//let coordinate = new Coordinate();      // create an instance with the constructor
//coordinate.x = 1;
//coordinate.y = 2;
//coordinate.draw();

// Class field initialization using constructor
//let coordinate = new Coordinate();
//coordinate.draw();

let coordinate2 = new Coordinate (1, 2);
let y = coordinate2.Y;  // using our new-style getter
coordinate2.Y = 4;      // using our new-style setter
*/

//-------------------------------------------------------------------------------------


// -- Module (Part 2 -- see point.ts for Part 1)

// syntax for importing the functionality of other classes
import { Point } from './point';

let point = new Point(1, 2);
point.draw(2, 1);