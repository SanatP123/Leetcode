// Minimum Queen Moves to Reach Target

// There is an 8 x 8 empty chessboard with 1-indexed rows and columns.

// You are given an array source = [sr, sc] representing the starting position of a queen, and an array target = [tr, tc] representing the target position.

// In one move, the queen travels one or more squares along a single row, column, or diagonal, staying within the board.

// Return the minimum number of moves for the queen to land exactly on target.

// Constraints:​​​​​​​

// source == [sr, sc]
// target == [tr, tc]
// 1 <= sr, sc, tr, tc <= 8

function minQueenMoves(source: number[], target: number[]): number {
    
    let sr = source[0]
    let sc = source[1];
    let tr = target[0];
    let tc = target[1];

    if (sr === tr && sc === tc){
        return 0;
    }
    // Same row or column
    if (sr === tr || sc === tc ){
        return 1;
    }

    // Same diagonal
    if (Math.abs(sr - tr) === Math.abs(sc - tc)){
        return 1;
    }

    return 2;
    
};


console.log(minQueenMoves([8,1], [1,8])); // Output: 1
console.log(minQueenMoves([1,1], [1,1])); // Output: 0
console.log(minQueenMoves([4,2], [1,3])); // Output: 2