function countConsistent(nums: number[]): number {
    const n = nums.length;
    const min = Math.min(...nums)
    let count = 0;

    for (let i = 0; i < n; i++){
        for (let j = i; j < n; j++){
            let value = getBitwiseAnd(nums.slice(i, j+1));

            if (value){
                count += 1;
            }

        }
    }

    return count;
    
};

function getBitwiseAnd (arr : number[]) : boolean{

    let num = arr[0];
    let min = Math.min(...arr);

    for (let i = 1; i < arr.length; i++){
        num = arr[i] & num;
    }

    return num === min;

}

console.log(countConsistent([5,3,1,2])); // Output: 6
console.log(countConsistent([1,1,1])); // Output: 6
console.log(countConsistent([0])); // Output: 1