import java.util.ArrayList;
public class TestSearch {
    public static void main(String[] args) {
        Search search = new Search();
        Datastub ds = new Datastub(); // 仮データ
        //Data ds = new Data(); // ファイルからのデータ
        ArrayList<Model> plan = ds.subjects;
        ArrayList<Model> result = search.Makeplans(plan);
        for(var e:result){
            System.out.println(e.name);
        }
    }
}
