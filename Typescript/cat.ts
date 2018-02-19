export class Feline {
    static readonly numLegs = 4;
    meow: string;
    fur: string;
    constructor(purr: string, fur: string){
        this.meow = purr;
        this.fur = fur;
    }
    // Classes can have "methods" << These are functions, don't get them confused
    speak() {
        console.log(this.meow);
    }
}

export class Lion extends Feline {
    // Classes can have static members
    public static origin = "Africa";
    roar: string;
    constructor(purr: string, fur: string, roar: string) {
        super(purr, fur);
        this.roar=roar;
    }
    // Override
    speak() {
        console.log(this.roar);
    }
}

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