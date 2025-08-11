
import java.util.*;

public class GraphUnDirectedThree {

    int n;
    //ijaad liste mojaaverati
    List<List<Integer>> graph;

    //Constructor 
    public GraphUnDirectedThree(int n) {
        this.n = n;
        graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
    }

    void addChild(int begin, int end) {
        graph.get(begin).add(end);
        graph.get(end).add(begin);
    }

    //daryaft node baraaye peymaayeshe bache haaye node
    boolean beginNode() {
        
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        for (int parent = 0; parent < n; parent++) {
            if (!visited[parent]) {
                if (cycle(parent, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    //peymaayesh bache haaye node be sorate baazgashti 
    boolean cycle(int current, boolean visited[], int parent) {
        visited[current] = true;

        //baraaye loop zadan bache haaye gere
        Iterator<Integer> children = graph.get(current).iterator();
        int num1;
        while (children.hasNext()) {
            num1 = children.next();

            if (!visited[num1]) {
                if (cycle(num1, visited, current)) {
                    return true;
                }
            } else if (num1 != parent) {
                return true;
            }
        }
        return false;
    }
}
