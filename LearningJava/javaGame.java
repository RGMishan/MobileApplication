import sun.launcher.resources.launcher;
import java.util.*;  

public class javaGame {
  public static void main(String args[]) {

   Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
   System.out.print("Enter the string: ");  
   String word = sc.nextLine();  
   int numCount = word.length();
   int numVowel = 0;
   for (int i = 0; i<numCount; i++){
    char ch = word.charAt(i);
    ch = Character.toLowerCase(ch);
    if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
     numVowel = numVowel + 1;
    }
   }
    int score = 2 * numCount;
    if(numCount >= 4 && numVowel >= (numCount-numVowel)){
     score = 2 * score;
    }
   
   System.out.println("Your score is " + score);
  }
}

