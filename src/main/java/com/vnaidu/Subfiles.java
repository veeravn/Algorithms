package com.vnaidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Subfiles extends Base {

    int total;
    public Subfiles() {
        total = 0;
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumTime(int numOfSubFiles, List<Integer> files)
    {
        if(numOfSubFiles < 2) {
            return 0;
        }
        files.sort(Comparator.naturalOrder());

        int num1 = files.get(0);
        int num2 = files.get(1);
        int sum = num1+num2;

        List<Integer> newList = new ArrayList<>();
        newList.add(sum);
        for (int i = 2; i < files.size(); i++) {
            newList.add(files.get(i));
        }
        //minimumTime(newList.size(), newList);
        return minimumTime(newList.size(), newList)+sum;

    }

    int combine(int num1, int num2) {
        return num1+num2;
    }
    public static void main(String[] args) {
        Subfiles subfiles = new Subfiles();
        int minTime = subfiles.minimumTime(4, Arrays.asList(4, 8, 6, 12));

        logger.info(minTime + "");
    }
    // METHOD SIGNATURE ENDS

}
