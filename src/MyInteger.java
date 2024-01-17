public class MyInteger {
    private static MyInteger single_instance = null;
    public static  Integer a = 0;//make this volatile
    public static synchronized MyInteger getInstance()
    {
        if (single_instance == null)
            single_instance = new MyInteger();
        return single_instance;
    }
}
