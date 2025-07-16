package Week2_example.Members;

public class Moderator extends Member implements Mderatable {
    
    public Moderator(String name){
        super(name);
    }

    public void work(){
        System.out.println(getName() + "진행 등 안내하기");
    }

    public void startDiscussion(){
        System.out.println(getName() + "님이 토론 시작을 알립니다.");
    }

    public void endDiscussion(){
        System.out.println(getName() + "님이 토론 끝을 알립니다.");
    }

}
