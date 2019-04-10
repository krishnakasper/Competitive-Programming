package CodeForces.Round61;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_Discounts {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=0;
        while (st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        i=0;
        int[] q = new int[m];
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            q[i++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long[] pre = new long[n];
        pre[0] = arr[0];
        for (i=1;i<n;i++){
            pre[i] = pre[i-1]+arr[i];
        }

        for(i=0;i<m;i++){
            int c = q[i];
            long temp = pre[n-1] - pre[n-(c)];
            int index = n-(c+1);
            if(index>=0)
                temp = temp+pre[index];
            bw.write(temp+"\n");
        }
        bw.flush();
    }
}
