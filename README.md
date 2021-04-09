

在MVP架構中 使用lifecycle
===
在一些異步耗時的情況下
使用者可能會沒耐心的把app關閉

那如果App沒特別做處理，在異步耗時完成後後面有跟view做互動
輕則在其他地方 突然跳出Toast
重則可能會產生crash (如果是show dialog的話

所以需要一個方法讓presenter知道view 已經被destroyed了
最簡單就是在Activity的onDestroy call presenter做清理的動作
但如果要在onDestroy做清理的數量變多 就會變得不好維護

所以就有了lifecycle產生
透過addObserver 和 annotation的方式
可以讓需要特別針對生命週期做處理的物件 專注在要做的事情上

```Kotlin
class Presenter : LifecycleObserver //implement LifecycleObserver 
//加入觀察者
fun observeLifecycle(lifecycle:Lifecycle){
    lifecycle.addObserver(this)
}
//在觀察的view的狀態是ON_DESTROY 執行下面的function
@OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
fun cleanUp() {
    println("presenter cleanUp")
    view = null
}
```