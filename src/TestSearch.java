import java.util.ArrayList;

public class TestSearch {
    public static void main(String[] args) {
        Search search = new Search();
        //Datastub ds = new Datastub(); // 仮データ
        var ds = new Data(); // ファイルからのデータ
        ArrayList<Model> plan = ds.subjects;
        System.err.println(plan.size());
        ArrayList<Model> result = search.Makeplans(plan);
        System.err.println(result.size());
        for(var e:result){
            System.out.println(e.name);
            System.out.println(e.day);
            System.out.println(e.period);
        }
    }
}
