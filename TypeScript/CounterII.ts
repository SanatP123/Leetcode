type Counter = {
    increment: () => number,
    decrement: () => number,
    reset: () => number,
}

function createCounter(init: number): Counter {
    let curr = init;
    return {
        increment: () => {
            curr++;
            return curr;
            },
        decrement: () => {
            curr--;
            return curr;
        },
        reset: () => {
            curr = init;
            return curr;
        }
    }
    
};


// ---------- Test Case 1 ----------
console.log("Test Case 1");

const counter1 = createCounter(5);

console.log(counter1.increment()); // Expected: 6
console.log(counter1.reset());     // Expected: 5
console.log(counter1.decrement()); // Expected: 4

// ---------- Test Case 2 ----------
console.log("\nTest Case 2");

const counter2 = createCounter(0);

console.log(counter2.increment()); // Expected: 1
console.log(counter2.increment()); // Expected: 2
console.log(counter2.decrement()); // Expected: 1
console.log(counter2.reset());     // Expected: 0
console.log(counter2.reset()); // Expected: 0