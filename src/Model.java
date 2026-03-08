public class Model {
    int id;
    String name;
    String day;
    int period;
    int credit;
    boolean required;
    Model(int id,String name,String day,int period,int credit,boolean required){
        this.id=id;
        this.name=name;
        this.day=day;
        this.period=period;
        this.credit=credit;
        this.required=required;
    }
}
