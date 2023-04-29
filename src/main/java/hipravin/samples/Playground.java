package hipravin.samples;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Playground {
    public static void main(String[] args) {
        Pattern catastrophic = Pattern.compile("^([a-zA-Z0-9]+\\s?)*$");

        String baseString = "some string ";

        for (int i = 500; i <= 510; i++) {
            String testString = baseString.repeat(i);

            Runnable test = () -> {
                Matcher matcher = catastrophic.matcher(testString);
                if (matcher.find()) {
                    System.out.println(" ====================================== " + testString.length());
//                    System.out.println(testString);
                    System.out.println("Matched, g1 = " + matcher.group(1));
                }
            };

            doWithProfiling(i + " times repeat", test);
        }


        System.out.println("Hello world!");
    }

    static void doWithProfiling(String name, Runnable r) {
        long start = System.nanoTime();
        r.run();

        Duration elapsed = Duration.ofNanos(System.nanoTime() - start);
        System.out.println(name + " execution took: " + elapsed);


    }
}