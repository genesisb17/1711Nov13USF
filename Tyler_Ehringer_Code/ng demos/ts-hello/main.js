var Colour;
(function (Colour) {
    Colour[Colour["Red"] = 1] = "Red";
    Colour[Colour["Green"] = 2] = "Green";
    Colour[Colour["Blue"] = 3] = "Blue";
})(Colour || (Colour = {}));
var backgroundColor = Colour.Red;
var doLog = console.log;
var Point = /** @class */ (function () {
    function Point(x, y) {
        this.x = x;
        this.y = y;
    }
    Point.prototype.draw = function () {
        console.log(this.x + '  ' + this.y);
    };
    return Point;
}());
var point = new Point(5, 15);
point.draw();
