package Tools;
import java.text.SimpleDateFormat;

//做一个秒表，用来做排序计时
public class StopWatch {
    private long startTime; // Start time
    private long endTime;	// End time
    // Resets the startTime to the current time
    public void start() {
        startTime = System.currentTimeMillis();
        System.out.println("Stop Watch is start....");
    }

    // Sets the endTime to the current time
    public void stop() {
        endTime = System.currentTimeMillis();
        System.out.println("Stop Watch is end.");
    }

    public long getElapsedTime() {
        return getEndTime() - getStratTime();
    }

    public void printElapsedTime(){
        String startTimeString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(startTime);
        String endTimeString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(endTime);

        System.out.println("Stop Watch start at : " + startTimeString);
        System.out.println("Stop Watch end at : " + endTimeString);
        System.out.println("Elapsed time is : " + (double)getElapsedTime() / 1000 + " seconds.");

    }

    // Return start time
    public long getStratTime() {
        return startTime;
    }

    // Return end time
    public long getEndTime() {
        return endTime;
    }

}
