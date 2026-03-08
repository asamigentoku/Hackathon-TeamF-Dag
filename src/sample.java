
import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String name;
    int credit;

    Course(String name, int credit) {
        this.name = name;
        this.credit = credit;
    }
}

class sample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Course> courses = new ArrayList<>();  //subject names
        courses.add(new Course("アルゴリズム",2));
        courses.add(new Course("データサイエンス",2));
        courses.add(new Course("AI基礎",2));
        courses.add(new Course("Java",2));
        courses.add(new Course("データーベース",2));



        while (true) {

            System.out.println("===== 履修管理メニュー =====");   //main menu
            System.out.println("1: 授業追加");
            System.out.println("2: 授業一覧");
            System.out.println("3: 検索");
            System.out.println("4: 終了");

            System.out.print("番号を入力してください: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("授業追加機能（まだ未実装）");

            } else if (choice == 2) {

                System.out.println("********授業一覧********）");
                for (Course c : courses){
                    System.out.println("授業名: " + c.name + "/ 単位: " + c.credit);
                }

            } else if (choice == 3) {
                System.out.println("検索機能（まだ未実装）");

            } else if (choice == 4) {
                System.out.println("プログラムを終了します");
                break;

            } else {
                System.out.println("正しい番号を入力してください");
            }

        }

        scanner.close();
    }
}