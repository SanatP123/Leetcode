function rearrangeString(s: string, x: string, y: string): string {
    if (x < y){
        return [...s].sort((a,b) => b.localeCompare(a)).join("");
    }
    else{
        return[...s].sort((a,b) => a.localeCompare(b)).join("");
    }

    
};

console.log(rearrangeString("aabc", "a", "c")); // Output: "cbaa"
console.log(rearrangeString("dcab", "d", "b")); // Output: "abcd"
console.log(rearrangeString("axe", "o", "x")); // Output: "xea"