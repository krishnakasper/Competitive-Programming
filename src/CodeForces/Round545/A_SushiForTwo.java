package CodeForces.Round545;

import java.io.*;
import java.util.StringTokenizer;

public class A_SushiForTwo {
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

        int curr=arr[0];
        int currvalue=1;
        int prev=0;
        int prevalue=0;
        int ans=2;
        for (i=1;i<n;i++){
            if(curr==arr[i]){
                currvalue++;
            }
            else{
                ans = Math.max(ans,2*Math.min(prevalue,currvalue));
                curr = arr[i];
                prevalue = currvalue;
                currvalue=1;
            }
        }
        ans = Math.max(ans,2*Math.min(prevalue,currvalue));
        bw.write(ans+"\n");
        bw.flush();

    }
}
