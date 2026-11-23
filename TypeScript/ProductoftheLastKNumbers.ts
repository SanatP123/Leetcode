// Product of the Last K Numbers

// Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.

// Implement the ProductOfNumbers class:

// ProductOfNumbers() Initializes the object with an empty stream.
// void add(int num) Appends the integer num to the stream.
// int getProduct(int k) Returns the product of the last k numbers in the current list. You can assume that always the current list has at least k numbers.
// The test cases are generated so that, at any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.


class ProductOfNumbers {
    prefix : number[];
    constructor() {
        this.prefix = [1];
        
    }

    add(num: number): void {
        if (num === 0){
            // zero resets the prefix
            this.prefix = [1]; 
        }
        else{
            // store running product of everything since the last reset
            this.prefix.push(this.prefix[this.prefix.length - 1] * num);
        }
    }

    getProduct(k: number): number {
        const n = this.prefix.length;
        // window reaches back across a zero reset (n - 1 - k < 0 i.e. k >= n)
        if (k >= n) return 0;

        // divide out everything except the last k numbers
        return this.prefix[n-1] / this.prefix[n-1-k];
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * var obj = new ProductOfNumbers()
 * obj.add(num)
 * var param_2 = obj.getProduct(k)
 */

const ops = ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"];
const args = [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]];

const output: (number | null)[] = [];
let obj!: ProductOfNumbers;

for (let i = 0; i < ops.length; i++) {
    if (ops[i] === "ProductOfNumbers") { obj = new ProductOfNumbers(); output.push(null); }
    else if (ops[i] === "add") { obj.add(args[i][0]); output.push(null); }
    else if (ops[i] === "getProduct") { output.push(obj.getProduct(args[i][0])); }
}

console.log("Input:", JSON.stringify(ops));
console.log("       ", JSON.stringify(args));
console.log("Output:", JSON.stringify(output));
