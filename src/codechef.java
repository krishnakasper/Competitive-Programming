import javax.imageio.stream.IIOByteBuffer;
import java.io.*;
import java.util.*;

class codechef {
    public static boolean[] visited=null;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            visited = new boolean[n+1];
            int[] arr = new int[n+1];
            st = new StringTokenizer(br.readLine());
            int i=1;
            while (st.hasMoreTokens()){
                arr[i++] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Integer>[] list = new ArrayList[n+1];
            for(i=0;i<=n;i++)
                list[i] = new ArrayList<>();
            for(i=0;i<n-1;i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list[u].add(v);
                list[v].add(u);
            }
            bw.write(dfs(1,list,arr,x)+"\n");
        }
        bw.flush();
    }

    private static long dfs(int v,ArrayList<Integer>[] list,int[] arr,int x){
        long ans = 0;
        visited[v] = true;
        for(int u:list[v]){
            if(visited[u])
                continue;
            ans +=dfs(u,list,arr,x);
        }
        ans+=arr[v];
        return Math.max(ans,-x);
    }

    private static long findSum(int node){
        if(sumCheck[node])
            return sum[node];
        LinkedList<Integer> temp = map.get(node);
        long ans = 0;
        for(int i=0;i<temp.size();i++){
            ans = ans+findSum(temp.get(i));
        }
        sumCheck[node] = true;
        sum[node] = ans+values[node];
        return sum[node];
    }

    private static int[] values;
    private static long[] sum;
    private static boolean[] sumCheck;
    private static HashMap<Integer,LinkedList<Integer>> map;

    public static Pair getUp(Pair curr){
        return new Pair(curr.i-1,curr.j);
    }

    public static Pair getDown(Pair curr){
        return new Pair(curr.i+1,curr.j);
    }

    public static Pair getRight(Pair curr){
        return new Pair(curr.i,curr.j+1);
    }

    public static Pair getLeft(Pair curr){
        return new Pair(curr.i,curr.j-1);
    }

    static class Pair{
        int i,j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return i == pair.i &&
                    j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public static long sum(int[] arr){
        long ans = 0;
        for (int i=0;i<arr.length;i++){
            ans = ans+arr[i];
        }
        return ans;
    }

    private static int findSecondDistinct(int[] arr, int num)
    {
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]!=num){
                return arr[i];
            }
        }
        return num;
    }


    private static String removeAllDigits(String num,int digit){
        String ans = "";
        for (int i=0;i<num.length();i++){
            char ch = num.charAt(i);
            if((int)ch-48<digit){
                ans = ans+ch;
            }
        }
        return ans;
    }

    private static int findFirstOccurence(String num,int digit){
        for(int i=0;i<num.length();i++)
        {
            char ch = num.charAt(i);
            if((int)ch-48==digit){
                return i;
            }
        }
        return -1;
    }


    private static int findLargest(String num, int digit){
        int index = -1;
        int max = digit;
        for(int i=0;i<num.length();i++)
        {
            char ch = num.charAt(i);
            if((int)ch-48>digit){
                index = i;
                max = (int)ch-48;
            }
        }
        return index;
    }

    private static boolean checkSequence(String input, char[] ans){
        int i=0;
        for(char ch : input.toCharArray()){
            if(ans[i]==ch){
                i++;
            }
            if(i==ans.length){
                return true;
            }
        }
        return false;
    }



    private static boolean checkRank(String[] arr,String s){
        char ch = s.charAt(0);
        for(int i=0;i<5;i++){
            if(ch==arr[i].charAt(0))
                return true;
        }
        return false;
    }

    private static boolean checkSuit(String[] arr,String s){
        char ch = s.charAt(1);
        for(int i=0;i<5;i++){
            if(ch==arr[i].charAt(1))
                return true;
        }
        return false;
    }

    private static boolean clockWise(int[] arr, int i, int sum){
        if(i==arr.length){
            if(sum%360==0)
                return true;
        }
        else{
            int temp = sum+arr[i];
            if(clockWise(arr, i+1, temp)){
                return true;
            }
            if(antiClockWise(arr, i+1,temp))
                return true;
        }
        return false;
    }

    private static boolean antiClockWise(int[] arr, int i, int sum){
        if(i==arr.length){
            if(sum%360==0)
                return true;

        }
        else{
            int temp = sum-arr[i];
            if(clockWise(arr, i+1, temp)){
                return true;
            }
            if(antiClockWise(arr, i+1,temp))
                return true;
        }
        return false;
    }

    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static boolean[] primes = computecheck(100);
    static int count=0;

    private static void premute(int[] arr,int start){
        int size = arr.length;
        if(size==start+1){
            boolean check = primecheck(arr);
            if(!check)
                return;
            int[] dec = convertIntoDec(arr);
            boolean flag = false;
            for(int i=0;i<list.size();i++){
                ArrayList<Integer> temp = list.get(i);

                for(int j=0;j<size;j++){
                    if(dec[j]==temp.get(j)) {
                        flag=true;
                        continue;
                    }
                    else
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    break;
            }
            if(!flag)
                list.add(createList(dec));
        }
        else
        {
            for(int i=start;i<size;i++){
                int temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;
                premute(arr,start+1);
                temp = arr[i];
                arr[i] = arr[start];
                arr[start]=temp;
            }

        }
    }

    private static ArrayList<Integer> createList(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
            list.add(arr[i]);
        return list;
    }

    private static int[] convertIntoDec(int[] arr){
        int[] temp = new int[arr.length];
        int i=0;
        for(i=0;i<arr.length;i++){
            if(arr[i]==1)
                break;
        }
        temp[0]=1;
        int j=1;
        i=(i+1)%arr.length;
        while(arr[i]!=1){
            temp[j]=arr[i];
            i=(i+1)%arr.length;
        }

        return temp;
    }

    private static boolean primecheck(int[] arr){
        for(int i=0;i<arr.length;i++){
            int temp = arr[i]+arr[(i+1)%arr.length];
            if(!primes[temp])
                return false;
        }
        return true;
    }
    private static boolean[] computecheck(int num){
        boolean[] check = new boolean[num+1];
        Arrays.fill(check,true);
        int count=0;
        check[0] = false;
        check[1] = false;
        int sqrt = (int)Math.sqrt(num);
        for(int i=2;i<=sqrt;i++){
            if(!check[i])
                continue;
            for(int j=i*i;j<=num;j=j+i){
                check[j] = false;
            }
        }
        return check;
    }
}
