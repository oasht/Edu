package org.example;

public class Time {

   private final int hours;
    private final int mins;
   private final int secs;

    public Time(int hours, int mins, int secs) {
        if(hours>23||hours<0)throw new IllegalArgumentException("incorrect hour number");
        this.hours = hours;
        if(mins>59|mins<0)throw new IllegalArgumentException("incorrect mins number");
        this.mins = mins;
        if(secs>59|secs<0)throw new IllegalArgumentException("incorrect secs number");
        this.secs = secs;
    }


    public Time(int secs) {
        if(secs>86400||secs<0)throw new IllegalArgumentException("incorrect secs number");
        this.secs = secs%60;
        this.hours=secs/3600;
        this.mins=secs / 60 % 60;
    }

    public int getHours() {
        return hours;
    }

    public int getMins() {
        return mins;
    }

    public int getSecs() {
        return secs;
    }

    @Override
    public String toString() {
            return String.format("%02d:%02d:%02d", hours, mins, secs);
    }

}
