package CodeJam.Qualification;

import java.io.*;
import java.util.*;

public class Cryptopangrams {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        int x = 0;
        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            long[] arr = new long[size];
            st = new StringTokenizer(br.readLine());
            int i=0;
            while (st.hasMoreTokens())
                arr[i++] = Long.parseLong(st.nextToken());
            String output = calculate(arr,N);
            x++;
            bw.write("Case #"+x+": "+output+"\n");
        }

        bw.flush();
    }

    public static String calculate(long[] arr,int N){
        String ans = "";
        int size = arr.length;
        long[] temp = getSmallest(arr);
        long smallest = temp[0];
        int smallestIndex = (int)temp[1];
        HashSet<Integer> set = getPrimes(smallest);
        int p1 = (int)smallestIndex;
        int p2 = (int)smallestIndex;
        long[] factors = getFactors(smallest,set);
        int[] primes = new int[size+1];
        if(smallestIndex==0){
            if(arr[1]%factors[0]==0){
                primes[1] = (int)factors[0];
                primes[0] = (int)factors[1];
            }
            else {
                primes[1] = (int)factors[1];
                primes[0] = (int)factors[0];
            }
        }
        else {
            if(arr[smallestIndex-1]%factors[0]==0){
                primes[smallestIndex] = (int)factors[0];
                primes[smallestIndex+1] = (int)factors[1];
            }
            else {
                primes[smallestIndex] = (int)factors[1];
                primes[smallestIndex+1] = (int)factors[0];
            }

        }
        while (p1>0){
            primes[p1-1] = (int)arr[p1-1]/primes[p1];
            p1--;
        }
        while (p2<primes.length-1){
            primes[p2+1] = (int)arr[p2]/primes[p2];
            p2++;
        }
        int[] t = new int[primes.length];
        for (int i=0;i<t.length;i++)
            t[i] = primes[i];
        Arrays.sort(t);
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        for (int i=0;i<t.length;i++){
            if(map.containsKey(t[i])){
                continue;
            }
            else {
                map.put(t[i],count);
                count++;
            }
        }
        for (int i=0;i<t.length;i++){
            ans = ans+ (char)(map.get(primes[i])+97);
        }
        return ans.toUpperCase();
    }

    public static long[] getFactors(long num,HashSet<Integer> set){
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            int n = it.next();
            if(num%n==0){
                long[] ans = {n,num/n};
                return ans;
            }
        }
        long[] ans = {0,0};
        return ans;
    }

    public static HashSet<Integer> getPrimes(long num){
        HashSet<Integer> set = new HashSet<>();
        boolean[] arr = new boolean[(int)num+1];
        arr[0] = true;
        arr[1] = true;
        for (int i=2;i<arr.length;i++){
            if(arr[i])
                continue;
            set.add(i);
            for (int j= i*i;j<arr.length;j=j+i){
                arr[j]=true;
            }
        }
        return set;
    }

    public static long[] getSmallest(long[] arr){
        long min = Long.MAX_VALUE;
        long index = 0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
                index = i;
            }
        }
        long[] result = {min,index};
        return result;
    }

}
