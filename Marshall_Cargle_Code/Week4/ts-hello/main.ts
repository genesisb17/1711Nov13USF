
   /* function log(message){
        console.log(message);
    }

    var message = 'Hello World';

    log(message);*/

    //var number =1;
    //let count = 2;

    /*function doSomething(){
        for(let i=0; i<5;i++){
            console.log(i);
        }
        console.log('Finally: '+ i);
    }

    doSomething();*/
    /*
    let count = 5;
    count ='a';*/
/*
    let a: number;
    let b: boolean;
    let c: string;
    let d: any;
    let e: number[]=[1,2,3];
    let f: any[]=[1,true,'a',false];

    const ColorRed =0;
    const ColorGreen = 1;
    const ColorBlue = 2;

    enum Color {Red=0, Green=1, Blue=2};
    let backgroundColor = Color.Red;
    */
    
    /*
    let message;
    message = 'abc';
    let endsWithC= (<string>message).endsWith('c');
    let alternativeWay = (message as string).endsWith('c');
    */

    /*
    let log = function(message) {
        console.log(message);
    }

    let doLog = (message) => {
        console.log(message);
    }
    //or this works 
    let doLog2 = (message) => console.log(message);
    //or no parameters
    let doLog3 = () => console.log();
    //or no () for 1 parameter, but recommended still
    let doLog4 = message => console.log(message);
    */

    /*
    interface Point{
        x: number,
        y: number
    }*/

    /*
    class Point{
        x: number;
        y: number;

        draw(){
            //...
        }

        getDistance(another: Point){
            //...
        }
    }

    let drawPoint = (point: Point)=>{
        //...
    }

    let getDistance = (pointA: Point, pointB: Point)=>{
        //...
    }
    */

    /*
    class Point{
        x: number;
        y: number;

        draw(){
            console.log('x: '+this.x+', y: '+this.y);
        }

        getDistance(another: Point){
            //...
        }
    }

    let point = new Point();
    point.x=1;
    point.y=2;
    point.draw();
    */

    /*
    class Point3{
        x: number;
        y: number;

        //the ? makes the parameter optional, so do not need to fill it out for the constructor
        //but all parameters to the right of a ? must also have a ?
        constructor(x?: number, y?: number){
            this.x=x;
            this.y=y;
        }

        draw(){
            console.log('x: '+this.x+', y: '+this.y);
        }
    }

    let point3 = new Point3(1,2);
    point3.draw();
    */

    /*
    class Point4{
        private x: number;
        private y: number;

        constructor(x?: number, y?: number){
            this.x=x;
            this.y=y;
        }

        draw(){
            console.log('x: '+this.x+', y: '+this.y);
        }
    }

    let point4 = new Point4(1,2);
    point4.draw();
    */

    /* 
    class Point4{
        private x: number;
        private y: number;

        constructor(x?: number, y?: number){
            this.x=x;
            this.y=y;
        }

        draw(){
            console.log('x: '+this.x+', y: '+this.y);
        }
    }

    //look into import
    import {Point4} from './point4';
    let point=new Point4(1,2);
    point.draw;

    let point4 = new Point4(1,2);
    point4.draw();
    */