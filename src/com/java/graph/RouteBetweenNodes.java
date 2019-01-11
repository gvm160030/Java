package com.java.graph;

import java.util.Iterator;
import java.util.LinkedList;

/*
Given a Directed Graph and two vertices in it, check whether there is a path from the first given vertex to second.
For example, in the following graph, there is a path from vertex 1 to 3.
As another example, there is no path from 3 to 0.

 0  --> 1
^ |     ^
| |    /
| |   /        |-|
| v  ^         v |
--2 ---------> 3-|
 */
public class RouteBetweenNodes {

    static private int v; // No. of vertices
    static private LinkedList adj[]; // Adjacency list

    //Constructor
    RouteBetweenNodes(int vertices) {
        v = vertices;
        adj = new LinkedList[v];
        for (int i = 0; i <v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // Funciton to add edges to the graph
    static void addEdge(int v, int w) {
        adj[v].add(w);
    }

    static boolean isReachable(int s, int d) {
         //Mark all the vertices as not visited(By default set
        // as false)
        boolean visited[] = new boolean[v];

        // Create a queue

        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        // 'i' will be used to get all adjacent vertices of a vertex
        Iterator<Integer> i;
        while (queue.size() != 0) {

            // Dequeue a vertex from queue and print it
            s = queue.poll();

            int n;
            i = adj[s].listIterator();

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            while (i.hasNext())
            {
                n = i.next();

                // If this adjacent node is the destination node,
                // then return true
                if (n==d)
                    return true;

                // Else, continue to do BFS
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        // If BFS is complete without visited d
        return false;
    }

    public static void main(String[] args) {
        RouteBetweenNodes g = new RouteBetweenNodes(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        int u = 1;
        int v = 3;

        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u + " to " + v);
        else
            System.out.println("There is no path from " + u + " to " + v);

        u = 3;
        v = 1;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u + " to " + v);
        else
            System.out.println("There is no path from " + u + " to " + v);
    }
}

