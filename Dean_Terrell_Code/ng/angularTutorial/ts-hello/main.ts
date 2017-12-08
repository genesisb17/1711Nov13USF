class Point {
    x: number;
    y: number;
    
    
    constructor(x?: number, y?: number) {
        this.x = x;
        this.y = y;
    }
    draw() {
        console.log('X: ' + this.x + ', Y: ' + this.y);
    }

    getDistance(another: Point) {
        // ...
    }
}

let point = new Point(1, 2);
point.draw();