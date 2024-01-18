import java.util.ArrayList;
import java.util.List;

public class TestSyncVolatile {
    private static final int NO_OF_THREADS = 100000;
    //public static List<ThreadTest> threadTestList = new ArrayList<>();
    public static List<AlocateListenerThread> alocateListenerThreads = new ArrayList<>();
    public static List<DeallocateListenerThread> deallocateListenerThreads = new ArrayList<>();
    public static List<TestCallingThreads> testCallingThreads = new ArrayList<>();
    public static void main( String [] args){
        System.out.println("Synchronized, Volatile TEST !!!!!");
        //System.out.println("Each thread adds 10 to the total(a variable) => Total should be equal to No of threads * 10 !!!!!");
        long start = System.nanoTime();

        for(int i = 0; i < NO_OF_THREADS; i++) {
            //threadTestList.add(new ThreadTest("Thread-"+i));
            //threadTestList.get(i).start();
            alocateListenerThreads.add(new AlocateListenerThread("Thread-Alloc"+i));
            alocateListenerThreads.get(i).start();
            deallocateListenerThreads.add(new DeallocateListenerThread("Thread-Dealloc"+i));
            deallocateListenerThreads.get(i).start();
            testCallingThreads.add(new TestCallingThreads("Thread-Test"+i));
            testCallingThreads.get(i).start();
        }
        for(int i = 0; i < NO_OF_THREADS; i++) {
            try {
                alocateListenerThreads.get(i).join();
                deallocateListenerThreads.get(i).join();
                testCallingThreads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long stop = System.nanoTime();
        System.out.println("Processing Time(miliseconds): " + ((stop - start)/1000000));
    }
}

