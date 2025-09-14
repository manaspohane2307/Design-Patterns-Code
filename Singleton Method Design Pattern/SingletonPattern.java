public class SingletonPattern{
    public static void main(String[] args) {
        Singleton.getInstance();
    }
}

class Singleton{
    private static Singleton instance;

    private Singleton(){
        System.out.println("Instance created");
    }

    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}