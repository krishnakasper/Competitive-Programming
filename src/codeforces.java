import java.io.*;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class codeforces{

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args)throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int i;

        int[] students = new int[n];
        int[] school = new int[n];
        int[] choosen = new int[k];
        int[] max = new int[m];

        st = new StringTokenizer(br.readLine());
        i=0;
        while (st.hasMoreTokens()){
            students[i++] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        i=0;
        while (st.hasMoreTokens()){
            school[i++] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        i=0;
        while (st.hasMoreTokens()){
            choosen[i++] = Integer.parseInt(st.nextToken());
        }

        for (i=0;i<n;i++){
            max[school[i]-1] = Math.max(max[school[i]-1],students[i]);
        }

        int count=0;
        for(i=0;i<k;i++){
            int index = linearSearch(students,choosen[i]);
            int ischool = school[index];
            if(max[ischool-1]>choosen[i]){
                count++;
            }
        }
        bw.write(count+"\n");
        bw.flush();
    }


    private static int linearSearch(int[] arr, int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
}