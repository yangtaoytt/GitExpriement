package problem2_3;

public class Student implements Comparable<Student>{
    public String name;
    public String id;
    public boolean gender;
    public String Class;

    public double sumScore;

    public double points;

    @Override
    public int compareTo(Student o) {//实现排序接口
        if(this.Class==o.Class)
            return Double.compare(this.sumScore,o.sumScore);
        else
            return this.Class.compareTo(o.Class);
    }
}
