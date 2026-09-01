// The k Strongest Values in an Array

// Given an array of integers arr and an integer k.

// A value arr[i] is said to be stronger than a value arr[j] if |arr[i] - m| > |arr[j] - m| where m is the centre of the array.
// If |arr[i] - m| == |arr[j] - m|, then arr[i] is said to be stronger than arr[j] if arr[i] > arr[j].

// Return a list of the strongest k values in the array. Return the answer in any arbitrary order.

// The centre is the middle value in an ordered integer list. More formally, if the length of the list is n, the centre is the element in position ((n - 1) / 2) in the sorted list (0-indexed).

// For arr = [6, -3, 7, 2, 11], n = 5 and the centre is obtained by sorting the array arr = [-3, 2, 6, 7, 11] and the centre is arr[m] where m = ((5 - 1) / 2) = 2. The centre is 6.
// For arr = [-7, 22, 17, 3], n = 4 and the centre is obtained by sorting the array arr = [-7, 3, 17, 22] and the centre is arr[m] where m = ((4 - 1) / 2) = 1. The centre is 3.

function getStrongest(arr: number[], k: number): number[] {
    arr.sort((a,b) => a - b);
    const n = arr.length;

    // Find the centre value of the sorted array
    let centre = arr[Math.floor((n - 1)/2)];

    // Sort the array based on the distance from the centre, and if distances are equal, sort by value in descending order
    arr.sort((a:number, b:number) => {
        let val1 = Math.abs(a - centre);
        let val2 = Math.abs(b - centre);

        if (val1 !== val2){
            return val2 - val1;
        }

        return b - a;
    });

    // Return the first k elements of the sorted array
    return arr.slice(0,k);
};


console.log(getStrongest([1,2,3,4,5], 2)); // Output: [5,1]
console.log(getStrongest([1,1,3,5,5], 2)); // Output: [5,5]
console.log(getStrongest([6,7,11,7,6,8], 5)); // Output: [11,8,7,7,6]