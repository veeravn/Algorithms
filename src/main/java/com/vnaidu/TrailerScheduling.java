package com.vnaidu;


import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Trailers are scheduled to arrive at our warehouse at a specific times.  Each trailer is assigned a door where it is
 * unloaded.  The warehouse has 10 door.  The time taken to unload these trailers varies, but is already known.  Lets say
 * for a given day we are given a list of trailers, their assigned doors and their arrival time and the time to unload.
 * We need to find the time of the day when unloading is busiest.  What's the best way to compute the busiest time.
 */
public class TrailerScheduling {

    static class Trailer {
        private String id;
        private int doorNum;
        private LocalDateTime arrivalDate;
        private int unloadTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getDoorNum() {
            return doorNum;
        }

        public void setDoorNum(int doorNum) {
            this.doorNum = doorNum;
        }

        public LocalDateTime getArrivalDate() {
            return arrivalDate;
        }

        public void setArrivalDate(LocalDateTime arrivalDate) {
            this.arrivalDate = arrivalDate;
        }

        public int getUnloadTime() {
            return unloadTime;
        }

        public void setUnloadTime(int unloadTime) {
            this.unloadTime = unloadTime;
        }
    }

    public static String getBusiestTime(List<Trailer> trailerList) {

        trailerList.sort((o1, o2) -> {
            LocalDateTime x1 = o1.getArrivalDate();
            LocalDateTime x2 = o2.getArrivalDate();
            int dateComp = x1.compareTo(x2);

            if (dateComp != 0) {
                return dateComp;
            }

            Integer timeComp1 = o1.getUnloadTime();
            Integer timeComp2 = o2.getUnloadTime();
            return timeComp1.compareTo(timeComp2);
        });
        LocalDateTime earliest = trailerList.get(0).getArrivalDate();
        LocalDateTime latest = trailerList.get(trailerList.size()-1).getArrivalDate();
        Map<Integer, Boolean> doorStatus = new HashMap<>();
        trailerList.forEach(door -> doorStatus.put(door.getDoorNum(), Boolean.FALSE));
        long maxDoorsUsed = 0;
        LocalDateTime busiest = LocalDateTime.now();
        for(LocalDateTime dateTime = earliest;
            dateTime.isBefore(latest) || !dateTime.isEqual(latest);
            dateTime = dateTime.plusMinutes(2)) {
            for (Trailer trailer : trailerList) {
                LocalDateTime endTime = trailer.getArrivalDate().plusMinutes(trailer.getUnloadTime());
                if (dateTime.isEqual(trailer.getArrivalDate()) || (trailer.getArrivalDate().isBefore(dateTime) && endTime.isAfter(dateTime))) {
                    doorStatus.put(trailer.getDoorNum(), Boolean.TRUE);
                } else if (doorStatus.get(trailer.getDoorNum()) && dateTime.isAfter(endTime)) {
                    doorStatus.put(trailer.getDoorNum(), Boolean.FALSE);
                }
            }

            long doorsUsed = doorStatus.entrySet().stream().filter(Map.Entry::getValue).count();
            if(doorsUsed >= maxDoorsUsed) {
                maxDoorsUsed = doorsUsed;
                busiest = dateTime;
                System.out.println(busiest.toString());
                System.out.println(doorStatus.toString());
            }
        }
        return busiest.atZone(ZoneId.systemDefault()).toString();
    }

    public static void main(String[] args) {
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

        System.out.println(getBusiestTime(trailerList));
    }
}
