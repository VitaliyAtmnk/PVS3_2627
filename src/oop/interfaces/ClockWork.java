package oop.interfaces;

public class ClockWork {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch(0);
        watch.setStart(); //stopky si zapamatuji, kdy zacinam merit
        watch.addMilliseconds(500);
        watch.setStop();
        watch.stopWatch();

        DigitalClock clock = new DigitalClock(2026, 11, 3, 13, 15, 10, 8);
        clock.displayTime();

        TimeSupport[] timeSupports = {watch, clock};
        timeSupports[0].displayTime();

    }
}
class DigitalClock {
    int year, month, week, day, hour, minute, second;

    public DigitalClock(int year, int month, int day, int hour, int minut, int second, int week) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minut;
        this.second = second;
        this.week = week;
    }
    @Override
    public void displayTime() {
        System.out.println("Today: " + day + ". " + month + ". " + year + ". " + hour + ". " + minute + "");
    }
}
class stopWatch implements TimeSupport {
    long milliseconds;

    //kdy zacnu merit
    long start;
    //kdy 'stopnu'
    long stop;

    void setStart() {
        //začínám měřit, start je, kolik si zrovna pamatují stopky
        start = milliseconds;
    }
    void addMilliseconds(long toAdd) {
        milliseconds += stop;
    }
    void setStop() {
        milliseconds
    }

    public stopWatch(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public void displayTime() {
        //vypsat ve formatu mm:ss (s nejakou desetinnou presnosti)
        long duration = stop - start;
        double totalSeconds = duration / 1000.0;
        int minutes = (int) (totalSeconds / 60);
        double seconds = totalSeconds % 60.0;

    }
}