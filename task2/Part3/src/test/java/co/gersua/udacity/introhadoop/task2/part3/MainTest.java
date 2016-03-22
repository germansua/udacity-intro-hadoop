package co.gersua.udacity.introhadoop.task2.part3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {

    private static final Pattern pattern = Pattern.compile("([/][\\w\\-]+)+/[\\w-]+\\.[\\w0-9]{2,6}");

    @Test
    public void testStuff() {

        List<String> lines = Arrays.asList(
                "10.223.157.186 - - [15/Jul/2009:14:58:59 -0700] \"GET / HTTP/1.1\" 403 202",
                "10.223.157.186 - - [15/Jul/2009:14:58:59 -0700] \"GET /favicon.ico HTTP/1.1\" 404 209",
                "10.223.157.186 - - [15/Jul/2009:15:50:35 -0700] \"GET / HTTP/1.1\" 200 9157",
                "10.223.157.186 - - [15/Jul/2009:15:50:35 -0700] \"GET /assets/js/lowpro.js HTTP/1.1\" 200 10469",
                "10.223.157.186 - - [15/Jul/2009:15:50:35 -0700] \"GET /assets/css/reset.css HTTP/1.1\" 200 1014",
                "10.223.157.186 - - [15/Jul/2009:15:50:35 -0700] \"GET /assets/css/960.css HTTP/1.1\" 200 6206",
                "10.223.157.186 - - [15/Jul/2009:15:50:35 -0700] \"GET /assets/css/the-associates.css HTTP/1.1\" 200 15779",
                "10.223.157.186 - - [15/Jul/2009:15:50:35 -0700] \"GET /assets/js/the-associates.js HTTP/1.1\" 200 4492",
                "10.223.157.186 - - [15/Jul/2009:15:50:35 -0700] \"GET /assets/js/lightbox.js HTTP/1.1\" 200 25960",
                "10.223.157.186 - - [15/Jul/2009:15:50:36 -0700] \"GET /assets/img/search-button.gif HTTP/1.1\" 200 168",
                "10.223.157.186 - - [15/Jul/2009:15:50:36 -0700] \"GET /assets/img/dummy/secondary-news-3.jpg HTTP/1.1\" 200 5604",
                "10.223.157.186 - - [15/Jul/2009:15:50:36 -0700] \"GET /assets/img/dummy/primary-news-1.jpg HTTP/1.1\" 200 10556",
                "10.223.157.186 - - [15/Jul/2009:15:50:36 -0700] \"GET /assets/img/dummy/primary-news-2.jpg HTTP/1.1\" 200 9925",
                "10.223.157.186 - - [15/Jul/2009:15:50:36 -0700] \"GET /assets/img/closelabel.gif HTTP/1.1\" 200 979",
                "10.223.157.186 - - [15/Jul/2009:15:50:36 -0700] \"GET /assets/img/home-logo.png HTTP/1.1\" 200 3892",
                "10.223.157.186 - - [15/Jul/2009:15:50:36 -0700] \"GET /assets/img/dummy/secondary-news-2.jpg HTTP/1.1\" 200 5397",
                "10.223.157.186 - - [15/Jul/2009:15:50:36 -0700] \"GET /assets/img/loading.gif HTTP/1.1\" 200 2767",
                "10.223.157.186 - - [15/Jul/2009:15:50:36 -0700] \"GET /assets/img/dummy/secondary-news-4.jpg HTTP/1.1\" 200 5766",
                "10.223.157.186 - - [15/Jul/2009:15:50:36 -0700] \"GET /assets/img/home-media-block-placeholder.jpg HTTP/1.1\" 200 68831",
                "10.223.157.186 - - [15/Jul/2009:15:50:37 -0700] \"GET /assets/img/dummy/secondary-news-1.jpg HTTP/1.1\" 200 5766",
                "10.223.157.186 - - [15/Jul/2009:15:50:37 -0700] \"GET /assets/swf/home-media-block.swf HTTP/1.1\" 200 123884"
        );

        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}
