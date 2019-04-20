package KickStart.RoundA;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Parcels {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        int k = 1;
        while (test-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[n][m];
            for (int i=0;i<n;i++){
                String temp = br.readLine();
                for (int j=0;j<m;j++){
                    if(temp.charAt(j)=='1'){
                        matrix[i][j] = 0;
                    }
                    else
                    {
                        matrix[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
            boolean[][] visited = new boolean[n][m];
            for(int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    if(matrix[i][j]==0){
                        visited = getVisited(visited);
                        BSF(i,j,0,visited,matrix,n,m);
                    }
                }
            }
            int[] index = getMaxIndex(matrix,n,m);
            matrix[index[0]][index[1]] = 0;
            BSF(index[0],index[1],0,getVisited(visited),matrix,n,m);
            int ans = getMaxElement(matrix,n,m);
            bw.write("Case #"+k+++": "+ans+"\n");
        }
        bw.flush();
    }

    private static void BSF(int i, int j,int d, boolean[][] visited,int[][] matrix,int n,int m){
        Queue<Integer[]> q = new LinkedList<>();
        Integer[] index = {i,j};
        ((LinkedList<Integer[]>) q).add(index);
        ((LinkedList<Integer[]>) q).add(null);
        int count=0;
        while (!q.isEmpty()){
            index = q.poll();
            if(index==null && !q.isEmpty()){
                q.add(null);
                count++;
                continue;
            }
            if(index==null && q.isEmpty())
                break;
            if(index[0]<0 || index[1]<0 || index[0]>=n || index[1] >=m)
                continue;
            if(visited[index[0]][index[1]])
                continue;
            visited[index[0]][index[1]] = true;
            matrix[index[0]][index[1]] = Math.min(matrix[index[0]][index[1]], count);
            index = new Integer[]{index[0] + 1, index[1]};
            ((LinkedList<Integer[]>) q).add(index);
            index = new Integer[]{index[0] - 1, index[1]};
            ((LinkedList<Integer[]>) q).add(index);
            index = new Integer[]{index[0], index[1]+1};
            ((LinkedList<Integer[]>) q).add(index);
            index = new Integer[]{index[0], index[1]-1};
            ((LinkedList<Integer[]>) q).add(index);

        }
    }

    private static int[] getMaxIndex(int[][] matrix,int n,int m){
        int ans = getMaxElement(matrix,n,m);
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(ans == matrix[i][j]){
                    int[] index = {i,j};
                    return index;
                }
            }
        }
        int[] index = {0,0};
        return index;
    }

    private static int getMaxElement(int[][] matrix,int n,int m){
        int max = Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                max = Math.max(max,matrix[i][j]);
            }
        }
        return max;
    }

    private static boolean[][] getVisited(boolean[][] visited){
        for (int i=0;i<visited.length;i++){
            for (int j=0;j<visited[0].length;j++){
                visited[i][j] = false;
            }
        }
        return visited;
    }
}
