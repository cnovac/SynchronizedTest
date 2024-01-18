public class AlocateListenerThread extends Thread{
    private String name;
    public AlocateListenerThread(String name) {
        this.name = name;
    }
    public void run() {
        MyInteger myInteger = MyInteger.getInstance();
        myInteger.myListener = new MyListener();
    }
}
