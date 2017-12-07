
/*function log(message)
{
    console.log(message);
}
var message = "hello ladies ;)";
log(message);
*/
/*function doSomething()
{
    for(var i =0;i<5;i++)
    {
        console.log(i);
    }
    console.log("finally: "+i);
}
doSomething();*/
/*let count;
count = 1;
count = true;
count ='a';
let a:number;
let b:boolean;
let c:string;
let d:any;
let e:number[];
let f:any[]=[1,true,3,false];
const cred = 0;
const cgreen = 1;
const cblue =2;

enum Color{red=0,green=1,blue=2,Purple=3};
let backgroundColor = Color.red;*/

/*let message;
message = 'abc';
let endsWithC = message.endsWith('c');
//let alternativeWay = */
/*let log = function(message)
{
    console.log(message);
}

let doLog= (message)=>console.log();
*/
/*interface point{
    x:number,
    y:number,
    draw:()=>void
}*/

export class point{
    x:number;
    y:number;
    constructor(x?:number,y?:number)
    {
        this.x = x;
        this.y = y;
    }
    draw()
    {
        console.log('X: '+this.x+'Y: '+this.y);
    }
    getDistance(another:point)
    {

    }
}

let poin1 = new point(1,2);
poin1.draw();
//poin.z=3;
//poin.draw();

