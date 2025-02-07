package com.vnaidu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveObstacles extends Base {

// Define a new data structure class
     class Node {
         public int x;
         public int y;
         public int dist;
         Node(int x, int y, int dist) {
             this.x = x;
             this.y = y;
             this.dist = dist;
         }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", dist=" + dist +
                '}';
    }
}
     public int shortestDistance(int numRows, int numColumns, List<List<Integer>> lot) {
         // set up visited array and queue.
          boolean[][] visited = new boolean[numColumns][numRows];
          Queue<Node> q = new LinkedList<>();
          q.add(new Node(0,0,0));
          visited[0][0]=true;

          while (!q.isEmpty()) {

              Node top = q.poll();
              if(top != null) {
                  visited[top.x][top.y] = true;
                  if (lot.get(top.x).get(top.y) == 9) {
                      return top.dist;
                  }
                  if (top.x + 1 < lot.size() && lot.get(top.x + 1).get(top.y) != 0 && !visited[top.x + 1][top.y]) {
                      q.add(new Node(top.x + 1, top.y, top.dist + 1));
                  }
                  if (top.x - 1 > 0 && lot.get(top.x - 1).get(top.y) != 0 && !visited[top.x - 1][top.y]) {
                      q.add(new Node(top.x - 1, top.y, top.dist + 1));
                  }
                  if (top.y - 1 > 0 && lot.get(top.x).get(top.y - 1) != 0 && !visited[top.x][top.y - 1]) {
                      q.add(new Node(top.x, top.y - 1, top.dist + 1));
                  }
                  if (top.y + 1 < lot.get(0).size() && lot.get(top.x).get(top.y + 1) != 0 && !visited[top.x][top.y + 1]) {
                      q.add(new Node(top.x, top.y + 1, top.dist + 1));
                  }
              }
              logger.info(q.toString());
          }
          return -1;
     }
    public static void main(String[] args) {
        RemoveObstacles obstacles = new RemoveObstacles();
        List<List<Integer>> lot = new ArrayList<>();
        lot.add(Arrays.asList(1,1,1,1));
        lot.add(Arrays.asList(0,1,1,1));
        lot.add(Arrays.asList(0,1,0,1));
        lot.add(Arrays.asList(1,1,9,1));
        lot.add(Arrays.asList(0,0,1,1));

        int minTime = obstacles.shortestDistance(5,4,lot);

        logger.info(minTime + "");
    }
}
