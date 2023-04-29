package hipravin.samples;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaygroundWW {
    public static void main(String[] args) {
        Pattern wwPattern = Pattern.compile("^(.*)\\1$");

        String baseString = "some string ";

        for (int i = 50000; i <= 50010; i++) {
            String testString = baseString.repeat(i);

            Runnable test = () -> {
                Matcher matcher = wwPattern.matcher(testString);
                System.out.println(" ====================================== " + testString.length());

                if (matcher.find()) {
                    System.out.println("Matched");
                } else {
                    System.out.println("Not matched");
                }
            };

            doWithProfiling(i + " times repeat", test);
        }
    }

    static void doWithProfiling(String name, Runnable r) {
        long start = System.nanoTime();
        r.run();

        Duration elapsed = Duration.ofNanos(System.nanoTime() - start);
        System.out.println(name + " execution took: " + elapsed);


    }
}