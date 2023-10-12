package source;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class ReadTextFileTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment().setParallelism(1);

        DataStream<String> record = env.readTextFile("/Users/laijunji/github/learning_flink_stey_by_step/flink/src/main/java/source/data.txt");

        SingleOutputStreamOperator<Tuple2<String,Integer>> record_tuple = record.map(new MapFunction<String, Tuple2<String,Integer>>() {
            @Override
            public Tuple2<String,Integer> map(String s) throws Exception {
                return new Tuple2<>(String.valueOf(s.charAt(s.length() - 1)),1);
            }
        });

        record_tuple.keyBy(value -> value.f0).sum(1).print();

        env.execute();
    }
}
