/*
 *  Modules (Part 1 of 2 -- see main.ts for Part 2)
 * 
 *  In TypeScript, we divide our program into multiple files
 *  in each file we export one or more types (classes, functions,
 *  simple variables, or objects). Wherever we need to use the
 *  functionality of a module, we simple import into the
 *  module that needs it.
 */

export class Point {
    constructor(private x?: number, private y?:number) {}

    draw(x, y) {
        console.log('x: ' + this.x + 'y: ' + this.y);
    }
}