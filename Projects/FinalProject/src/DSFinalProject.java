
import java.util.*;

public class DSFinalProject {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter Challenge Number : ");
        int num1 = input.nextInt();

        //----------------------------------- First Challenge -----------------------------------
        if (num1 == 1) {
            //graph 
            int n = 5;
            GraphShortestOne graph2 = new GraphShortestOne(n);
            graph2.addChild(0, 1, 1);
            graph2.addChild(1, 2, 2);
            graph2.addChild(2, 3, 4);
            graph2.addChild(3, 4, 3);
            graph2.addChild(4, 1, 15);
            graph2.addChild(4, 2, 1);

            //vorodi 
            System.out.println("inputNode");
            int inputNode = input.nextInt();
            System.out.println("outNode");
            int outNode = input.nextInt();

            //khoroji
            System.out.println(graph2.dijkstra(inputNode, outNode));

        }
        //----------------------------------- Second Challenge -----------------------------------
        if (num1 == 2) {
            int n = 6;
            GraphTwo graph = new GraphTwo(n);
            graph.addChild(0, 1);
            graph.addChild(0, 2);
            graph.addChild(0, 4);
            graph.addChild(1, 2);
            graph.addChild(1, 3);
            graph.addChild(1, 5);
            graph.addChild(2, 3);
            graph.addChild(2, 5);
            graph.addChild(3, 4);
            graph.addChild(3, 5);

            System.out.println("Path = " + graph.Clique());

        }
        //----------------------------------- Third Challenge -----------------------------------
        if (num1 == 3) {

            System.out.print("Challenge Three \nPart : ");
            int num2 = input.nextInt();

            //Part one 
            if (num2 == 1) {
                //graph
                int n = 4;
                GraphDirectedThree graph = new GraphDirectedThree(n);
                graph.addChild(0, 1);
                graph.addChild(0, 2);
                graph.addChild(1, 2);
                graph.addChild(2, 0);
                graph.addChild(2, 3);
                graph.addChild(3, 3);

                //khoroji
                if (graph.beginNode()) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }

            //Part Two
            if (num2 == 2) {
                //graph
                int n = 7;
                GraphUnDirectedThree graph = new GraphUnDirectedThree(n);
                graph.addChild(0, 1);
                graph.addChild(1, 2);
                graph.addChild(2, 3);
                graph.addChild(3, 4);
                graph.addChild(4, 5);
                graph.addChild(5, 6);
                graph.addChild(6, 0);

                //khoroji
                if (graph.beginNode()) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }

            }
        }
    }

}
