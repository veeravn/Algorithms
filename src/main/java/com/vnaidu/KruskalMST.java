package com.vnaidu;

// Java program for Kruskal's algorithm to find Minimum
// Spanning Tree of a given connected, undirected and
// weighted graph
import java.util.Arrays;

public class KruskalMST
{
    // A class to represent a graph edge
    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;

        // Comparator function used for sorting edges
        // based on their weight
        @Override
        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }
    }

    // A class to represent a subset for union-find
    class Subset
    {
        int parent, rank;
    }

    private int v, e; // v-> no. of vertices & e->no.of edges
    private Edge[] edge; // collection of all edges

    // Creates a graph with v vertices and e edges
    KruskalMST(int v, int e)
    {
        this.v = v;
        this.e = e;
        edge = new Edge[this.e];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }

    // A utility function to find set of an element i
    // (uses path compression technique)
    private int find(Subset[] subsets, int i)
    {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y
    // (uses union by rank)
    private void union(Subset[] subsets, int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree
        // (union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

            // If ranks are same, then make one as root and increment
            // its rank by one
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // The main function to construct MST using Kruskal's algorithm
    private void kruskalMST()
    {
        Edge[] result = new Edge[v]; // Tnis will store the resultant MST
        int e = 0; // An index variable, used for result[]
        int i; // An index variable, used for sorted edges
        for (i=0; i< v; ++i)
            result[i] = new Edge();

        // Step 1: Sort all the edges in non-decreasing order of their
        // weight. If we are not allowed to change the given graph, we
        // can create a copy of array of edges
        Arrays.sort(edge);

        // Allocate memory for creating v ssubsets
        Subset[] subsets = new Subset[v];
        for(i=0; i< v; ++i)
            subsets[i]=new Subset();

        // Create v subsets with single elements
        for (int v = 0; v < this.v; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0; // Index used to pick next edge

        // Number of edges to be taken is equal to v-1
        while (e < v - 1)
        {
            // Step 2: Pick the smallest edge. And increment
            // the index for next iteration
            Edge nextEdge;
            nextEdge = edge[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            // If including this edge does't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y)
            {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
            // Else discard the nextEdge
        }

        // print the contents of result[] to display
        // the built MST
        System.out.println("Following are the edges in " +
                "the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src+" -- " +
                    result[i].dest+" == " + result[i].weight);
    }

    // Driver Program
    public static void main (String[] args)
    {

		/* Let us create following weighted graph
				10
			0--------1
			| \	 |
		6| 5\ |15
			|	 \ |
			2--------3
				4	 */
        int v = 4; // Number of vertices in graph
        int e = 5; // Number of edges in graph
        KruskalMST graph = new KruskalMST(v, e);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.kruskalMST();
    }
}

