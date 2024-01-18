public class DeallocateListenerThread extends Thread{
    private String name;
    public DeallocateListenerThread(String name) {
        this.name = name;
    }
    public void run() {
//        calling();
        synchronized(MyInteger.getInstance()) {
            MyInteger myInteger = MyInteger.getInstance();
            myInteger.myListener = null;
        }
    }
//    public synchronized void calling() {
//        MyInteger myInteger = MyInteger.getInstance();
//        myInteger.myListener = null;
//    }
}
