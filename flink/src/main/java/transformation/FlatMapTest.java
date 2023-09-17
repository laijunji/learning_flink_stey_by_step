package transformation;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class FlatMapTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> elements = env.fromElements("a b c","a c d","k f c");

        elements.flatMap(new FlatMapFunction<String, String>() {

            /**
             * @param s
             * @param out
             * @throws Exception
             */
            public void flatMap(String s, Collector<String> out) throws Exception {
                for(String e: s.split(" ")){
                    out.collect(e);
                }
            }
        }).print();

        env.execute();
    }
}
