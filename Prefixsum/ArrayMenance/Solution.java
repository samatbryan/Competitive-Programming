import java.util.*;


public class Solution{

  public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=1; i<=T; i++){
            int N = in.nextInt();
            int[] arr = new int[N];

            int total = 0;
            for(int j=0; j<N; j++){
                arr[j] = in.nextInt();
                total += arr[j];

            }
            long res = 0;
            for(int k=0; k<N; k++){
              res += total/arr[k];
            }
            System.out.println(Long.toString(res));
        }
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here

    }
    /*
  public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=1; i<=T; i++){
            int N = in.nextInt();
            int[] arr = new int[N];

            for(int j=0; j<N; j++){
                arr[j] = in.nextInt();

            }


            int[] prefixsum = new int[N];
            prefixsum[0] = arr[0];
            for(int k=1; k<N; k++){
                prefixsum[k] = prefixsum[k-1] + arr[k];
            }
            long res = 0;
            for(int p=0; p<N; p++){
                res += prefixsum[p] / arr[p];
            }
            System.out.println(Long.toString(res));
        }
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT



        // Write your code here

    }
*/

}
