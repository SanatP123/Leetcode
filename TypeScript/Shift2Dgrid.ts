function shiftGrid(grid: number[][], k: number): number[][] {
    const rowLength = grid.length - 1;
    const columnLength = grid[0].length - 1;

    for (; k > 0; k--){
        let temp = grid[rowLength][columnLength]
        for (let i = 0; i <= rowLength ; i++){
            for(let j = 0; j <= columnLength; j++){
                let curr = grid[i][j];
                grid[i][j] = temp;
                temp = curr;
            }
        }
    }

    return grid;
};


// Test Cases
console.log(shiftGrid([[1,2,3],[4,5,6],[7,8,9]], 1));
console.log(shiftGrid([[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], 4));
console.log(shiftGrid([[1,2,3],[4,5,6],[7,8,9]], 9));