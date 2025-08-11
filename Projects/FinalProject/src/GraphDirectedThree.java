
import java.util.*;

public class GraphDirectedThree {

    int n;
    //ijaad liste mojaverati
    List<List<Integer>> graph;

    //Constructor 
    public GraphDirectedThree(int n) {
        this.n = n;
        graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
    }

    void addChild(int begin, int end) {
        graph.get(begin).add(end);
    }

    //daryaft node baraaye peymaayeshe bache haaye node
    boolean beginNode() {

        //visiteed baraaye khode node va stack baraaye bache haaye va khode node 
        boolean[] visited = new boolean[n];
        boolean[] stackVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (cycle(i, visited, stackVisited)) {
                return true;
            }
        }
        return false;
    }

    //peymaayesh bache haaye node be sorate baazgashti 
    boolean cycle(int i, boolean[] visited, boolean[] stackVisited) {

        if (stackVisited[i]) {
            return true;
        }

        visited[i] = true;
        stackVisited[i] = true;

        List<Integer> children = graph.get(i);
        for (int num1 : children) {
            if (cycle(num1, visited, stackVisited)) {
                return true;
            }
        }

        stackVisited[i] = false;

        return false;

    }

}
