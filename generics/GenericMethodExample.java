package generics;

public class GenericMethodExample {

    private static <T> void printNum(T[] arr){
        for(T mem : arr){
            System.out.print(mem+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] strArr = new String[]{"apple","banana","orange"};
        printNum(strArr);

        Integer[] intArr = new Integer[]{1,2,3,4,5};
        printNum(intArr);

    }
}
