package com.vnaidu;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrailerSchedulingTest {

    @Test
    public void trailerSchedule() {

        List<TrailerScheduling.Trailer> trailerList = new ArrayList<>();
        TrailerScheduling.Trailer t = new TrailerScheduling.Trailer();
        t.setId("A");
        t.setDoorNum(1);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,8,0));
        t.setUnloadTime(12);
        trailerList.add(t);
        t = new TrailerScheduling.Trailer();
        t.setId("B");
        t.setDoorNum(2);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,8,10));
        t.setUnloadTime(20);
        trailerList.add(t);
        t = new TrailerScheduling.Trailer();
        t.setId("C");
        t.setDoorNum(3);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,8,10));
        t.setUnloadTime(25);
        trailerList.add(t);
        t = new TrailerScheduling.Trailer();
        t.setId("D");
        t.setDoorNum(4);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,8,15));
        t.setUnloadTime(20);
        trailerList.add(t);
        t = new TrailerScheduling.Trailer();
        t.setId("E");
        t.setDoorNum(5);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,8,15));
        t.setUnloadTime(30);
        trailerList.add(t);
        t = new TrailerScheduling.Trailer();
        t.setId("F");
        t.setDoorNum(1);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,8,36));
        t.setUnloadTime(20);
        trailerList.add(t);
t = new TrailerScheduling.Trailer();
        t.setId("G");
        t.setDoorNum(2);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,8,32));
        t.setUnloadTime(15);
        trailerList.add(t);
t = new TrailerScheduling.Trailer();
        t.setId("H");
        t.setDoorNum(3);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,8,36));
        t.setUnloadTime(20);
        trailerList.add(t);
t = new TrailerScheduling.Trailer();
        t.setId("I");
        t.setDoorNum(4);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,8,38));
        t.setUnloadTime(15);
        trailerList.add(t);
t = new TrailerScheduling.Trailer();
        t.setId("J");
        t.setDoorNum(5);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,8,50));
        t.setUnloadTime(20);
        trailerList.add(t);
t = new TrailerScheduling.Trailer();
        t.setId("K");
        t.setDoorNum(2);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,8,57));
        t.setUnloadTime(30);
        trailerList.add(t);
t = new TrailerScheduling.Trailer();
        t.setId("L");
        t.setDoorNum(1);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,8,59));
        t.setUnloadTime(20);
        trailerList.add(t);
t = new TrailerScheduling.Trailer();
        t.setId("M");
        t.setDoorNum(3);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,9,0));
        t.setUnloadTime(10);
        trailerList.add(t);
t = new TrailerScheduling.Trailer();
        t.setId("N");
        t.setDoorNum(4);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,9,0));
        t.setUnloadTime(20);
        trailerList.add(t);
t = new TrailerScheduling.Trailer();
        t.setId("O");
        t.setDoorNum(5);
        t.setArrivalDate(LocalDateTime.of(2021, Month.JANUARY,5,9,12));
        t.setUnloadTime(30);
        trailerList.add(t);
        Assert.assertEquals("2021-01-05T09:08-06:00[America/Chicago]", TrailerScheduling.getBusiestTime(trailerList));
        System.out.println(TrailerScheduling.getBusiestTime(trailerList));
    }

}