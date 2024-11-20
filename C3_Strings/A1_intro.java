package C3_Strings;

public class A1_intro {
    public static void main(String[] args) {
//        Strings are objects
        String s1 = new String("sneha");
        s1 += " singh";
        System.out.println(s1);
        System.out.println(s1.contains("sne"));
        String s2 = "sneha";
        String s3 = "sebra";
        System.out.println(s2.compareTo(s3)); //output is 0 or <0 or >0
//        The comparison is done lexographically i.e s2 - s1
        System.out.println(s1.substring(2));
        System.out.println(s1.indexOf("singh"));
        System.out.println((s1.startsWith("i"))); //returns bool
        StringBuilder s4 = new StringBuilder("senha");
//        for each loop
        for (char e : s1.toCharArray()){
            System.out.println(e);
        }
    }
}
