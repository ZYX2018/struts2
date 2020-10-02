package po;

public class People {
    private String name;
    private String  sex;


    public String getName() {
        return name; }

    public void setName(String name) {
        this.name = name; }

    public String getSex() {
        return sex; }

    public void setSex(String sex) { this.sex = sex;
    }

    public  String save(){
        System.out.println("输入"+this);
        return "people";
    }
    @Override
    public String toString() {
        return "people{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
