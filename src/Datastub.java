import java.util.ArrayList;

public class Datastub {
    ArrayList<Model> subjects = new ArrayList<>();
    Datastub(){
            subjects.add(new Model(1,"プログラミング基礎","月",1,2,true));
            subjects.add(new Model(2,"プログラミング応用","月",2,2,true));
            subjects.add(new Model(3,"データ構造","月",3,2,true));
            subjects.add(new Model(4,"アルゴリズム","月",4,2,true));
            subjects.add(new Model(5,"離散数学","月",5,2,false));
            subjects.add(new Model(6,"線形代数","火",1,2,false));
            subjects.add(new Model(7,"微分積分","火",2,2,false));
            subjects.add(new Model(8,"確率統計","火",3,2,false));
            subjects.add(new Model(9,"情報数学","火",4,2,false));
            subjects.add(new Model(10,"数値計算","火",5,2,false));
            subjects.add(new Model(11,"コンピュータ基礎","水",1,2,true));
            subjects.add(new Model(12,"オペレーティングシステム","水",2,2,true));
            subjects.add(new Model(13,"コンピュータアーキテクチャ","水",3,2,true));
            subjects.add(new Model(14,"コンパイラ","水",4,2,false));
            subjects.add(new Model(15,"並列処理","水",5,2,false));
            subjects.add(new Model(16,"データベース基礎","木",1,2,true));
            subjects.add(new Model(17,"データベース応用","木",2,2,false));
            subjects.add(new Model(18,"コンピュータネットワーク","木",3,2,true));
            subjects.add(new Model(19,"情報セキュリティ","木",4,2,true));
            subjects.add(new Model(20,"クラウドコンピューティング","木",5,2,false));
            subjects.add(new Model(21,"人工知能","金",1,2,false));
            subjects.add(new Model(22,"機械学習","金",2,2,false));
            subjects.add(new Model(23,"深層学習","金",3,2,false));
            subjects.add(new Model(24,"画像処理","金",4,2,false));
            subjects.add(new Model(25,"自然言語処理","金",5,2,false));
            subjects.add(new Model(26,"ソフトウェア工学","月",6,2,true));
            subjects.add(new Model(27,"プロジェクト演習","火",6,2,true));
            subjects.add(new Model(28,"ヒューマンインタフェース","水",6,2,false));
            subjects.add(new Model(29,"情報倫理","木",6,2,true));
            subjects.add(new Model(30,"卒業研究","金",6,4,true));
    }
}
