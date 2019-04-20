package KickStart.RoundA;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Training {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        int k=1;
        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            int[] diff = new int[n];
            int i=0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                arr[i++] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            for (i=1;i<n;i++){
                diff[i] = arr[i]-arr[i-1];
            }
            int ans = Integer.MAX_VALUE;
            int total=0;
            for (i=1;i<p;i++){
                total += diff[i]*i;
            }
            ans = Math.min(ans,total);

            for (i=p;i<n;i++){
                total = (total - (arr[i-1]-arr[i-p])) + (diff[i]*(p-1));
                ans = Math.min(ans,total);
            }
            bw.write("Case #"+k+++": "+ans+"\n");
        }
        bw.flush();
    }
}
