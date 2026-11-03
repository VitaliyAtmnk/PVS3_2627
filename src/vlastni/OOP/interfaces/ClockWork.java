package vlastni.OOP.interfaces;

public class ClockWork {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch(0);
        watch.setStart();
        watch.addMiliseconds(5500);
        watch.setStop();
        watch.addMiliseconds(7500);
        watch.displayTime();
        DigitalCLock clock = new DigitalCLock(2026,11,3,18,20,13);
        TimeSupport[] timeSupports = {watch,clock};
        timeSupports[0].displayTime();

    }



    }
class DigitalCLock implements TimeSupport{
    int year,month,day, hour,minute,second;

    public DigitalCLock(int year, int month, int day, int minute, int second, int hour) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.minute = minute;
        this.second = second;
        this.hour = hour;
    }
    @Override
    public void displayTime() {
        System.out.println("Today: " +day + ". " +month + ". (" + year + ") " + hour + ":"+minute );
    }


        }
class StopWatch implements TimeSupport {
    long stop;
    long start;
    long miliseconds;

    void setStart() {
        this.start = miliseconds;
    }

    void addMiliseconds(long toAdd) {
        miliseconds += toAdd;
    }

    void setStop() {
        stop = miliseconds;

    }

    public StopWatch(long miliseconds) {
        this.miliseconds = miliseconds;
    }

    @Override
    public void displayTime() {
        long duration = stop - start;

        double totalSeconds = duration / 1000.0;
        int minutes = (int) (duration/60);
        double seconds = totalSeconds % 60;
        System.out.println(minutes + ":" + seconds );

    }
}