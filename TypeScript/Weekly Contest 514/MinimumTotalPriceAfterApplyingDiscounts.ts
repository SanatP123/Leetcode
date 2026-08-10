// Minimum Total Price After Applying Discounts :

// You are given two integer arrays prices and discounts.
// The value prices[i] represents the price of the ith item, and discounts[j] represents a discount percentage.
// You may apply discounts subject to the following rules:

// Each discount can be applied to at most one item.
// Each item can receive at most one discount.
// An item may also receive no discount.
// If a discount of d percent is applied to an item with price p, its final price becomes (p * (100 - d)) / 100. The final price is not rounded.

// Return the minimum possible sum of final prices after assigning discounts optimally. Answers within 10-5 of the actual answer will be accepted.

function minPrice(prices: number[], discounts: number[]): number {
    let minSum = 0;
    prices.sort((a,b) => b - a);
    discounts.sort((a,b) => b - a);

    const m = prices.length;
    const n = discounts.length;
    let i = 0;
    let j = 0;

    while (i < m  && j < n){
        let new_price = (prices[i] * (100 - discounts[i]))/ 100;
        minSum += new_price;
        i++;
        j++;
    }

    while (i < m){
        minSum += prices[i];
        i++;
    }

    return minSum;
};

console.log(minPrice([10,30,21], [50,60])); // Output: 32.5000
console.log(minPrice([100,70], [10,40,50])); // Output: 92.0000
console.log(minPrice([7, 3, 9], [100,100])); // Output: 3.0000