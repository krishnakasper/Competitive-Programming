
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class InterviewBit {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=1;
        while(st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] remove = new int[m];
        st = new StringTokenizer(br.readLine());
        i = 0;
        while(st.hasMoreTokens()){
            remove[i++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(remove);
        int count=0;
        for(i=0;i<m;i++){
            if(arr[remove[i]]==0)
                continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(remove[i]);
            count++;
            while(!q.isEmpty()){
                int t = q.poll();
                if(arr[t]==0){
                    continue;
                }
                arr[t]=0;
                for(int j=1;j<=n;j++){
                    if(arr[j]==t){
                        if(arr[j]==0)
                            continue;
                        q.add(j);
                    }
                }
            }
        }
        System.out.println(count);
    }
}
