# Coroutine(Kotlin)

---

용어 정리

- blocking

```java
var data = getData() // 1
println(data)// 2
```

1. 데이터를 반환하는 함수의 리턴값을 변수에 할당.
2. 데이터를 사용할 수 있게 되면 데이터가 출력됨.

데이터를 완전히 얻을 때 까지 프로그램이 멈추게 된다 (1~2 사이) 이를 **블로킹작업**이라고 한다.

- 병렬성 : 코딩을 하면서 음악을 듣기 (’손’과 ‘귀’을 동시에 사용) - 멀티코어 프로세서의 멀티스레드
- 동시성 : 코딩을 하면서 과자를 먹기 (손을 ‘키보드’와 ‘과자’에 사용) - 코루틴

## 1. Coroutine이란?

- 애플리케이션을 개발하는 동안 네트워크, 데이터베이스호출 또는 복잡한 계산, api호출, 데이터 다운로드 등등..과 같이 긴 시간에 걸쳐 작업을 수행해야하는 상황이 자주 발생할때 사용한다.
- 백그라운드에서 또는 비동기적으로 위와같은 작업이 시행되게 할 수 있음. → 사용자를 기다리게 하지 않고 웹(앱)을 사용할 수 있게해준다

cf.) Java의 Thread, C#의 async/await

## 2. Coroutine builders

- Scope

|  | CoroutineScope | GlobalScope |
| --- | --- | --- |
| runBlocking | 최상위함수 | 최상위함수 |
| launch | 확장함수 | 확장함수(권장x) |
| async | 확장함수 | 확장함수(권장x) |
- CoroutineScope : 다른 상태를 공유하기 위해 사용한다.
    - CoroutineStart - DEFAULT, LAZY, ATOMIC, UNDISPATCHED
    

---

1. runBlocking
    - 명령줄 검증, 테스트에 유용하다.
    - 현재 스레드를 block하고 모든 내부 코루틴이 종료될때 까지 블록한다.
    - signiture
        
        ```java
        fun <T> runBlocking(block: suspend CoroutineScope.() -> T): T
        ```
        
2. launch
    - 독립된 프로세스 실행, 해당 코루틴에서 리턴값을 받을 필요가 없을 때 유용
    - CoroutineScope의 확장함수이기때문에 CoroutineScope이 사용 가능한 경우에만 사용가능
    - 코루틴 취소가 필요할 때 사용할 수 있는 Job인스턴스를 리턴한다.
    - signiture
        
        ```java
        fun CoroutineScope.launch(
        	context: CoroutineContext = EmptyCoroutineContext,
        	start: CoroutineStart = CoroutineStart.DEFAULT,
        	block: suspend CoroutineScope.() -> Unit
        ): Job
        ```

3. async
        - 리턴값이 필요할 때 유용 → await() 을 붙힌 갚이 리턴값이다.
        - signiture
            
            ```java
            fun <T> CoroutineScope.async(
            	context: CoroutineContext = EmptyCoroutineContext,
            	start: CoroutineStart = CoroutineStart.DEFAULT,
            	block: suspend CoroutineScope.() -> T
            ): Deferred<T>
            ```
            
        - 리턴값인 Deferred<T>는 생산된 값을 리턴하기 전에 코루틴이 완료될때 까지 기다리는 await함수이다.

---

## 3. Suspend Function

> 실행을 잠시 중단하고 자신의 작업을 끝내면 중단했던 작업을 계속 할 수 있는 함수
> 

```java
suspend fun thisIsSuspend(arg: String) : Boolean{
	//~~
}
```

코루틴은 적어도 한 개 이상의 suspend 함수를 필요로 한다.

## 4. 연습

- 아래와 같은 함수를 코루틴을 이용해서 요청시간을 단축시켜보려고 한다.

```kotlin
private fun first() : Long{
    println("1st function started")
    Thread.sleep(1000L)
    println("1st function ended")
    return 1L
}

private fun second(num : Long) : String{
    println("2nd function started")
    Thread.sleep(2000L)
    println("2nd function ended")

    if(num != 1L){
        return "no"
    }

    return "2"
}

private fun third(str: String) : Boolean{
    println("3rd function started")
    Thread.sleep(1500L)
    println("3rd function ended")

    return str === "2"
}

fun main(){
    val startTime = System.currentTimeMillis()

    val firstVal = first()
    val secondVal = second(firstVal)
    println(third(secondVal))

    println(System.currentTimeMillis() - startTime)
}
```

- launch
- async

- Dispatcher의 범위
    - Default :
    - Main
    - Unconfined
    - IO
    - custom도 가능

[동작원리](https://www.notion.so/f7be32bdf38e402b983e6a66a8f3aa63)

---

참고자료 : 

코틀린 쿡북

코틀린 동시성 프로그래밍

[https://www.youtube.com/watch?v=lmRzRKIsn1g](https://www.youtube.com/watch?v=lmRzRKIsn1g)

[https://webcache.googleusercontent.com/search?q=cache:wB0yjshjhe0J:https://codechacha.com/ko/android-coroutine/+&cd=17&hl=ko&ct=clnk&gl=kr](https://webcache.googleusercontent.com/search?q=cache:wB0yjshjhe0J:https://codechacha.com/ko/android-coroutine/+&cd=17&hl=ko&ct=clnk&gl=kr)
