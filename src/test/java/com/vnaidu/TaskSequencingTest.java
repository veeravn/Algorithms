package com.vnaidu;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TaskSequencingTest {

    @Test
    public void testTaskSequence() {

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


        List<String> result = TaskSequencing.taskSequence(tasks, deps);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("T3", "T2", "Tm", "T1", "Tn"));

        for(int i = 0; i < result.size(); i++) {
            boolean order = result.get(i).equals(expected.get(i));
            assertTrue(order);
        }
    }

}