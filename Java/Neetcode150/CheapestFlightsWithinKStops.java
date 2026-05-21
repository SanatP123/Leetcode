import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        for (int[] flight : flights){
            map.putIfAbsent(flight[0], new ArrayList<>());
            map.get(flight[0]).add(new int[] {flight[1],flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        // Queue storing {node, distance} pairs
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        int stops = 0;

        while (stops <= k && !q.isEmpty()){
            int sz = q.size();

            // Iterate on current level.
            while (sz > 0){
                int[] temp = q.poll();
                int node = temp[0];
                int distance = temp[1];

                sz--;

                if (!map.containsKey(node)){
                    continue;
                }

                // Loop over neighbors of popped node.
                for (int[] e : map.get(node)){
                    int next = e[0];
                    int price = e[1];

                    if (price + distance >= dist[next]){
                        continue;
                    }
                    dist[next] = price + distance;
                    q.offer(new int[] {next, dist[next]});
                }
            }
            stops++;

        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops sol = new CheapestFlightsWithinKStops();
        int n = 3;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        int ans = sol.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(ans);

        CheapestFlightsWithinKStops sol2 = new CheapestFlightsWithinKStops();
        int n2 = 3;
        int[][] flights2 = {{0,1,100},{1,2,100},{0,2,500}};
        int src2 = 0;
        int dst2 = 2;
        int k2 = 0;
        int ans2 = sol2.findCheapestPrice(n2, flights2, src2, dst2, k2);
        System.out.println(ans2);

        CheapestFlightsWithinKStops sol3 = new CheapestFlightsWithinKStops();
        int n3 = 4;
        int[][] flights3 = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src3 = 0;
        int dst3 = 3;
        int k3 = 1;
        int ans3 = sol3.findCheapestPrice(n3, flights3, src3, dst3, k3);
        System.out.println(ans3);
    }
    
}
