package POJO;

public class Record {
    public String name;
    public Integer ts;
    public Record() {}
    public Record(String name, Integer ts) {
        this.name = name;
        this.ts = ts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", ts=" + ts +
                '}';
    }
}
