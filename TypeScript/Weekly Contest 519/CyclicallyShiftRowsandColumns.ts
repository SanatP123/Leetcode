// 4052. Cyclically Shift Rows and Columns

// You are given an integer n, a 2D integer array grid of size n x n, and two integer arrays rowShift and colShift, each of length n, where:

// rowShift[i] represents the number of positions to cyclically shift the ith row of grid to the left.
// colShift[j] represents the number of positions to cyclically shift the jth column of grid upward.
// First, cyclically shift each row according to rowShift, then cyclically shift each column of the resulting grid according to colShift.

// Return the resulting grid after performing all the shifts.

// A cyclic left shift of a row by k positions moves the element at column j to column (j - k + n) % n. All other rows remain unchanged.

// A cyclic upward shift of a column by k positions moves the element at row i to row (i - k + n) % n. All other columns remain unchanged.


function cyclicShift(n: number, grid: number[][], rowShift: number[], colShift: number[]): number[][] {

    const result = Array.from({length : n}, () => Array(n));

    // Look at every element in the original grid
    for (let i = 0; i < n; i++){
        for (let j = 0; j < n; j++){

            // Apply the left shift of row i
            const newCol = (j - rowShift[i] + n) % n;

            // Apply the upward shift of that column
            const newRow = (i - colShift[newCol] + n) % n;

            // Put the element in the final position
            result[newRow][newCol] = grid[i][j];
        }
    }


    return result;
    
};


console.log(cyclicShift(2, [[1,2],[3,4]], [1,0], [0,1])); // Output: [[2,4],[3,1]]
console.log(cyclicShift(3, [[1,2,3],[4,5,6],[7,8,9]], [1,2,0], [2,2,1])); // Output: [[7,8,5],[2,3,9],[6,4,1]]
