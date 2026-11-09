package oop.interfaces;

public class ClockWork {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch(0);
        watch.setStart(); // stopky si zapamatji, kdy zacinam merit
        watch.addMilliseconds(5500);
        watch.setStop();
        watch.displayTime();

        DigitalClock clock = new DigitalClock(2026, 11, 3, 13, 14);
        clock.displayTime();

        TimeSupport[] timeSupports = {watch, clock};
        timeSupports[0].displayTime();

    }
}
class DigitalClock implements TimeSupport{
    int year, month, day, hour, minute;

    public DigitalClock(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public void displayTime() {
        System.out.println("Today: " + day + ". " + month + ". (" + year+ ") " + hour + ":" + minute );
    }
}
class StopWatch implements TimeSupport{
    long milliseconds;

    //kdy zacnu merit
    long start;
    //kdy 'stopnu'
    long stop;

    void setStart(){
        //zacinam merit, start je, kolik si zrovna pamatuji stopky
        start = milliseconds;
    }

    void addMilliseconds(long toAdd){
        milliseconds += toAdd;
    }

    void setStop(){
        //v jaky bod v case jsem zastavil
        stop = milliseconds;
    }
    public StopWatch(long milliseconds){
        this.milliseconds = milliseconds;

    }

    @Override
    public void displayTime() {
        //vypsat ve formatu mm:ss (s nejakou desetinnou presnosti)
        long duration = stop - start;
        double totalSeconds = duration / 1000.0;
        int minutes = (int) (totalSeconds / 60);
        double seconds = totalSeconds % 60.0;
        System.out.println(minutes + ":" + seconds);
    }
}
