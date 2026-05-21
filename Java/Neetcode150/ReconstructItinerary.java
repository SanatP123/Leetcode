import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary {
    
    public List<String> findItinerary(List<List<String>> tickets) {

        int n = tickets.size();

        // Departure airport -> lexical order arrivals
        HashMap<String, PriorityQueue<String>> ticketMap = new HashMap<>();

        List<String> ans = new ArrayList<>();

        for (List<String> airport: tickets){
            ticketMap.putIfAbsent(airport.get(0), new PriorityQueue<>());
            ticketMap.get(airport.get(0)).add(airport.get(1));
        }

        dfs("JFK", ticketMap, ans);

        // Route is built backwards
        Collections.reverse(ans);
        return ans;
        
    }

    public void dfs(String arrival, HashMap<String, PriorityQueue<String>> ticketMap, List<String> ans){
        PriorityQueue<String> destinations = ticketMap.get(arrival);

         // Use all outgoing tickets
        while (destinations != null && !destinations.isEmpty()){
            dfs(destinations.poll(),ticketMap, ans);
        }

         // Add airport after exploring neighbors
        ans.add(arrival);

    }

    public static void main(String[] args) {
        ReconstructItinerary sol = new ReconstructItinerary();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("MUC","LHR"));
        tickets.add(List.of("JFK","MUC"));
        tickets.add(List.of("SFO","SJC"));
        tickets.add(List.of("LHR","SFO"));

        List<String> ans = sol.findItinerary(tickets);
        for (String s : ans){
            System.out.print(s + " ");
        }
        System.out.println();

        ReconstructItinerary sol2 = new ReconstructItinerary();
        List<List<String>> tickets2 = new ArrayList<>();
        tickets2.add(List.of("JFK","SFO"));
        tickets2.add(List.of("JFK","ATL"));
        tickets2.add(List.of("SFO","ATL"));
        tickets2.add(List.of("ATL","JFK"));
        tickets2.add(List.of("ATL","SFO"));

        List<String> ans2 = sol2.findItinerary(tickets2);
        for (String s : ans2){
            System.out.print(s + " ");
        }
        System.out.println();
    }
    
}
