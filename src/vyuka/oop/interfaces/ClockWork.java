package vyuka.oop.interfaces;

public class ClockWork {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch(0);
        watch.setStart(); // stopky jsi zapamatují kdy začínam měřit
        watch.addMilliseconds(5500);
        watch.setStop();
        watch.addMilliseconds(7500);
        watch.displayTime();

        DigitalClock clock = new DigitalClock(2026, 11, 3, 13, 15);
        clock.displayTime();

        TimeSupport[] timeSupports = {watch, clock};
        timeSupports[0].displayTime();
    }
}

class DigitalClock implements TimeSupport {
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
        System.out.println("Today: " + day + ". " + month + ". (" + year + ") " + hour + ":" + minute);
    }
}

class StopWatch implements TimeSupport {
    long milliseconds;

    // kdy začnu měřit
    long start;
    // kdy 'stopnu'
    long stop;

    void setStart() {
        // začínam měřit, start je, kolik si zrovna pamatují stopky
        start = milliseconds;
    }

    void addMilliseconds(long toAdd) {
        milliseconds += toAdd;
    }

    void setStop() {
        stop = milliseconds;
    }

    public StopWatch(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public void displayTime() {
        // vypsat ve formátu mm:ss (s nějakou desetinnou přesností)
        long duration = stop - start;
        double totalSeconds = duration / 1000.0;
        int minutes = (int) (totalSeconds / 60);
        double seconds = totalSeconds % 60.0;
        System.out.println(minutes + ":" + seconds);
    }
}