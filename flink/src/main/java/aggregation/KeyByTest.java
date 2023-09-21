package aggregation;

import POJO.Record;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class KeyByTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Record> record = env.fromElements(
         new Record("lisa",34)
        ,new Record("zhangsan",78)
        ,new Record("bob",12)
        ,new Record("zhangsi",78)
        ,new Record("kak",12)
        );

        record.keyBy(value -> value.name).print();

        env.execute();
    }
}
