import java.util.ArrayList;
import java.util.List;

public class TestSyncVolatile {
    private static final int NO_OF_THREADS = 10000;
    public static List<ThreadTest> threadTestList = new ArrayList<>();
    public static void main( String [] args){
        System.out.println("Synchronized, Volatile TEST !!!!!");
        long start = System.nanoTime();

        for(int i = 0; i < NO_OF_THREADS; i++) {
            threadTestList.add(new ThreadTest("Thread-"+i));
            threadTestList.get(i).start();
        }
        for(int i = 0; i < NO_OF_THREADS; i++) {
            try {
                threadTestList.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long stop = System.nanoTime();
        System.out.println("Processing Time: " + (stop - start));
    }
}

