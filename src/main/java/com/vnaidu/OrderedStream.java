package com.vnaidu;

// File: OrderedStream.java
import java.util.ArrayList;
import java.util.List;

public class OrderedStream extends Base {
    private final String[] stream;
    private int ptr;

    public OrderedStream(int n) {
        stream = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;
        List<String> result = new ArrayList<>();
        while (ptr < stream.length && stream[ptr] != null) {
            result.add(stream[ptr++]);
        }
        return result;
    }
}
