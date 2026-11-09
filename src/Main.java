public class Main {

    static void doSomething(int a){
        System.out.println(a);
        a += 5;
        System.out.println(a);
    }


    static void doSomethingElse(int[] arr){
        System.out.println(arr[1]);
        arr[1] += 20;
        System.out.println(arr[1]);
    }


    public static void main(String[] args) {
        int a = 5;
        System.out.println(a);
        doSomething(a);
        System.out.println(a);
        int[] arr = {1, 5, 10};
        System.out.println(arr[1]);
        doSomethingElse(arr);
        System.out.println(arr[1]);

    }

}
