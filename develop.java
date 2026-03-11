import java.util.ArrayList;
import java.util.Random;

class Model {
    int id;
    String name;
    String day;
    int period;
    int length;
    int credit;
    boolean required;

    public Model(int id, String name, String day, int period, int length, int credit, boolean required) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.period = period;
        this.length = length;
        this.credit = credit;
        this.required = required;
    }

    @Override
    public String toString() {
        return id + ": " + name + " (" + day + period + "限, " + credit + "単位, 必修:" + required + ")";
    }
}

class Datastub {
    ArrayList<Model> subjects = new ArrayList<>();

    Datastub() {

        subjects.add(new Model(1,"プログラミング基礎","月",1,2,2,true));
        subjects.add(new Model(2,"プログラミング応用","月",3,2,2,true));
        subjects.add(new Model(3,"データ構造","火",1,2,2,true));
        subjects.add(new Model(4,"アルゴリズム","火",3,2,2,true));
        subjects.add(new Model(5,"線形代数","水",1,2,2,false));
        subjects.add(new Model(6,"微分積分","水",3,2,2,false));
        subjects.add(new Model(7,"確率統計","木",1,2,2,false));
        subjects.add(new Model(8,"人工知能","金",1,2,2,false));
        subjects.add(new Model(9,"機械学習","金",3,2,2,false));
        subjects.add(new Model(10,"深層学習","金",5,2,2,false));
        subjects.add(new Model(11,"心理学","月",5,1,1,false));
        subjects.add(new Model(12,"哲学","火",5,1,1,false));
        subjects.add(new Model(13,"社会学","水",5,1,1,false));
        subjects.add(new Model(14,"経済学","木",5,2,2,false));
        subjects.add(new Model(15,"法学","金",5,2,2,false));
        subjects.add(new Model(16,"英語Ⅰ","月",2,1,1,true));
        subjects.add(new Model(17,"英語Ⅱ","水",2,1,1,true));
        subjects.add(new Model(18,"中国語","木",2,1,1,false));
        subjects.add(new Model(19,"ソフトウェア工学","月",6,2,2,true));
        subjects.add(new Model(20,"プロジェクト演習","火",6,2,2,true));
        subjects.add(new Model(21,"卒業研究","金",6,4,4,true));

        String[] names = {
            "プログラミング基礎","プログラミング応用","アルゴリズム","データ構造",
            "オペレーティングシステム","コンピュータネットワーク","データベース",
            "データベース応用","コンピュータアーキテクチャ","コンパイラ",
            "並列処理","分散システム","クラウドコンピューティング",
            "ソフトウェア工学","ソフトウェア設計","テスト工学",
            "人工知能","機械学習","深層学習","画像処理",
            "自然言語処理","音声処理","ロボティクス",
            "ヒューマンインタフェース","情報検索","データマイニング",
            "ビッグデータ解析","情報セキュリティ","暗号理論",
            "線形代数","微分積分","確率統計","離散数学",
            "数値計算","最適化理論","グラフ理論","数理論理",
            "ゲーム理論","応用数学",
            "心理学","哲学","社会学","経済学",
            "英語Ⅰ","英語Ⅱ","中国語Ⅰ","中国語Ⅱ",
            "歴史学","日本史","世界史"
        };

        String[] days = {"月","火","水","木","金"};
        Random rand = new Random();

        for(int i = 22; i <= 500; i++){
            String name = names[rand.nextInt(names.length)] + i;
            String day = days[rand.nextInt(days.length)];
            int period = rand.nextInt(6) + 1;
            int length = rand.nextInt(2) + 1;
            int credit = length;
            boolean required = rand.nextInt(5) == 0;

            subjects.add(new Model(i, name, day, period, length, credit, required));
        }
    }
}

class Search {

    ArrayList<Model> FilterRequired(ArrayList<Model> datas) {
        ArrayList<Model> result = new ArrayList<>();
        for (var e : datas) {
            if (e.required) {
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

public class Main {
    public static void main(String[] args) {

        Datastub ds = new Datastub();
        Search sc = new Search();

        System.out.println("=== 全科目（最初の30件） ===");
        for (int i = 0; i < 30; i++) {
            System.out.println(ds.subjects.get(i));
        }

        System.out.println("\n=== 必修科目（最初の20件） ===");
        var required = sc.FilterRequired(ds.subjects);
        for (int i = 0; i < 20; i++) {
            System.out.println(required.get(i));
        }
    }
}
