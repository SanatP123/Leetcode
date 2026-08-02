// 4008. Minimum Initial Strength to Defeat All Monsters

// You are given an integer array monsters, where monsters[i] represents the strength of the ith monster.

// You are also given a 2D integer array boosts, where boosts[i] = [li, ri, vi] indicates that vi is added to your temporary bonus while fighting any monster whose index lies in [li, ri]. Boost ranges may overlap, and the values of all applicable boosts are added together.

// You start with a non-negative initial strength and fight the monsters from left to right.

// For each monster at index i:

// Let bonus be the sum of the values of all boosts that apply to monster i.
// You can defeat the monster only if your current strength plus bonus is at least monsters[i].
// After defeating the monster, only your current strength decreases by monsters[i]. If it becomes negative, it is set to 0.
// Return the minimum initial strength required to defeat all monsters.

// Note: The temporary bonus is used only to determine whether the current monster can be defeated. It does not otherwise change your current strength.

function minInitialStrength(monsters: number[], boosts: number[][]): number {
    const n = monsters.length;

    const diff = new Array(n+1).fill(0);
    
    // Difference array for range boosts
    for (const[l,r,boost] of boosts){
        diff[l] += boost;
        diff[r+1] -= boost; 
    }

    let current_boost = 0, ans = 0, defeat = 0;

    // Compute the active bonus and required initial strength
    for (let i = 0; i < n; i++){
        current_boost += diff[i];
        if (current_boost < monsters[i]){
            ans = Math.max(ans, defeat + monsters[i] - current_boost);
        }
        defeat += monsters[i];
    }
    return ans;
};


console.log(minInitialStrength([5,10,15], [[1,1,10]])); // Output: 30
console.log(minInitialStrength([5,10,15], [[1,2,10],[1,2,5]])); // Output: 5
