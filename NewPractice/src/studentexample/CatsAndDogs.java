package studentexample;

import java.util.*;

public class CatsAndDogs {
    public static void main(String[] args) {
        ArrayList cats = new ArrayList();
        for (int i = 0; i < 7; i++)
            cats.add(new Cat(i));
        // here¡¯s trouble
        cats.add(new Dog(8));
        for(int i = 0; i < cats.size(); i++)
            ( (Cat) cats.get(i) ).print();    // 4 Can't be  casted
    }
}
