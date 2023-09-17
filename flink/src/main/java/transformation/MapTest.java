package transformation;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class MapTest {
    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Integer> element = env.fromElements(1,2,3,4,5);

        element.map(new MapFunction<Integer, Integer>() {

            public Integer map(Integer integer) throws Exception {
                return integer * 2;
            }
        }).print();

        env.execute("map operator examples");
    }
}
