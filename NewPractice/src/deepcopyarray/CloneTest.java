package deepcopyarray;

public class CloneTest {
    public static void main(String[] args) {
        SimpleObject s1 = new SimpleObject(1);
        System.out.println(s1);
        SimpleObject s2 = (SimpleObject)( s1.clone());
        System.out.println(s2);
        }
}
