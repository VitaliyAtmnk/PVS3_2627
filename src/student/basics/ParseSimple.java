package student.basics;

public class ParseSimple {
    public static void main(String[] args) {
        String data = "This is a number :3";
        String[]token = data.split(":");
        int parsednumber = Integer.parseInt(token[1]);
        System.out.print(parsednumber);
    }
}
