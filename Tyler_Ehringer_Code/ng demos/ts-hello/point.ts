export class Point {
    constructor(x?: number, y?: number) {
        this.x = x;
        this.y = y;
    }
    draw() {
        console.log(this.x + ', ' + this.y);
    }
}

