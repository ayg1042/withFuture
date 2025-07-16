package Week2_example.Exp;

public class Athlete extends Person {
    public String team;

    public Athlete(String name, String gender, String team){
        super(name, gender);
        this.team = team;
    }

    public void train(){
        System.out.println(name + " 이 훈련 합니다.");
    }

    @Override
    public void intro(){
        System.out.println("안녕하세요, 저는 " + name + "이고 " + gender + "입니다.");
        System.out.println(team + "에 소속되어 있습니다.");
    }

}
