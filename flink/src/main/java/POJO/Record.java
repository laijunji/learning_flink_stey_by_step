package POJO;

public class Record {
    public String name;
    public Integer ts;
    public Record() {}
    public Record(String name, Integer ts) {
        this.name = name;
        this.ts = ts;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "name:" + this.name + " " + "ts:" + this.ts;
    }
}
