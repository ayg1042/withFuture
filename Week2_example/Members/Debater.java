package Week2_example.Members;

public class Debater extends Member implements Debatable {
    
    public Debater(String name){
        super(name);
    }

    public void work(){
        System.out.println(getName() + "토론 합니다.");
    }

    public void giveArgument(){
        System.out.println(getName() + "님이 주장을 표현합니다.");
    }

}
