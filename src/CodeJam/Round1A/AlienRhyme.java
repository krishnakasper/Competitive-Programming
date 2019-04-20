package CodeJam.Round1A;

import java.io.*;

public class AlienRhyme {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int asic = 65;

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        int count = 1;
        while (test-->0){
            int n = Integer.parseInt(br.readLine());
            Node root = new Node();
            for(int i=0;i<n;i++){
                String input = br.readLine();
                char[] arr = input.toCharArray();
                createTrie(root,arr,arr.length-1);
            }
            int sum = traverseTrie(root);
            bw.write("Case #"+count+++": "+sum+"\n");
        }
        bw.flush();
    }

    public static void createTrie(Node root, char[] arr,int index){
        if(index<0){
            return;
        }
        int charindex = arr[index]-asic;
        root.arr[charindex]++;
        if(root.node[charindex]==null)
            root.node[charindex] = new Node();
        createTrie(root.node[charindex],arr,index-1);
    }

    public static int traverseTrie(Node root){
        int sum=0;
        int ones=0;
        for (int i=0;i<26;i++){
            if(root.arr[i]==1){
                ones++;
                continue;
            }
            if(root.arr[i]==2 || root.arr[i] == 3){
                sum = sum+2;
                continue;
            }
            if(root.arr[i]>3) {
                int temp = traverseTrie(root.node[i]);
                if (temp == 0)
                    sum += 2;
            }
        }
        if(ones>1)
            sum+=2;
        return sum;
    }

    static class Node{
        Node[] node = new Node[26];
        int[] arr = new int[26];
    }
}
