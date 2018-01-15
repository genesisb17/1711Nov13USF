export class Point{
    private  x:number;
    private  y:number;
     // only one constructor 
     //all ? to the right are optional or should be 
    constructor(x?:number, y?:number){
        this.x=x;
        this.y=y;
    }
     draw(){
         console.log('X: '+ this.x + 'Y: '+ this.y);
     }

      getDistance(another: Point){
        
         }
}        
