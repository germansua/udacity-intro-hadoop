package co.gersua.udacity.introhadoop.task2.part2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {

    @Test
    public void someTest() {
        List<String> lines = Arrays.asList(
                "10.223.157.186 - - [15/Jul/2009:14:58:59 -0700] \"GET / HTTP/1.1\" 403 202",
                "10.223.157.186 - - [15/Jul/2009:14:58:59 -0700] \"GET /favicon.ico HTTP/1.1\" 404 209",
                "10.223.157.186 - - [15/Jul/2009:15:50:35 -0700] \"GET / HTTP/1.1\" 200 9157",
                "10.223.157.186 - - [15/Jul/2009:15:50:35 -0700] \"GET /assets/js/lowpro.js HTTP/1.1\" 200 10469",
                "10.223.157.186 - - [15/Jul/2009:15:50:35 -0700] \"GET /assets/css/reset.css HTTP/1.1\" 200 1014",
                "10.223.157.186 - - [15/Jul/2009:15:50:35 -0700] \"GET /assets/css/960.css HTTP/1.1\" 200 6206",
                "10.223.157.186 - - [15/Jul/2009:15:50:35 -0700] \"GET /assets/css/the-associates.css HTTP/1.1\" 200 15779");

        Pattern pattern = Pattern.compile("[0-9]{1,3}[\\.][0-9]{1,3}[\\.][0-9]{1,3}[\\.][0-9]{1,3}");
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}
