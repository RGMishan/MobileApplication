import java.util.*;

public class diceLuck {
 public static void main(String args[]){ 
  int die1;
  int die2;
  Random rand = new Random(); // create Random object once
  int tries = 0;
  do {
   die1 = rand.nextInt(6) + 1;
   die2 = rand.nextInt(6) + 1;
  System.out.println(die1 + ", " + die2);
  tries++;
  } while (die1 != die2);
  System.out.println("It took you " + tries + " tries.");
  }
}