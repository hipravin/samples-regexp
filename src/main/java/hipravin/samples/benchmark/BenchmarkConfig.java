package hipravin.samples.benchmark;

import org.openjdk.jmh.annotations.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BenchmarkConfig {
    private static final Path resourcesPath = Paths.get("file-lines/src/main/resources");

    @State(Scope.Benchmark)
    public static class ExecutionPlan {

        @Param({"sample-tiny.txt", "sample-medium.txt", "sample-large.txt"})
        public String fileName;

        public Path filePath;

        @Setup(Level.Invocation)
        public void setUp() {
            filePath = resourcesPath.resolve(fileName);
            if (!Files.isRegularFile(filePath)) {
                throw new IllegalStateException("File is not a regular file: " + filePath);
            }
        }
    }



}
