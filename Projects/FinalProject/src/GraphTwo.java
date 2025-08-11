
import java.util.*;

public class GraphTwo {

    //ijaad liste mojaverati
    int n;
    List<List<Integer>> graph;

    //Constructor 
    public GraphTwo(int n) {
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

    //moshakhas kardane node ba bishtarin farzand
    public int bigNode(List<List<Integer>> graph, boolean visited[]) {
        int max = 0;
        int num1 = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && (graph.get(i).size() > max)) {
                max = graph.get(i).size();
                num1 = i;
            }
        }

        visited[num1] = true;
        return num1;
    }

    public ArrayList Clique() {

        //age graph 3 gere nadaashte baashe ke hichi
        if (graph.size() < 3) {
            System.out.println("No Clique");
            System.exit(1);
        }

        boolean[] visited = new boolean[n];
        ArrayList<Integer> path = new ArrayList<>(n);

        //3 ta az bozorg tarin node haaro entekhaab mikonim va zir geraph kaamelo tashkil midim 
        for (int i = 0; i < 3; i++) {
            int big = bigNode(graph, visited);
            path.add(big);
        }

        //loop mizanim ta zamaani ke hame node ha bar'resi beshan 
        while (true) {

            //sharte paayaan
            boolean checkEnd = true;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                } else {
                    checkEnd = false;
                }
            }
            
            if (checkEnd) {
                break;
            }
            
            int big = bigNode(graph, visited);
            boolean bigVerfi = true;
            HashSet<Integer> children = new HashSet<>(graph.get(big));

            //check mikone be hameye gere haaye ghabli raah daare ya na (baraaye kaamel shodan)
            if (!children.containsAll(path)) {
                bigVerfi = false;
            }

            if (bigVerfi) {
                path.add(big);
            }
        }

        return path;
    }

}
