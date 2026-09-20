// Number of Intersecting Interval Pairs I

// You are given a 2D integer array intervals of n elements, where intervals[i] = [starti, endi] represents the closed interval from starti to endi.

// Return the number of pairs of indices (i, j) such that 0 <= i < j < n and intervals[i] and intervals[j] intersect.

// Two intervals intersect if they have at least one point in common, including when they only share an endpoint.

function countIntersectingIntervals(intervals: number[][]): number {

    let total_pairs = 0;

    for (let i = 0; i < intervals.length; i++){
        for (let j = i + 1; j < intervals.length; j++){
            const [prevStart, prevEnd] = intervals[i];
            const [currStart, currEnd] = intervals[j];

            // Check if the two intervals overlap
            if (prevStart <= currEnd && currStart <= prevEnd){
                total_pairs++;
            }

        }
    }
        

    return total_pairs;
    
};

console.log(countIntersectingIntervals([[1,2],[2,3],[3,4]])); // Output: 2
console.log(countIntersectingIntervals([[1,5],[2,4],[3,6]])); // Output: 3
console.log(countIntersectingIntervals([[1,2],[3,4],[5,6]])); // Output: 0