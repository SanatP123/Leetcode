// Widest Possible Fence

// You are given an integer array planks, where planks[i] represents the height of the ith wooden plank. Each plank has a width of 1 unit.

// You want to build a fence consisting of planks that all have the same height.

// You may either use a plank as is, or combine exactly two distinct original planks into a single plank whose height equals the sum of their heights. Each original plank can be used at most once, and not all original planks need to be used.

// Return the maximum possible width of the fence that can be built.


function maximumWidth(planks: number[]): number {
    const frequency = new Map<number, number>();

    // Count the frequency of each plank height
    for (const plank of planks){
        frequency.set(plank, (frequency.get(plank) ?? 0) + 1);
    }

    // Widths from single planks
    const widths = new Map<number, number>(frequency);
    const lengths = [...frequency.keys()];

    // Add widths formed by pairing two plank heights
    for (let i = 0; i < lengths.length; i++){
        for (let j = i; j < lengths.length; j++){
            const a = lengths[i];
            const b = lengths[j];

            const freqA = frequency.get(a)!;
            const freqB = frequency.get(b)!;

            const pairs = a === b ? Math.floor(freqA/2) : Math.min(freqA, freqB);

            const target = a+b;

            widths.set(target, (widths.get(target) ?? 0) + pairs);
        }
    }

    // Find the maximum possible fence width.
    let ans = 0;
    for (const width of widths.values()) {
        ans = Math.max(ans, width);
    }

    return ans;
};


console.log(maximumWidth([1,3,2,5,7,5,4,2,1])); // Output: 4
console.log(maximumWidth([2,3,7])); // Output: 1