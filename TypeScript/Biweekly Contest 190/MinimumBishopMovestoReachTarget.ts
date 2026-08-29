// Minimum Bishop Moves to Reach Target
// There is an 8 x 8 empty chessboard with 1-indexed rows and columns.
// You are given an array source = [sr, sc] representing the starting position of a bishop, and an array target = [tr, tc]. In one move, the bishop travels any number of squares along a single diagonal direction, staying within the board.
// Return the minimum number of moves for the bishop to land exactly on target. If it can never reach target, return -1.

function minBishopMoves(source: number[], target: number[]): number {
    let sr = source[0], sc = source[1], tr = target[0], tc = target[1];

    // If source and target are situated in different colors target cannot be reached
    if ((sr + sc) % 2 !== (tr + tc) % 2){
        return -1;
    }

    // If they are on the same diagonal, target can be reached in one move
    if (sr - sc === tr - tc || sr + sc === tr + tc){
        return 1;
    }

    // If different diagonals still the target can be reached in two moves
    return 2;
    
};


console.log(minBishopMoves([8,1], [1,8])); // Output: 1
console.log(minBishopMoves([4,2], [1,3])); // Output: 2
console.log(minBishopMoves([1,1], [3,4])); // Output: -1