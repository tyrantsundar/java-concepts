package generics;

public class BoundedExample<T extends Number> {
    private T data;

    BoundedExample(T data){
        this.data = data;
    }

    public static void main(String[] args) {
        BoundedExample intNum = new BoundedExample(9);
        BoundedExample doubleNum = new BoundedExample(9.9);
//        Below will throw compilation exception, since it is not the instance of number class.
//        BoundedExample strObj = new BoundedExample("sundar");
    }

}
