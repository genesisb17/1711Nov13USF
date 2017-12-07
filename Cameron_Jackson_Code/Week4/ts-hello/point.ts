export class Point {
    x: number;
    y: number;
    
    // question mark makes parameter optional
    // once used, all parameters to the right should also be optional
    constructor(x?: number, y?: number) {
        this.x = x;
        this.y = y;
    }

    draw() {
        console.log('X: ' + this.x + ', Y: ' + this.y);
    }
}
