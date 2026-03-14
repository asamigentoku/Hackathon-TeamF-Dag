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
        //そのデータを書き込む
    }
    void Write(){
        //現在のディレクトリを取得
        String currentDir = System.getProperty("user.dir");
        //一個上にする
        String parentDir = currentDir + "/..";
        String outputPath = parentDir + "/public/write.txt";
        WriteFile wf = new WriteFile();
        wf.write(outputPath,subjects);
    }
}
