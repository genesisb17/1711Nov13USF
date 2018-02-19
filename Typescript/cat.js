"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
var Feline = /** @class */ (function () {
    function Feline(purr, fur) {
        this.meow = purr;
        this.fur = fur;
    }
    // Classes can have "methods" << These are functions, don't get them confused
    Feline.prototype.speak = function () {
        console.log(this.meow);
    };
    Feline.numLegs = 4;
    return Feline;
}());
exports.Feline = Feline;
var Lion = /** @class */ (function (_super) {
    __extends(Lion, _super);
    function Lion(purr, fur, roar) {
        var _this = _super.call(this, purr, fur) || this;
        _this.roar = roar;
        return _this;
    }
    // Override
    Lion.prototype.speak = function () {
        console.log(this.roar);
    };
    // Classes can have static members
    Lion.origin = "Africa";
    return Lion;
}(Feline));
exports.Lion = Lion;
// var cat = new Feline("mew", "brown");
// var lion = new Lion("rumble", "tan", "roar");
// var lion2 = new Lion("grumble", "white", "hi");
// // We can only access "origin" through the class to maintain it's singleton nature
// Lion.origin = "Savannah";
// function speakGeneric<T extends Feline> (cat: T): string {
//     if(cat instanceof Lion) {
//         return cat.roar;
//     } else {
//         return cat.meow;
//     }
// }
// window.onload=function(){
//     console.log(lion);
//     console.log(Lion.origin);
//     Feline.numLegs=5;
//     console.log(Feline.numLegs);
//     docment.geterelmentbyId("one");
// } 
