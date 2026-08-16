function nearestDrone(drones: number[][], target: number[]): number {
    
    let index = Infinity; 
    let current = Infinity;

    for (let i = 0; i < drones.length; i++){
        const [x, y, range] = drones[i];
        const distance = Math.abs(x - target[0]) + Math.abs(y - target[1]);

        if (distance < current && distance <= range){
            current = distance;
            index = i;
        }

        
    }

    return index < Infinity ? index : -1;
    
};

console.log(nearestDrone([[0,0,8],[2,2,9]], [3,4])); // Output: 1
console.log(nearestDrone([[2,1,5],[4,4,5],[6,6,8]], [5,5])); // Output: 1
console.log(nearestDrone([[4,4,5]], [8,6])); // Output: -1