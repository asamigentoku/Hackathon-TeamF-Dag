import java.util.Scanner;

public class Menu {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        //Datastub ds = new Datastub(); // 仮データ
        Data data = new Data(); // ファイルからのデータ

        while(true){

            System.out.println("===== 履修管理メニュー =====");
            System.out.println("1: 授業一覧");
            System.out.println("2: 検索");
            System.out.println("3: 自動時間割作成");
            System.out.println("4: 授業登録");
            System.out.println("5: 登録授業削除");
            System.out.println("6: 終了");
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

                for(Model m : data.subjects){

                    String type;

                    if(m.required){
                        type="必修";
                    } else{
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

                System.out.println("検索方法を選んでください");
                System.out.println("1: 授業名検索");
                System.out.println("2: 曜日＋時限検索");
                System.out.print("番号を入力してください: ");

                int searchType = scanner.nextInt();
                scanner.nextLine();

                if(searchType == 1){

                    System.out.print("検索する授業名を入力してください: ");
                    String keyword = scanner.nextLine();

                    boolean found = false;

                    for(Model m : data.subjects){
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

                }else if(searchType == 2){

                    System.out.print("曜日を入力してください (月 火 水 木 金): ");
                    String day = scanner.nextLine();

                    System.out.print("時限を入力してください: ");
                    int period = scanner.nextInt();

                    Search s = new Search();
                    var result = s.FilterDayPeriod(data.subjects, day, period);

                    if(result.size() == 0){
                        System.out.println("授業が見つかりませんでした");
                    }

                    for(Model m : result){
                        String type = m.required ? "必修" : "選択";

                        System.out.println(
                                m.name + " " +
                                m.day + " " +
                                m.period + "限 " +
                                m.credit + "単位 " +
                                type
                        );
                    }
                }

            }else if(choice == 3){

                Search s = new Search();
                var bestPlan = s.Makeplans(data.subjects);

                System.out.println("おすすめ時間割");

                for(Model m : bestPlan){
                    String type = m.required ? "必修" : "選択";

                    System.out.println(
                            m.name + " " +
                            m.day + " " +
                            m.period + "限 " +
                            m.credit + "単位 " +
                            type
                    );
                }

            }else if(choice == 4){

                System.out.print("登録したい授業のIDを入力してください: ");
                int id = scanner.nextInt();

                boolean found = false;

                for(Model m : data.subjects){
                    if(m.id == id){
                        data.Myplans.add(m);
                        data.Write();
                        System.out.println("授業を登録しました: " + m.name);

                        System.out.println("現在登録されている授業:");
                        for(Model p : data.Myplans){
                            System.out.println(p.id + " " + p.name + " " + p.day + " " + p.period + "限");
                        }
                        found = true;
                        break;
                    }
                }

                if(!found){
                    System.out.println("そのIDの授業は存在しません");
                }

            }else if(choice==5){

                System.out.println("現在登録されている授業:");
                for(Model p : data.Myplans){
                    System.out.println(p.id + " " + p.name + " " + p.day + " " + p.period + "限");
                }

                System.out.print("削除したい授業のIDを入力してください: ");
                int id = scanner.nextInt();

                boolean found = false;

                for(int i = 0; i < data.Myplans.size(); i++){
                    Model m = data.Myplans.get(i);

                    if(m.id == id){
                        data.Myplans.remove(i);
                        System.out.println("授業を削除しました: " + m.name);

                        System.out.println("現在登録されている授業:");
                        for(Model p : data.Myplans){
                            System.out.println(p.id + " " + p.name + " " + p.day + " " + p.period + "限");
                        }
                        found = true;
                        break;
                    }
                }

                if(!found){
                    System.out.println("登録されている授業にそのIDはありません");
                }

            }else if(choice == 6){

                System.out.println("プログラムを終了します");
                break;
            }

        }
        scanner.close();
    }
}