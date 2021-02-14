package hello.core.singleton;

public class SingletonService {
    //1. static 영역에 객체를 미리 하나 생성해서 올려둠
    private static final SingletonService instance = new SingletonService();
    //2. 오직 getInstance() 메서드를 통해서만 조회
    public static SingletonService getInstance(){
        return  instance;
    }
    //3. 생성자를 private로 막아서 new 로 못만들게 막음
    private SingletonService(){

    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출 ");
    }
}
