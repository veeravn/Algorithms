package com.vnaidu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DPQ extends Base {

    private int[] dist;
    private Set<Integer> settled;
    private PriorityQueue<GraphNode> pq;
    private int V; // Number of vertices
    List<List<GraphNode> > adj;

    public DPQ(int V)
    {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<>();
        pq = new PriorityQueue<>(V, new GraphNode());
    }

    // Function for Dijkstra's Algorithm
    public void dijkstra(List<List<GraphNode> > adj, int src)
    {
        this.adj = adj;

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // Add source node to the priority queue
        pq.add(new GraphNode(src, 0));

        // Distance to the source is 0
        dist[src] = 0;
        while (settled.size() != V) {

            // remove the minimum distance node
            // from the priority queue
            int u = pq.remove().node;

            // adding the node whose distance is
            // finalized
            settled.add(u);

            e_Neighbours(u);
        }
    }

    // Function to process all the neighbours
    // of the passed node
    private void e_Neighbours(int u)
    {
        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        for (int i = 0; i < adj.get(u).size(); i++) {
            GraphNode v = adj.get(u).get(i);

            // If current node hasn't already been processed
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                // Add the current node to the queue
                pq.add(new GraphNode(v.node, dist[v.node]));
            }
        }
    }

    // Driver code
    public static void main(String[] arg)
    {
        int V = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges
        List<List<GraphNode> > adj = new ArrayList<>();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<GraphNode> item = new ArrayList<>();
            adj.add(item);
        }

        // Inputs for the DPQ graph
        adj.get(0).add(new GraphNode(1, 9));
        adj.get(0).add(new GraphNode(2, 6));
        adj.get(0).add(new GraphNode(3, 5));
        adj.get(0).add(new GraphNode(4, 3));

        adj.get(2).add(new GraphNode(1, 2));
        adj.get(2).add(new GraphNode(3, 4));

        // Calculate the single source shortest path
        DPQ dpq = new DPQ(V);
        dpq.dijkstra(adj, source);

        // Print the shortest path to all the nodes
        // from the source node
        logger.info("The shorted path from node :");
        for (int i = 0; i < dpq.dist.length; i++)
            logger.info(source + " to " + i + " is "
                    + dpq.dist[i]);
    }
}

// Class to represent a node in the graph
class GraphNode implements Comparator<GraphNode> {
    public int node;
    public int cost;

    public GraphNode()
    {
    }

    public GraphNode(int node, int cost)
    {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(GraphNode graphNode1, GraphNode graphNode2)
    {
        return Integer.compare(graphNode1.cost, graphNode2.cost);
    }
}

