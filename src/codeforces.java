import java.io.*;
import java.util.*;

public class codeforces{

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args)throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] operation = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=1;
        while (st.hasMoreTokens()) {
            operation[i++] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        i = 2;
        while (st.hasMoreTokens()) {
            int v = Integer.parseInt(st.nextToken());
            list[v].add(i);
            i++;
        }

        bw.write(dfs(1,list,operation)+"\n");
        bw.flush();
    }

    private static int dfs(int v,ArrayList<Integer>[] list, int[] operation){
        return 0;
    }
}