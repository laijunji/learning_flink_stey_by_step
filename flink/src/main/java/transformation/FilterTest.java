package transformation;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FilterTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Integer> elements = env.fromElements(1,2,3,4,5);

        elements.filter(new FilterFunction<Integer>() {
            public boolean filter(Integer num) throws Exception {
                return num % 2 == 0 ? false : true;
            }
        }).print();

        env.execute();
    }
}
