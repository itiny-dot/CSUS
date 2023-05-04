import java.util.*;
import java.io.*;
class MagicalCreaturesHelper {
    
   public static void main(String[] args)throws FileNotFoundException{
       mystery(38);

    

   }
   public static void mystery(int n){
      if(n<10){
         System.out.print(n);
      } else{
         mystery(n/10);
         int digit = n % 10;
         System.out.print(digit % 3 + ", ");
      }
 }
 

    
}
    
