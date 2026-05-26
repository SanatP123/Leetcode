

import java.util.TreeMap;

public class HandsofStraights {
    
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

         // Count each card value
        for (int i = 0; i < n; i++){
            treeMap.put(hand[i], treeMap.getOrDefault(hand[i],0) + 1);
        }

        while (!treeMap.isEmpty()){
            // Smallest card must start the next group
            int first = treeMap.firstKey();
            
            // Try to build a consecutive group
            for (int i = first; i < first + groupSize; i++){
                if (!treeMap.containsKey(i)){
                    return false;
                }
                treeMap.put(i, treeMap.get(i) - 1);
                
                // Remove card if fully used
                if (treeMap.get(i) == 0){
                    treeMap.remove(i);
                }
            }
            
        }

        return true;
        
    }

    public static void main(String[] args) {
        HandsofStraights solution = new HandsofStraights();
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        boolean result = solution.isNStraightHand(hand, groupSize);
        System.out.println("Can rearrange into groups: " + result);

        HandsofStraights solution2 = new HandsofStraights();
        int[] hand2 = {1,2,3,4,5};
        int groupSize2 = 4;
        boolean result2 = solution2.isNStraightHand(hand2, groupSize2);
        System.out.println("Can rearrange into groups: " + result2);

        HandsofStraights solution3 = new HandsofStraights();
        int[] hand3 = {1,2,3,4};
        int groupSize3 = 2;
        boolean result3 = solution3.isNStraightHand(hand3, groupSize3);
        System.out.println("Can rearrange into groups: " + result3);
    }
}

