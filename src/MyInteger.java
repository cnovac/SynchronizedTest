public class MyInteger {
    private static MyInteger single_instance = null;
    public static Integer a = 0;//can make this volatile, but no need if Synchronized block is used
    //Synchronized block will make sure the value is visible/propagated between all threads.
    public static synchronized MyInteger getInstance()
    {
        if (single_instance == null)
            single_instance = new MyInteger();
        return single_instance;
    }
}
