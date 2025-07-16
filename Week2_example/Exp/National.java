package Week2_example.Exp;

public class National extends Athlete implements Swimmer, Runner {
    public String country;
    
    public National(String name, String gender, String team, String country){
        super(name, gender, team);
        this.country = country;
    }

    @Override
    public void swim(){
        System.out.println("수영 합니다.");
    }
    @Override
    public void dive(){
        System.out.println("다이빙 합니다.");
    }
    @Override
    public void run(){
        System.out.println("달리기 합니다.");
    }
    @Override
    public void sprint(){
        System.out.println("전력질주 합니다.");
    }

    public void represent(){
        System.out.println(country + " 대표 입니다.");
    }

}
