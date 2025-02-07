package com.vnaidu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrisonCell extends Base {

    public List<Integer> cellCompete(int[] states, int days) {

        if(states==null || days==0 || states.length<3) {

            return Arrays.stream(states).boxed().collect(Collectors.toList());
        }
        Map<Integer, int[]> map = new HashMap<>();
        int j=1;
        int[] temp;
        int[] temp1=null;
        boolean flag  = true;
        int length = states.length;
        while(flag){
            temp = new int[length];
            if ((states[1] == 0)) {
                temp[0] = 0;
            } else {
                temp[0] = 1;
            }
            if ((states[length - 2] == 0)) {
                temp[length-1] = 0;
            } else {
                temp[length-1] = 1;
            }
            for(int i=1; i<length-1; i++) {

                if ((states[i - 1] == 0 && states[i + 1] == 0) || (states[i - 1] == 1 && states[i + 1] == 1)) {

                    temp[i] = 0;
                } else {
                    temp[i] = 1;
                }
            }
            if(j==1) temp1 = temp;
            else if(Arrays.equals(temp, temp1))flag = false;
            if(flag){
                map.put(j , temp);
                if(days==j) {
                    return Arrays.stream(map.get(days)).boxed().collect(Collectors.toList());
                }
                //if days is smaller than cyyle
                j++;
            }
            states = temp.clone();
        }
        //logger.info(map.size());
        if(map.size()==1) {
            return Arrays.stream(map.get(1)).boxed().collect(Collectors.toList());//if only 1 solution and x%1 is X
        }
        else if(days%map.size()==0) {
            return Arrays.stream(map.get(map.size())).boxed().collect(Collectors.toList());//if you dont have 0 modulo case in map
        }

        return days < map.size() ?
                Arrays.stream(map.get(days)).boxed().collect(Collectors.toList()):
                Arrays.stream(map.get(days%map.size())).boxed().collect(Collectors.toList());
        
    }

    public static void main(String[] args) {

        PrisonCell states = new PrisonCell();

        logger.info(states.cellCompete(new int[]{1,1,1,0,1,1,1,1}, 2).toString());
    }
}
