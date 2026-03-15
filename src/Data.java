import java.util.ArrayList;



public class Data { 
    ArrayList<Model> subjects = new ArrayList<>();
    ArrayList<Model> Myplans = new ArrayList<>();
    Data(){
        ReadFile rf = new ReadFile();
        //現在のディレクトリを取得
        String currentDir = System.getProperty("user.dir");
        //一個上にする
        String parentDir = currentDir + "/..";
        String inputPath = parentDir+ "/public/data.txt";
        //データを読み込んで
        subjects = rf.read(inputPath);
        String userPath = parentDir + "/public/user.txt";
        Myplans = rf.read(userPath);
        //そのデータを書き込む
    }
    void Write(){
        //現在のディレクトリを取得
        String currentDir = System.getProperty("user.dir");
        //一個上にする
        String parentDir = currentDir + "/..";
        String outputPath = parentDir + "/public/data.txt";
        WriteFile wf = new WriteFile();
        wf.write(outputPath,subjects);
        String userPath = parentDir + "/public/user.txt";
        wf.write(userPath,Myplans);
    }
    void ShowMyplans() {
        String[] days = {"月","火","水","木","金"};
        String[][] table = new String[5][5]; // [曜日][時限]
        // 初期化
        for(int d=0; d<5; d++)
            for(int p=0; p<5; p++)
                table[d][p] = "----";

        // 授業を配置
        for(Model m : Myplans){
            int dayIndex = -1;
            for(int i=0;i<days.length;i++){
                if(days[i].equals(m.day)){
                    dayIndex = i;
                    break;
                }
            }
            if(dayIndex != -1 && m.period >=1 && m.period <=5){
                table[dayIndex][m.period-1] = m.name;
            }
        }

        // 全角を考慮して文字列右にスペースを追加する関数
        // widthは表示幅（半角換算）
        java.util.function.BiFunction<String, Integer, String> padRight = (s, width) -> {
            int len = 0;
            for (char c : s.toCharArray()) {
                if (c >= 0x2E80) len += 2; // 全角文字なら2文字分
                else len += 1;             // 半角文字なら1文字分
            }
            int pad = Math.max(0, width - len);
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < pad; i++) sb.append(" ");
            return sb.toString();
        };

        int colWidth = 18; // 列幅（半角換算）

        // ヘッダ
        System.out.print("+");
        for(int i=0;i<5;i++) System.out.print("-".repeat(colWidth) + "+");
        System.out.println();

        System.out.print("|");
        for(String d : days) System.out.print(padRight.apply(d, colWidth) + "|");
        System.out.println();

        System.out.print("+");
        for(int i=0;i<5;i++) System.out.print("-".repeat(colWidth) + "+");
        System.out.println();

        // 時限表示
        for(int p=0; p<5; p++){
            System.out.print("|");
            for(int d=0; d<5; d++){
                System.out.print(padRight.apply(table[d][p], colWidth) + "|");
            }
            System.out.println();

            System.out.print("+");
            for(int i=0;i<5;i++) System.out.print("-".repeat(colWidth) + "+");
            System.out.println();
        }
    }
}
