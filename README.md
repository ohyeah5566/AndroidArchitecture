

寫一些有關Android新技術
===
對於新技術，總是得實際敲一次才能體會箇中奧妙<br/>
但如果每次學新技術都要開新專案...覺得麻煩 <br/>
所以創了一個project 專門拿來學新技術用<br/>
會把一些常用的配置設定放在master 有新的技術要摸就從master切一個branch出來就可以直接開始 

>未來會新增複雜一點的頁面 和 操作<br/>
因為有些新東西 如果在只有一個activity或按鈕搭配textView這種簡單的操作<br/>
學起來是通常不會遇到什麼問題<br/>
不過常常把這新技術套用在複雜一點的專案上的話<br/>
像是mvvm 或 mvp 把邏輯,資料,view 單純的分開沒什麼大問題<br/>
但如果牽扯到recyclerView的adapter 或是 onActivityResult該怎麼處理?<br/>
就有點頭痛了<br/>
所以未來會有一個branch有著複雜點的操作 對新技術有初步了解之後 就可以試著套用在複雜的操作上


學新技術主要會使用new/ 當作branch name 的開頭
---
這時候 有些小東西就比較不會去講究<br/> 
會以了解新技術為主 新東西會附上大量的註解<br/>
讓未來的自己如果忘了的話 可以再回來馬上複習 也不用重頭了解一遍

[new/Jenkins](https://github.com/ohyeah5566/AndroidArchitecture/tree/new/cicd)
CICD<br/>
[new/Hilt](https://github.com/ohyeah5566/AndroidArchitecture/tree/new/hilt)
google基於dagger上出的一款dependency inject套件<br/>
[project/Project Nintendo Amiibo](https://github.com/ohyeah5566/AndroidArchitecture/tree/project/nintendo_amiibo)
利用MVVM+Retrofit+coroutine+Hilt 整合以上套件做的一個小功能<br/>