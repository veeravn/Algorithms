package com.vnaidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intervals extends Base {

    public static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> answer = new ArrayList<>();

        if(intervals.length != 0){
            Arrays.sort(intervals, (int[]a, int[]b) -> a[0] - b[0]);

            int start = intervals[0][0];
            int end = intervals[0][1];
            for(int[] i: intervals){
                if(i[0] <= end){
                    end = Math.max(end, i[1]);
                } else {
                    answer.add(new int[]{start,end});
                    start = i[0];
                    end = i[1];
                }
            }
            answer.add(new int[]{start,end});

        }

        return answer.toArray(new int[0][]);
    }

    public  static int[][] insert(int[][] interval, int[] newInterval) {
        int i=0;
        int n=interval.length;
        List<int[]> res = new ArrayList<>();

        while(i<n && newInterval[0]>interval[i][1]){
            res.add(interval[i]);
            i++;
        }

        while(i<n && newInterval[1]>=interval[i][0]){
            newInterval[0] = Math.min(newInterval[0], interval[i][0]);
            newInterval[1] = Math.max(newInterval[1], interval[i][1]);
            i++;
        }
        res.add(newInterval);

        while(i<n){
            res.add(interval[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] result = mergeIntervals(new int[][] {{1,3},{2,6},{8,10},{15,18}});
        logger.info(matrixString(result));
    }
}
