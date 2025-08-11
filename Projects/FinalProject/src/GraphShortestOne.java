
import java.util.*;

public class GraphShortestOne {

    int n;
    //ijaad liste mojaaverati
    List<List<ChildNodeOne>> graph;

    //Constructor 
    public GraphShortestOne(int n) {
        this.n = n;
        graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
    }

    void addChild(int begin, int end, int childLength) {
        ChildNodeOne ch1 = new ChildNodeOne(begin, childLength);
        ChildNodeOne ch2 = new ChildNodeOne(end, childLength);
        graph.get(begin).add(ch2);
        graph.get(end).add(ch1);
    }

    public int dijkstra(int inputNode, int outNode) {

        //faasele hame gere ha az gereye mab'da
        int[] distance = new int[graph.size()];

        //gere haayi ke beshon miresim true mishan 
        boolean[] nodeVisited = new boolean[graph.size()];

        //gere haayi ke beshon miresim mizaarim into bad az moshakhas shodan kotaahtarin masir hazf mishan 
        Set<Integer> queue = new HashSet<>();

        for (int i = 0; i < graph.size(); i++) {
            nodeVisited[i] = false;
            distance[i] = 9999999;

        }

        distance[inputNode] = 0;
        int vertex = inputNode;

        //####### loop baraaye hame gere ha #######
        while (true) {

            nodeVisited[vertex] = true;

            //******loop baraaye bacheh haaye on gere****
            List<ChildNodeOne> children = graph.get(vertex);
            for (int i = 0; i < children.size(); i++) {

                ChildNodeOne child = children.get(i);

                //age ghablan dide shode mire badi
                if (nodeVisited[child.childNumber]) {
                    continue;
                }

                queue.add(child.childNumber);

                //hesaab kardan masaafe jadid ta gere bacheh
                int newDistance = distance[vertex] + child.childLength;

                //age masaafate jadid kochiktar az masaafate ghabli ke baraaye gere sabt shode bod jaaygozin mishe 
                if (newDistance < distance[child.childNumber]) {
                    distance[child.childNumber] = newDistance;
                }

            }//********

            //hazf gere bad az bar'resi bache haash
            queue.remove(vertex);

            // zamaani ke be hame gere haaye made nazar reside baashimo khaarej karde baashim (sharte khaateme) 
            if (queue.isEmpty()) {
                break;
            }

            //bar'resi gere badi ke baayad vaared lop beshe 
            int min = 9999999;
            int num1 = 0;

            for (int i : queue) {
                if (distance[i] < min) {
                    min = distance[i];
                    num1 = i;
                }
            }

            vertex = num1;

        }//##############

        //baazgashte fasleye node mabda ta maghsad
        return distance[outNode];
    }

}
