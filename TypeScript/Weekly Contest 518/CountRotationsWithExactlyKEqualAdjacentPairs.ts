// Count Rotations With Exactly K Equal Adjacent Pairs

// You are given a string s of length n and an integer k.

// A cyclic rotation of s is obtained by choosing a prefix of s whose length is between 0 and n - 1 (inclusive), and moving it to the end of the string while preserving the order of all characters.

// For every cyclic rotation of s, let its score be the number of indices i such that 0 <= i < n - 1 and the characters at positions i and i + 1 are equal.

// Return the number of cyclic rotations of s whose score equals k.

function countRotations(s: string, k: number): number {
    let rotations = 0;

    for (let i = 0; i < s.length; i++){
        const cyclic = s.slice(i) + s.slice(0,i);
        let count = 0;

        for (let j = 0; j < cyclic.length - 1; j++){
            if (cyclic[j] === cyclic[j+1]){
                count++;
            }
        }

        if (count === k){
            rotations++;
        }


    }

    return rotations;
    
};

console.log(countRotations("aab", 1)); // Output: 2
console.log(countRotations("abca", 0)); // Output: 1
