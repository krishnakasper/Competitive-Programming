package tricon;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args)throws IOException {
        Map<Student,Integer> map = new HashMap<>();
        Student s1 = new Student("Ram","1");
        map.put(s1,50);
        Student s2 = new Student("shyam","2");
        map.put(s2,60);
        Student s3 = new Student("Ram","1");
        map.put(s3,56);

        System.out.println(map);
    }
}
