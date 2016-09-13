package studentexample;

//public class Dog implements Comparable<Object> {
//	public Dog(String name, float gpa) {
//        this.name = name;
//        this.gpa = gpa;
//    }
//    public Dog() {}
//    public int compareTo(Object o) {
//        if ( ((Dog)o).gpa < gpa )
//            return 1;
//        else if ( ((Dog)o).gpa > gpa )
//            return -1;
//        else
//            return 0;
//    }
//    public boolean equals(Object o) {
//        if (gpa == ((Dog) o).gpa)
//            return true;
//        else
//            return false;
//    }
//    public String getName() { return name;}
//    public float getGpa() { return gpa;}
//    private String name;
//    private float gpa;
//}
public class Dog {
    private int dogNumber;
    Dog(int i) { dogNumber = i; }
    void print() { 
        System.out.println("Dog #" + dogNumber); 
    }
}
