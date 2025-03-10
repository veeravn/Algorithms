package com.vnaidu;

import java.util.HashMap;

public class ReplaceElementsInArray extends Base {

    public int[] arrayChange(int[] A, int[][] op) {
        HashMap<Integer,Integer> store= new HashMap<>();
        for(int i=0;i<A.length;i++) store.put(A[i],i);
        for(int[] i:op){
            A[store.get(i[0])]= i[1];              //replace value to its index
            store.put(i[1],store.get(i[0]));       //update new value with its index
        }
        return A;
    }
}
