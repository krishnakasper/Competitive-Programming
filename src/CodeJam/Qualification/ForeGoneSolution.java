package CodeJam.Qualification;

import java.io.*;

public class ForeGoneSolution {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        int x = 0;
        while (test-->0){
            String s = br.readLine();
            String a = "";
            String b = "";
            for (int i= 0; i<s.length();i++){
                int temp = Integer.parseInt(s.charAt(i)+"");
                if(temp == 4){
                    a = a+"3";
                    b = b+"1";
                }
                else{
                    a = a+temp;
                    b = b+"0";
                }
            }
            x++;
            bw.write("Case #"+x+": "+removeLeadingZeros(a)+" "+removeLeadingZeros(b)+"\n");
        }
        bw.flush();
    }

    public static String removeLeadingZeros(String input){
        String output = "";
        boolean flag = false;
        for (int i=0;i<input.length();i++){
            if(flag){
                output = output+input.charAt(i);
                continue;
            }
            else {
                if(Integer.parseInt(input.charAt(i)+"")>0){
                    flag = true;
                    output = output+input.charAt(i);
                }
            }
        }
        return output;
    }
}
