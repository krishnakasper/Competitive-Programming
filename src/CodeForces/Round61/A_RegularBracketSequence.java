package CodeForces.Round61;

import java.io.*;
import java.util.Stack;

public class A_RegularBracketSequence {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException {
        long ct1 = Long.parseLong(br.readLine());
        long ct2 = Long.parseLong(br.readLine());
        long ct3 = Long.parseLong(br.readLine());
        long ct4 = Long.parseLong(br.readLine());


        if(calculateOptimal(ct1,ct2,ct3,ct4))
            bw.write(1+"\n");
        else
            bw.write(0+"\n");

        bw.flush();
    }

    private static boolean calculateOptimal(long ct1,long ct2,long ct3,long ct4){
        return (ct1==ct4&&(ct3==0 || ct1>0));
    }

    private static boolean calculate(long ct1,long ct2,long ct3,long ct4){
        long ans = 0;
        ans = ans+ct1*2;
        ans = ans+(1*ct2);
        ans = ans-(1*ct2);
        ans = ans-(1*ct3);
        if(ans<0){
            return false;
        }
        ans = ans+(1*ct3);
        ans = ans-(ct4*2);
        if(ans<0){
            return false;
        }
        if(ans==0)
            return true;
        return false;
    }
}
