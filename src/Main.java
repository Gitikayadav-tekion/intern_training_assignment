import java.util.Scanner;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

    static int countA =0, sumA=0;
    static int countB =0, sumB=0;

    static boolean allout = false ;
    public static void check ( int x, char team ){

        if (allout)
            return;

        if ( countB >=10 && team =='B') {

            System.out.println(" Team B is all out ");
            allout=true;
            return;
        }
        if ( countA >=10 && team =='A' ) {

            System.out.println(" Team A is all out ");
            allout=true;
            return;

        }

            System.out.print(x + " ");
            if (x == 7)

                if (team == 'A')
                    countA++;
                else countB++;

            else if (team == 'A')
                sumA += x;
            else
                sumB += x;

    }

    public static void randomval( int num, int origin, int bound, char team ){

        char[] outcomes= {  '0', '1', '2', '3', '4' , '5' , '6' , 'W'};

        Random outcome = new Random();
        //Stream<IntStream> s= outcome.ints(num,origin, bound ).boxed();

        Stream <Integer>  s=  outcome.ints(num,origin, bound ).boxed();

        //s.forEach( (n) -> System.out.println(n));
        s.forEach((n) -> check(n, team));

        System.out.println(" ");
        if ( team =='A') {
            System.out.println(sumA);
            System.out.println(countA);
        }
        else
        {
            System.out.println(sumB);
            System.out.println(countB);
        }

    }
    public static void main(String[] args) {

        System.out.println("Enter the number of overs");
        Scanner sc = new Scanner(System.in);
        int overs= sc.nextInt();
        System.out.println(" Team 1");
        //team 1
          randomval(6*overs, 0, 8, 'A');

          allout=false;
          //team 2
        System.out.println("team 2");
        randomval(6*overs, 0, 8, 'B');

          if ( sumA > sumB )
              System.out.println(" TeamA winssssssss");
          else if ( sumA==sumB)
              System.out.println("It is a tieeee");
          else
           System.out.println("Team B winssssssssss");


    }
}