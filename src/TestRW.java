//このファイルでデータの書き込み、読み込み等が行われます
import java.util.List;
public class TestRW {
    public static void main(String[] args) {
        ReadFile rf = new ReadFile();
        WriteFile wf = new WriteFile();
        //現在のディレクトリを取得
        String currentDir = System.getProperty("user.dir");
        //一個上にする
        String parentDir = currentDir + "/..";
        String inputPath = parentDir+ "/public/data.txt";
        String outputPath = parentDir + "/public/write.txt";
        //データを読み込んで
        List<Model> list = rf.read(inputPath);
        //そのデータを書き込む
        wf.write(outputPath,list);
    } 
}
