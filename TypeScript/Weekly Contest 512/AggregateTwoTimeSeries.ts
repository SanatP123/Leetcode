// Aggregate Two Time Series

// You are given two 2D integer arrays series1 and series2.

// Each element in both series is of the form [timestamp, value], where:

// timestamp is an integer representing the time.
// value is an integer representing the value at that timestamp.
// Each array is sorted in strictly increasing order of timestamp.

// For any timestamp not present in a series, its value is taken from the next available timestamp in the same series if one exists. Otherwise, its value is considered 0.

// The aggregated series is formed by summing the corresponding values from both series at every timestamp that appears in either series.

// Return the aggregated series as a 2D integer array of [timestamp, summedValue] pairs, sorted in strictly increasing order of timestamp.

 
function aggregateTimeSeries(series1: number[][], series2: number[][]): number[][] {
    let aggregatedSeries : number[][] = [];
    let left = 0, right = 0;
    let m = series1.length;
    let n = series2.length; 

    while (left < m && right < n){
        if (series1[left][0] === series2[right][0]){
            aggregatedSeries.push([series1[left][0], series1[left][1] + series2[right][1]]);
            left++, right++;
        }
        else if (series1[left][0] < series2[right][0]){
            aggregatedSeries.push([series1[left][0], series1[left][1] + series2[right][1]]);
            left++;
        }
        else if (series1[left][0] > series2[right][0]){
            aggregatedSeries.push([series2[right][0], series1[left][1] + series2[right][1]]);
            right++;
        }

    }

    while (left < m) {aggregatedSeries.push([series1[left][0], series1[left][1]]); left++}

    while (right < n) {aggregatedSeries.push([series2[right][0], series2[right][1]]); right++};

    return aggregatedSeries;
    
};


console.log(aggregateTimeSeries([[1,3],[4,1]], [[2,2],[5,2]])); // Output: [[1, 5], [2, 3], [4, 3], [5, 2]]

console.log(aggregateTimeSeries([[1,5],[3,1]], [[2,2]])); // Output: [[1,7],[2,3],[3,1]]

console.log(aggregateTimeSeries([[1,5]], [[1000000000,2]])); // Output: [[1, 7], [1000000000,2 ]]