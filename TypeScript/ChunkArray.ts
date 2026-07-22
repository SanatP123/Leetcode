type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | Array<JSONValue>;

function chunk(arr: Obj[], size: number): Obj[][] {
    var curr = size;
    let currArr : Obj[] = [];
    let res : Obj[][] = [];
    for (let i = 0; i < arr.length; i++){
        if (curr == 0){
            curr = size;
            res.push(currArr);
            currArr = [];
            currArr.push(arr[i]);
            curr--;
        }
        else{
            curr--;
            currArr.push(arr[i]);
        }
    }
    if (currArr.length > 0){
        res.push(currArr);
    }
    return res;
};



console.log(chunk([1,2,3,4,5], 1)); // Output: [[1],[2],[3],[4],[5]]
console.log(chunk([1,9,6,3,2], 3)); // Output: [[1,9,6],[3,2]]
console.log(chunk([8,5,3,2,6], 6)); // Output: [[8,5,3,2,6]]
