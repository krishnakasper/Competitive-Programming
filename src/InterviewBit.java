
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class InterviewBit {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens())
            list.add(Integer.parseInt(st.nextToken()));
        list = solve(list);
        for (int i=0;i<list.size();i++)
            System.out.println(list.get(i));
        
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int p1=0;
        int p2=0;
        int i=0;
        int n = A.size();
        while(p1<n && p2<n&& i<n){
            while(p1<n){
                if(A.get(p1)>0){
                    p1++;
                }
                else{
                    break;
                }
            }
            if(p1<n && A.get(p1)!=A.get(i)){
                int temp = A.get(p1);
                A.remove(p1);
                A.add(i,temp);
            }
            p1++;
            i++;
            while(p2<n){
                if(A.get(p2)<0){
                    p2++;
                }
                else{
                    break;
                }
            }
            if(p2<n && i<n && A.get(p2)!=A.get(i)){
                int temp = A.get(p2);
                A.remove(p2);
                A.add(i,temp);
            }
            p2++;
            i++;
        }
        return A;
    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        long[] sum = new long[A.size()];
        int[] size = new int[A.size()];
        long total=0;
        int count=0;
        for(int i=0;i<A.size();i++){
            if(A.get(i)<0){
                total=0;
                count=0;
                sum[i]=0;
                size[i]=0;
            }
            else{
                total+=A.get(i);
                count++;
                sum[i]=total;
                size[i]=count;
            }
        }

        long max = 0;
        for(int i=0;i<A.size();i++){
            max = Math.max(max,sum[i]);
        }
        int index=0;
        int seg=0;
        for(int i=0;i<A.size();i++){
            if(sum[i]==max){
                if(seg<size[i]){
                    index=i;
                    seg=size[i];
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=index-seg+1;i<=index;i++){
            result.add(A.get(i));
        }
        return result;
    }
}
