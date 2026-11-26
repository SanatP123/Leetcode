// Stone Removal Game

// Alice and Bob are playing a game where they take turns removing stones from a pile, with Alice going first.

// Alice starts by removing exactly 10 stones on her first turn.
// For each subsequent turn, each player removes exactly 1 fewer stone than the previous opponent.
// The player who cannot make a move loses the game.

// Given a positive integer n, return true if Alice wins the game and false otherwise.

function canAliceWin(n: number): boolean {
    let removal = 10;
    let turn = false;
    while (n > 0){
        if (n < removal){
            return turn;
        }
        n -= removal;
        removal -= 1;
        turn = !turn;
    }

    return turn;
    
};

console.log(canAliceWin(12)); // true
console.log(canAliceWin(1)); // false  
console.log(canAliceWin(19)); // false