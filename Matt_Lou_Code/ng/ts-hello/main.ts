
let a: number;
let b: boolean;
let c: string;
let d: any;
let e: number[] = [1, 2, 3];
let f: any[] = [1, true, 'a', false];

//declaring enums
const ColorRed = 0;
const ColorGreen = 1;
const ColorBlue = 2;

// implicitly Red = 0...Green = 1..etc
enum Color{Red = 0, Green = 1, Blue = 2};
let backgroundColor = Color.Red;

//by default if you don't set  variable, it is defined as 'any'
let message;
message = 'abc';
let endsWithC = (<string>message).endsWith('c');
let alternativeWay = (message as string).endsWith('c');

//arrow functions example, same as lambda expression

let log = function(message){
    console.log(message);
}

// if empty parameter, just leave parameter out
let doLog = (message) => console.log(message);

//declaring an interface
interface Point{
    x: number,
    y: number,
    // a draw function that return nothing, implementation will be somewhere else!
    draw: () => void
}

class Point{
    x: number;
    y: number;
    draw() {
        console.log('x: ' + this.x + ', Y: ' + this.y);
    }

    getDistance(another: Point){
        // ...
    }
}

let point = new Point();

// this will have an error because you did not declare an object, above is the way to
// declare an object
let point: Point;
point.draw();

// add a custom object
let drawPoint = (point: Point) => {
    //..
}

let getDistance = (pointA: Point, pointB: Point) => {
    //..
}

drawPoint({
    x: 1,
    y: 2
})



class Point {
    x: number;
    y: number;

    // the question mark means the parameter is optional, if you declare
    // 1 parameter optional, you must declare all optional!!!
    constructor(x?: number, y?: number){
        this.x = x;
        this.y = y;
    }
}

let point = new Point(1, 2);



// each file as a module, in order to use it, you have to use 
// export class Point{
    //....
// }

// in another file, you can do import {Point} from './point';

