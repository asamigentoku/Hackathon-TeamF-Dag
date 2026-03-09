import java.util.Scanner;

public class Menu {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        Datastub ds = new Datastub(); // 仮データ

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

                for(Model m : ds.subjects){
                    System.out.println(
                        m.id + " " +
                        m.name + " " +
                        m.day + " " +
                        m.period + "限 " +
                        m.credit + "単位"
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