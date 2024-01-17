public class ThreadTest extends Thread {
    private String name;
    private static Object lock = new Object();

    public ThreadTest(String name) {
        this.name = name;
    }

    public void run() {
        increment();
    }

    private void increment() {
        synchronized (lock) {
            MyInteger myInteger = MyInteger.getInstance();
            myInteger.a = myInteger.a + 1;
            myInteger.a = myInteger.a + 4;
            myInteger.a = myInteger.a + 3;
            myInteger.a = myInteger.a + 2;
            System.out.println(this.name+"("+System.identityHashCode(myInteger.a)+")" + " :a = " + myInteger.a);
        }
    }
}
