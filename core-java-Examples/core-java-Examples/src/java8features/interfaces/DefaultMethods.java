package java8features.interfaces;

public class DefaultMethods implements Sayable{    
    public void sayMore(String msg){     // implementing abstract method    
        System.out.println("Overriding abstract method: " + msg);    
    }    
    public static void main(String[] args) {    
        DefaultMethods dm = new DefaultMethods();    
        dm.sayDefault();                       // calling default method    
        dm.sayMore("saymore method");      // calling abstract method    
        Sayable.sayLouder("Helloooo...");   // calling static method    
    }    
}    