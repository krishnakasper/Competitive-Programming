package HashCode;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class OptimalSilider {
    private static FileReader reader = null;
    private static BufferedReader br = null;

    public static void main(String[] args)throws IOException{
        String file = "d_pet_pictures.txt";
        String path = "C:\\Users\\krish\\IdeaProjects\\HackerRankSI\\src\\HashCode\\";
        reader = new FileReader(path+file);
        br = new BufferedReader(reader);
        int n = Integer.parseInt(br.readLine());
        List<Photo> listH = new LinkedList<>();
        List<Photo> listV = new LinkedList<>();
        for(int i=0;i<n;i++){
            Photo temp = createPhoto(i,br.readLine());
            if(temp.H)
                listH.add(temp);
            else
                listV.add(temp);
        }
        List<String> list = new LinkedList<>();
        for (int i=0;i<listH.size();i++){
            list.add(listH.get(i).id+"");
        }
        for (int i=1;i<listV.size();i=i+2){
            list.add(listV.get(i-1).id+" "+listV.get(i).id);
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(path+"o"+file));
        bw.write(list.size()+"");
        bw.newLine();
        for (int i=0;i<list.size();i++){
            bw.write(list.get(i));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static Photo createPhoto(int id,String line){
        StringTokenizer st = new StringTokenizer(line);
        boolean H = false;
        if(st.nextToken().equals("H"))
            H = true;
        int numberOfTags = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        while (st.hasMoreTokens()){
            set.add(st.nextToken());

        }
        return new Photo(id,H,numberOfTags,set);
    }


    static class Photo{
        int id;
        boolean H;
        int numberOfTags;
        HashSet<String> tags = null;

        Photo(int id,boolean H,int numberOfTags,HashSet<String> tags){
            this.id = id;
            this.H = H;
            this.numberOfTags = numberOfTags;
            this.tags = tags;
        }
    }

}
