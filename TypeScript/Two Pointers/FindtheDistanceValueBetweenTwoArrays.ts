// Find the Distance Value Between Two Arrays
// Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.

// The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.


function FindTheDistanceValue(arr1: number[], arr2: number[], d: number): number {
    let count : number = 0;

    for (let i =0; i < arr1.length; i++){
        let isValid : boolean = true;
        for (let j = 0; j< arr2.length; j++){
            if (Math.abs(arr1[i] - arr2[j]) <= d){
                isValid = false;
                break;
            }
        }

        if (isValid) count++;
    }

    return count;
};

console.log(FindTheDistanceValue([4,5,8], [10,9,1,8], 2)); // Output: 2
console.log(FindTheDistanceValue([1,4,2,3], [-4,-3,6,10,20,30], 3)); // Output: 2
console.log(FindTheDistanceValue([2,1,100,3], [-5,-2,10,-3,7], 6)); // Output: 1