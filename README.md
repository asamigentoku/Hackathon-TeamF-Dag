# Hackathon-TeamF-Dag
## チーム開発の手順
### ブランチ作成
まずmainのブランチはマージのみで行いたいので、自分のプログラムを書く際はブランチの作成からお願いします
- git checkout -b [ブランチ名]
ブランチ名はメニューやファイルなど自分がおこなっている作業がわかるものでお願いします
## 自分のブランチに上げる方法
- git add .
- git commit -m "コメント"
- git push origin [ブランチ名]
## 自分のブランチにmainブランチの最新のプログラムを取得
※自分のブランチのコードは無くなってしまうので気をつけてください
- git pull origin main
## mainに自分のプログラムをマージする
- git branch main
- git merge [自分のブランチ名]