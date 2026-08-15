// Elevator Requests I

// You are given an integer n denoting the number of floors in a building, where the floors are numbered from 0 to n - 1.

// You are also given an integer array requests, where requests represents the sequence of floor requests.

// An elevator starts at floor 0, and follows these rules:

// The elevator moves one floor per second.
// The elevator serves requests in the given order.
// If the elevator is already on the requested floor, no movement is needed.
// After serving a request, the elevator immediately starts moving toward the next request.
// Return the total time (in seconds) required to serve all requests.


function elevatorRequests(n: number, requests: number[]): number {
    let current = 0; 
    let totalTime = 0;
    
    for (const req of requests){
        if (current === req){
            continue;
        }
        else{
        totalTime += Math.abs(req - current);
        current = req;
        }
        
    }

    return totalTime;
    
};

console.log(elevatorRequests(5, [2,1,4,3])); // Output: 7
console.log(elevatorRequests(3, [2,0,0])); // Output: 4