// Remove Elements by Type and Color

// You are given three integer arrays types, colors, and groupSize, where types and colors have length n, and groupSize has length m.

// types[i] represents the type of the element at index i.
// colors[i] represents the color of the element at index i.
// groupSize[t] represents the required number of elements in a removable group of type t.
// In one operation, you may remove exactly groupSize[t] consecutive elements if all of them have type t and the same color.

// After each removal, the remaining elements become adjacent again while maintaining their relative order.

// Return true if it is possible to remove all elements using a sequence of valid operations. Otherwise, return false.

// Constraints:

// 1 <= n == types.length == colors.length <= 105
// 1 <= m == groupSize.length <= 105
// 0 <= types[i] <= m - 1
// 1 <= colors[i] <= 105
// 1 <= groupSize[t] <= n


function canRemoveAll(types: number[], colors: number[], groupSize: number[]): boolean {
    const n = types.length;
    const m = groupSize.length;

    // Each frame: a run of consecutive same-(type, color) elements still on the stack
    const st : {t : number, c : number, count : number}[] = [];

    for (let i = 0; i < n; i++){
        const t = types[i];
        const c = colors[i];
        const r = groupSize[t];

        if (r == 1) continue;

        if (st.length > 0){
            const top = st[st.length - 1];

            if (top.t === t && top.c === c){
                // Extend the current count
                top.count++;

                if (top.count === r){
                    st.pop();
                }
                continue;
            }
        }
        st.push({t: t,c: c,count: 1});
    }

    return st.length === 0;
};

console.log(canRemoveAll([0,1,1,0], [5,3,3,5], [2,2])); // Output: true
console.log(canRemoveAll([0,1,1,0], [9,9,9], [3,2])); // Output: false    
console.log(canRemoveAll([2,0,1,2], [7,5,4,7], [3,1,2])); // Output: false