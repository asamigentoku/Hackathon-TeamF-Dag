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
    //選択の授業を出力
    ArrayList<Model> FileterNoequired(ArrayList<Model> datas) {
            ArrayList<Model> result = new ArrayList<>();
                for(var e:datas){
                    if(!e.required){
                        result.add(e);
                }
            }
        return result;
    }
    //特定の曜日の授業を出力
    ArrayList<Model> FileterDay(ArrayList<Model> datas,String day){
        ArrayList<Model> result = new ArrayList<>();
        for(var e:datas){
            if(e.day.equals(day)){
                result.add(e);
            }
        }
        return result;
    }
    //曜日と時限で授業を検索
    ArrayList<Model> FilterDayPeriod(ArrayList<Model> datas, String day, int period){
        ArrayList<Model> result = new ArrayList<>();

        for(var e : datas){
            if(e.day.equals(day) && e.period == period){
                result.add(e);
        }
    }

        return result;
    }
    //特定の曜日の授業の評価
    int score(ArrayList<Model> plans){
        int credit=0;
        for(var e:plans){
            credit+=e.credit;
        }
        return credit;
    }

    //授業AとBが衝突しないか
    // 授業が衝突するか
    boolean conflict(Model a,Model b){

        if(!a.day.equals(b.day)){
            //もし曜日が地がければ大丈夫
            return false;
        }

        int aStart = a.period;//3
        int aEnd = a.period + a.length - 1;//3

        int bStart = b.period;//4
        int bEnd = b.period + b.length - 1;//4
        //条件通りであれば両方trueでfalseを返すが
        //どちらかでもfalseであればその授業は追加できない

        return !(aEnd < bStart || bEnd < aStart);
    }

    //その授業が追加できるか
    boolean valid(ArrayList<Model> plan,Model newClass){

        for(Model m : plan){
            if(conflict(m,newClass)){
                return false;
            }
        }

        return true;
    }

    //DFS探索
    void dfs(int index,ArrayList<Model> datas,ArrayList<Model> current,ArrayList<Model> bestPlan){
        //bestの引数は参照渡し
        if(index == datas.size()){
            if(score(current) > score(bestPlan)){
                bestPlan.clear();
                bestPlan.addAll(current);
            }
            return;
        }
        var newclass=datas.get(index);
        if(newclass.required){
            current.add(newclass);
            dfs(index+1,datas,current,bestPlan);
            current.remove(current.size()-1);   
        } else {
            //今の授業を追加する場合
            if(valid(current,newclass)){
                current.add(newclass);
                //授業をもう一つ追加してそれをベストなものとする
                dfs(index+1,datas,current,bestPlan);
                //もしここでベストなものがあった、ベストが更新されている
                //今追加した授業を取り消して元の状態に戻す
                current.remove(current.size()-1);
            }
            //今の授業を追加しない場合
            //次の探索を現在のbestとcurrentの比較
            dfs(index+1,datas,current,bestPlan);
        }
    }




    //特定の曜日の授業を最適化
    ArrayList<Model> MaximizeDay(ArrayList<Model> datas){
        ArrayList<Model> best = new ArrayList<>();
        dfs(0,datas,new ArrayList<>(),best);
        return best;
    }


    ArrayList<Model> Makeplans(ArrayList<Model> plan) {
            ArrayList<Model> result = new ArrayList<>();
            String[] days = {"月","火","水","木","金"};
            for(var e:days){
                var dayplan = FileterDay(plan,e);
                var best = MaximizeDay(dayplan);
                result.addAll(best);
            }
            return result;
    }
}
            //アキコマを作らない
            //全休を作りたい
