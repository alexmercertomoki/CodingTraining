package studentexample;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestStudent {
	public class Cat{
		Cat(){
			
		}
	}
	
    public static void main(String[] args) {
    	Student s1 = new Student("Fred", 3.00F);
    	Student s2 = new Student("Sam", 3.50F);
    	Student s3 = new Student("Steve", 2.10F);
    	//Dog d=new Dog("xiaogou",3.99F);
    	CompareStudentNames c1=new CompareStudentNames();
    	
//    	if (s3.compareTo((Object)s2) < 0)
//	    System.out.println(s3.getName()  + " has a lower gpa than " + s2.getName());
//    	if (d.compareTo((Object)s2) > 0)
//    		System.out.println(s3.getName()  + " has a lower gpa than " + d.getName());
        Set studentSet = new TreeSet(); //·ºÐÍ be really careful about this<Student>
        studentSet.add(s1);
        studentSet.add(s2);
        studentSet.add(s3);
        
//      studentSet.add(d);
        Iterator<Student> i = studentSet.iterator();
        while(i.hasNext())
            System.out.println(((Student)i.next()).getName());
            System.out.println(c1.compare(s1, s2)); 
            
          
        
    }
}