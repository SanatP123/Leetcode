// Assign Umbrella on Rainy Days

// You are given a binary array rain of length n, where rain[i] == 1 means it rains on day i, and rain[i] == 0 means it does not.

// Alice and Bob share a single umbrella over these n days. On each day i:

// Alice needs the umbrella on day i if rain[i] == rain[i + 1] == 1 for 0 <= i < n - 1.
// Bob needs the umbrella if rain[i] == 1.
// At most one of them can receive the umbrella.
// If only one person needs it, that person receives it.
// If both need it, it goes to whoever has received it fewer times so far. If they are tied, it goes to Alice.
// If neither needs it, no one receives it.
// A person's count increases only on a day they receive the umbrella. Initially, both counts are 0.

// Return a string array answer of length n, where answer[i] is "Alice", "Bob", or "None", denoting who receives the umbrella on day i.

// A binary array is an array that contains only 0 and 1.

function assignUmbrella(rain: number[]): string[] {
    const n = rain.length;
    let countAlice = 0;
    let countBob = 0;
    let ans = [];

    for (let i = 0; i < n; i++){
        if (i < n-1 && rain[i] === rain[i+1] && rain[i+1] === 1){
            if (countAlice <= countBob){
                countAlice += 1; 
                ans.push("Alice");
            }
            else{
                countBob += 1;
                ans.push("Bob");
            }
        }
        else if (rain[i] === 1) {
            countBob += 1;
            ans.push("Bob");
        }

        else{
            ans.push("None");
        }
    }

    return ans;
    
};

console.log(assignUmbrella([1,1,0,1,1])); // Output: ["Alice", "Bob", "None", "Alice", "Bob"]
console.log(assignUmbrella([0,1,0,1])); // Output: ["None", "Bob", "None", "Bob"]