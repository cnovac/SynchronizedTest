import java.util.ArrayList;
import java.util.List;

public class TestSyncVolatile {
    public static List<ThreadTest> threadTestList = new ArrayList<>();
    public static void main( String [] args){
        System.out.println("Synchronized, Volatile TEST !!!!!");

        for(int i = 0; i < 1000; i++) {
            threadTestList.add(new ThreadTest("Thread-"+i));
            threadTestList.get(i).start();
        }
    }
}

