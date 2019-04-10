import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PowerfulSubsets {

    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test = Integer.parseInt(st.nextToken());
        while(test-->0){
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            long[] arr = new long[num];
            int i=0;
            while(st.hasMoreTokens())
                arr[i] = Long.parseLong(st.nextToken());
            check(arr);
         }
    }

    private static void check(long[] arr){
        int bits = 40;
        int count=0;
        for(int i=bits;i>0;i--){
            int flag=0;
            for(int j=0;j<arr.length;j++){
                if(!checkbit(i,arr[j]))
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                count++;
        }
        if(count==1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static boolean checkbit(int i, long j){
        if(((long)1<<i & j)>0)
            return true;
        return false;
    }
}
