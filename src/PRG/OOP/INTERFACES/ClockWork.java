package PRG.OOP.INTERFACES;

public class ClockWork {
    static void main() {

        StopWatch watch = new StopWatch(0);
        watch.setStart();
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
    long start;
    long stop;

    void setStart(){

        start = milliseconds;
    }

    void addMilliseconds(long toAdd){

        milliseconds += toAdd;
    }

    void setStop(){

        stop = milliseconds;
    }
    public StopWatch(long milliseconds) {

        this.milliseconds = milliseconds;
    }

    @Override
    public void displayTime() {

        long duration = stop - start;
        double totalSeconds = duration / 1000.0;
        int minutes = (int) (totalSeconds / 60);
        double seconds = totalSeconds % 60.0;
        System.out.println(minutes + ":" + seconds);
    }
}
