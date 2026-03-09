import java.util.ArrayList;
public class Search {
    //必修の授業を出力
    ArrayList<Model> FileterRequired(ArrayList<Model> datas) {
            ArrayList<Model> result = new ArrayList<>();
                for(var e:datas){
                    if(e.required){
                        result.add(e);
                }
            }
        return result;
    }
    ArrayList<Model> Makeplans(ArrayList<Model> datas) {
            ArrayList<Model> result = new ArrayList<>();
        return result;
    }
}
