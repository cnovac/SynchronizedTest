public class TestCallingThreads extends Thread{
    private String name;
    public TestCallingThreads(String name) {
        this.name = name;
    }
    public void run() {
        MyInteger.getInstance().test(name);
    }
}
