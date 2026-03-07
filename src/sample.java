import java.util.Scanner;

class sample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("===== 履修管理メニュー =====");
            System.out.println("1: 授業追加");
            System.out.println("2: 授業一覧");
            System.out.println("3: 検索");
            System.out.println("4: 終了");

            System.out.print("番号を入力してください: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("授業追加機能（まだ未実装）");

            } else if (choice == 2) {
                System.out.println("授業一覧機能（まだ未実装）");

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