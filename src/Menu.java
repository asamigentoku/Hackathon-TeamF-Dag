import java.util.Scanner;

public class Menu {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        //Datastub ds = new Datastub(); // 仮データ
        Data ds = new Data(); // ファイルからのデータ

        while(true){

            System.out.println("===== 履修管理メニュー =====");
            System.out.println("1: 授業一覧");
            System.out.println("2: 検索");
            System.out.println("3: 終了");
            System.out.print("番号を入力してください: ");

            int choice;

            if(scanner.hasNextInt()){
                  choice = scanner.nextInt();
                    } else {
                    System.out.println("番号を入力してください");
                    scanner.next();
                    continue;
                    }
             

            if(choice == 1){

                System.out.println("********授業一覧********");
                System.out.printf("%-3s %-20s %-3s %-4s %-4s %-4s\n",
                            "ID", "授業名", "曜", "時限", "単位", "区分");
                System.out.println("----------------------------------------");

                for(Model m : ds.subjects){

                    String type;

                    if(m.required){
                        type="必修";
                    }
                else{
                    type = "選択";
                }
                    System.out.printf("%-3d %-20s %-3s %-4d %-4d %-4s\n",
                        m.id,
                        m.name,
                        m.day,
                        m.period,
                        m.credit,
                        type
                    );
                }

            }else if(choice == 2){

                System.out.print("検索する授業名を入力してください: ");
                scanner.nextLine(); 
                String keyword = scanner.nextLine();

                boolean found = false;

                for(Model m : ds.subjects){
                    if(m.name.contains(keyword)){
                        System.out.println(
                            m.name + " " +
                            m.day + " " +
                            m.period + "限 " +
                            m.credit + "単位"
                        );
                        found = true;
                    }
                }

                if(!found){
                    System.out.println("授業が見つかりませんでした");
                }

            }else if(choice == 3){

                System.out.println("プログラムを終了します");
                break;

            }else{

                System.out.println("正しい番号を入力してください");

            }

        }

        scanner.close();
    }
}