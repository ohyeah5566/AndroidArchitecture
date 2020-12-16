
jenkins

一開始的建立jenkins環境 都是靠這篇
https://medium.com/evan-android-note/jenkins-bb11f371bcb6

不過第一次build就失敗了XDDD
一開始是github專案和branch的沒設定好
要在專案的source code management
設定 URL = https://github.com/ohyeah5566/AndroidArchitecture.git (.git要加
branch是 new/cicd 或是any

後來
遇到的是了gradle 6.1.1需要JAVA 8才能的問題
一開始以為是android studio的java XD
之後還是built失敗才 發現是要到Global Tool Configuration設定jenkins的JDK
總之就安裝JDK到電腦上 再設定JAVA_HOME就解決了

有plugin可以只打oracle的帳號密碼 就讓jenkins自己安裝jdk
不過懶申請帳號所以就算了

後來第一次成功built專案

因為第一篇教學是讓專案十分鐘自己built一次
比較理想的是git push一次就built一次

這邊要修改專案的configure 在Build Triggers
要改選Github hook trigger for GITScm polling
然後到github的頁面 修改webHooks
不過這時候的jenkins都是建立在localhost的狀態下
所以github的webHooks不能設定 localhost
這時候要透過ngrok 讓localhost可以對應一個public的地址
可以參考以下這篇
https://zoejoyuliao.medium.com/%E9%80%8F%E9%81%8E-github-webhook-%E8%A7%B8%E7%99%BC%E6%9C%AC%E5%9C%B0-jenkins-pipeline-%E8%AE%93%E4%BD%A0-push-code-%E5%88%B0-github-%E5%B0%B1%E6%9C%83%E8%87%AA%E5%8B%95%E8%B7%91-ci-cd-7c4bd7a22446
設定之後的url 會長這樣
https://d7b0ce13953a.ngrok.io/github-webhook/

這樣下push指令時 jenkins就會幫你built專案了







