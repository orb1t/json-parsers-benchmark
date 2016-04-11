#!/bin/sh

java -jar target/microbenchmarks.jar ".*bytes.*MainBoonBenchmark.*Catalog"  -wi 3 -i 3 -f 1 -t 8

# for johnzon and profiling use the following (and tweak the agent path according to your installation)
# java -agentpath:/Applications/DevTools/YourKit_Java_Profiler_2014_build_14108.app/Contents/Resources/bin/mac/libyjpagent.jnilib=tracing,disablestacktelemetry,disableexceptiontelemetry -jar target/microbenchmarks.jar ".*string.*MainJohnzonBenchmark.*Catalog" -wi 3 -i 20 -f 0 -t 8