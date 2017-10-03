
package versioncontrollab;
import java.lang.Math;

public class VersionControlLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        summation(2,5);
        multiplication(10,20);
        subtraction(50,25);
        exponentiation(2,5);
    }
    
    public static void summation(int a,int b){
        int c = a+b;
        System.out.println(c);
    }
        
    public static void multiplication(int a, int b){
        int c = a*b;
        System.out.println(c);
        
    }
    
    public static void subtraction(int a, int b){
        int c = a - b;
        System.out.println(c);
    }
    
    public static void exponentiation(int a, int b){
        double c = Math.pow(a,b);
        System.out.println(c);
        
    }
    
}
