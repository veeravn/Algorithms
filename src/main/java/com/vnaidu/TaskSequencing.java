package com.vnaidu;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
public class TaskSequencing {

    static class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(label, vertex.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }
    }

    static class Graph {
        private Map<Vertex, List<Vertex>> adjVertices;

        public Graph(Map<Vertex, List<Vertex>> adjVertices) {
            this.adjVertices = adjVertices;
        }

        public Map<Vertex, List<Vertex>> getAdjVertices() {
            return adjVertices;
        }

        void addVertex(String label) {
            adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
        }
        void addEdge(String label1, String label2) {
            Vertex v1 = new Vertex(label1);
            Vertex v2 = new Vertex(label2);
            adjVertices.get(v1).add(v2);
        }
        List<Vertex> getAdjVertices(String label) {
            return adjVertices.get(new Vertex(label));
        }
        public static void printGraph(Graph graph)  {

            System.out.println("The contents of the graph:");
            for (Map.Entry<Vertex, List<Vertex>> edge : graph.getAdjVertices().entrySet()) {
                System.out.print("Vertex:" + edge.getKey().label);
                edge.getValue().forEach(dep -> System.out.print(" ==> " + dep.label));
                System.out.println();
            }
        }

        void dfsUtil(String label, Set<Vertex> visited) {

            // Recur for all the vertices adjacent to this
            // vertex
            Vertex v = new Vertex(label);
            for (Vertex n : getAdjVertices(label)) {
                if (!visited.contains(v)) {
                    dfsUtil(n.label, visited);
                }
            }
            if(getAdjVertices(label).isEmpty() || visited.containsAll(getAdjVertices(label))) {
                visited.add(v);
            }
        }
    }
    public static List<String> taskSequence(List<String> tasks, Map<String, List<String>> deps) {
        StopWatch graph = new StopWatch();
        List<String> result = new ArrayList<>();
        graph.start();
        do {
            List<String> rem = new ArrayList<>();
            for(String task : tasks) {
                if( deps.get(task) != null) {
                    List<String> strings = deps.get(task);
                    if (!Optional.ofNullable(deps.get(task)).isPresent() || result.containsAll(strings)) {
                        result.add(task);
                    } else {
                        rem.add(task);
                    }
                } else {
                    result.add(task);
                }
            }
            if(rem.size() == tasks.size()) {
                System.err.println("ERROR");
                System.err.println("ERROR: " + rem);
                System.err.println("ERROR: " + tasks);
                System.exit(0);
            }
            tasks = rem;
        }
        while(!tasks.isEmpty());
        graph.stop();
        System.out.println("Time: " + graph.getTime());
        return result;
    }

    public static Set<String> taskSequenceGraph(List<String> tasks, Map<String, List<String>> deps) {
        StopWatch graphsw = new StopWatch();
        graphsw.start();
        LinkedHashSet<Vertex> result = new LinkedHashSet<>();
        LinkedHashSet<String> result2 = new LinkedHashSet<>();
        Graph graph = new Graph(new HashMap<>());
        tasks.forEach(graph::addVertex);
        deps.forEach((key, value) -> value.forEach(dep -> graph.addEdge(key, dep)));
        // Call the recursive helper
        // function to print DFS
        // traversal
        tasks.forEach(task -> {
            if(!result.contains(new Vertex(task))) {
                graph.dfsUtil(task, result);
            }
        });
        for(Vertex res : result) {
            result2.add(res.label);
        }
        graphsw.stop();
        System.out.println("Time: " + graphsw.getTime());
        return result2;
    }
    public static Set<String> taskSequence(String tasks) {
        List<String> depList = Arrays.asList(tasks.split(","));
        Set<String> taskList = new HashSet<>();
        Map<String, List<String>> deps = new HashMap<>();
        depList.forEach(dep -> {
            String[] tnames = dep.split(":");
            taskList.addAll(Arrays.asList(tnames));
            if(deps.containsKey(tnames[0])) {
                deps.get(tnames[0]).add(tnames[1]);
            } else {
                deps.put(tnames[0], new ArrayList<>(Collections.singleton(tnames[1])));
            }
        });

        return taskSequenceGraph(new ArrayList<>(taskList), deps);
    }
    public static void main(String[] args) {
        List<String> tasks = Arrays.asList("T1", "T3", "T8", "T11", "T2","T4", "T5", "T6","T7", "T9", "T10");
        Map<String, List<String>> deps = new HashMap<>();
        deps.put("T1", Arrays.asList("T3", "T8"));
        deps.put("T4", Arrays.asList("T11", "T3"));
        deps.put("T8", Arrays.asList("T2"));
        deps.put("T11", Arrays.asList("T1"));
        deps.put("T5", Arrays.asList("T4"));
        deps.put("T6", Arrays.asList("T4"));
        deps.put("T7", Arrays.asList("T6"));
        deps.put("T9", Arrays.asList("T6"));
        deps.put("T10", Arrays.asList("T9"));


        deps.forEach((key, value) -> {
            for(String dep : value) {
                Optional<List<String>> d = Optional.ofNullable(deps.get(dep));
                boolean present = d.isPresent();
                if(present && d.get().contains(key)) {
                    System.err.println("Cyclical dependency found");
                    System.exit(1);
                }
            }
        });
        Collection<String> result = taskSequenceGraph(tasks, deps);
        System.out.println(result.toString());
        result = taskSequence(tasks, deps);
        System.out.println(result.toString());

        result = taskSequence("t1:t3,t1:t8,t4:t11,t4:t3,t8:t2,t11:t1,t5:t4,t6:t4,t7:t6,t9:t6,t10:t9");
        System.out.println(result.toString());
    }
}
