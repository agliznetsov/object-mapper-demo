package demo.mapper;

import java.io.IOException;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;


public class JmhRunner {

    public static void main(String[] args) throws IOException, RunnerException {
        ChainedOptionsBuilder options = new OptionsBuilder()
                .include(MappingFrameworksPerformance.class.getName())
                .forks(0)
                .warmupIterations(1)
                .warmupTime(TimeValue.seconds(1))
                .measurementIterations(1)
                .measurementTime(TimeValue.seconds(5));
        Runner runner = new Runner(options.build());
        runner.run();
    }

}
