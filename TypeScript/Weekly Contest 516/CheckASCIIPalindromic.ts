function isPalindromic(s: string): boolean {
    let result = "";

    for (let i = 0; i < s.length; i++){
        let ascii = s.charCodeAt(i);
        result += ascii.toString(2).padStart(8,'0');
    }
    
    return checkPalindrome(result);
};

function checkPalindrome(str : string) : boolean{
    let left = 0, right = str.length - 1;

    while (left < right){
        if (str[left] != str[right]){
            return false;
        }
        left++;
        right--;
    }
    return true;
}


console.log(isPalindromic("ff")); // Output: true
console.log(isPalindromic("leet")); // Output: false