package CodeJam;

import java.io.*;

public class YouCanGoYourOwnWay {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        int x = 0;
        while (test-->0){
            int N = Integer.parseInt(br.readLine());
            String path  = br.readLine();
            String output = "";
            for (int i=0;i<path.length();i++){
                if(path.charAt(i)=='S')
                {
                    output = output+"E";
                }
                else{
                    output = output+"S";
                }
            }
            x++;
            bw.write("Case #"+x+": "+output+"\n");
        }

        bw.flush();
    }
}
