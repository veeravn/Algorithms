package com.vnaidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TaskSequencing {

    public static List<String> taskSequence(List<String> tasks, Map<String, List<String>> deps) {
        List<String> result = new ArrayList<>();

        do {
            List<String> rem = new ArrayList<>();
            System.out.println("Unprocessed Tasks: "+tasks);
            System.out.println("Processed Tasks: "+result);
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
        return result;
    }

    public static void main(String[] args) {
        List<String> tasks = Arrays.asList("T1", "T3", "Tm", "Tn", "T2","T4", "T5", "T6","T7", "T9", "T10");
        Map<String, List<String>> deps = new HashMap<>();
        deps.put("T1", Arrays.asList("Tm", "T3"));
        deps.put("Tm", Arrays.asList("T2"));
        deps.put("Tn", Arrays.asList("T1"));
        deps.put("T4", Arrays.asList("Tn", "T3"));
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
        List<String> result = taskSequence(tasks, deps);
        System.out.println(result.toString());
    }
}
