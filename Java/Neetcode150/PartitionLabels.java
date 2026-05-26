import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    
    public List<Integer> partitionLabels(String s) {

        int[] lastIndex = new int[26];

        // Store last occurrence of each character
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            lastIndex[c - 'a'] = i;
        }

        
        List<Integer> res = new ArrayList<>();

        int partitionStart = 0;
        int partitionEnd = 0;

        for (int i = 0; i < s.length(); i++){
            // Extend partition to include this char's last occurrence
            partitionEnd = Math.max(partitionEnd, lastIndex[s.charAt(i) - 'a']);

            // Current partition is complete
            if (i == partitionEnd){
                res.add(i - partitionStart + 1);
                partitionStart = i+1;
            }
        }

        return res;
        
    }

    public static void main(String[] args) {
        PartitionLabels solution = new PartitionLabels();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = solution.partitionLabels(s);
        System.out.println("Partition sizes: " + result);

        PartitionLabels solution2 = new PartitionLabels();
        String s2 = "eccbbbbdec";
        List<Integer> result2 = solution2.partitionLabels(s2);
        System.out.println("Partition sizes: " + result2);

        PartitionLabels solution3 = new PartitionLabels();
        String s3 = "caedbdedda";
        List<Integer> result3 = solution3.partitionLabels(s3);
        System.out.println("Partition sizes: " + result3);
    }



    
}
