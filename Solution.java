import java.util.Scanner;

public class Solution {

  private static int modulo = (int) Math.pow(10, 9) + 7;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String int_inStringForm = scanner.next();
    scanner.close();

    int result = sum_of_allSubtrsings_modulo(int_inStringForm);
    System.out.println(result);
  }

  /** 
  * Calculates the sum of all possible substrings, modulo Math.pow(10, 9) + 7.
  *
  *@return An integer, representing this sum.
  */
  private static int sum_of_allSubtrsings_modulo(String int_inStringForm) {

    int n = int_inStringForm.length();
    char ch = int_inStringForm.charAt(n - 1);
    int totalSum_modulo = 0;

    // Stores the sum of all members of a geormetric progression: first member=1, multiplier=10.
    long sumGeomProg_firstMemberOne_multiplierTen = 0;

    for (int i = n - 1; i >= 0; i--) {
      
      sumGeomProg_firstMemberOne_multiplierTen = (1 + sumGeomProg_firstMemberOne_multiplierTen * 10) % modulo;

      ch = int_inStringForm.charAt(i);
      
      // Other alternative, applying the ASCII: digit =  ch - '0';
      int digit = Integer.parseInt(Character.toString(ch));

      long sumGeomProg = (digit * sumGeomProg_firstMemberOne_multiplierTen) % modulo;
      long sum_currentDigit = ((i + 1) * sumGeomProg) % modulo;

      totalSum_modulo = ((int) sum_currentDigit + totalSum_modulo) % modulo;
    }

    return totalSum_modulo;
  }
}
