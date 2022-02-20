public class test {
    public static void main(String[] args){
        String a = "abc";
        String b = new String("abc");
        String c = "abc";
        String d = new String("abc");

        System.out.println(a == c);
        a += "a";
        System.out.println(c);
        System.out.println(a);
        System.out.println(a == c);
        System.out.println(b == d);
        System.out.println(b.equals(d));
    }
}
