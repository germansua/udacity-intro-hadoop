package co.gersua.udacity.introhadoop.finalproject.task1;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainTest {

    @Test
    public void doTest() throws Exception {
        String testFileName = MainTest.class.getResource("student_test_posts.csv").getFile();

        BufferedReader br = new BufferedReader(new FileReader(testFileName));

        String line;
        while ((line = br.readLine()) != null) {
            String[] split = line.split("\t");
            System.out.println(split.length);
//            System.out.println(line);
//            System.out.println();
//            System.out.println();
//            System.out.println();
//            System.out.println();
        }
        br.close();
    }
}
