package Week2_example.Exp;

public class Person {
    public String name;
    public String gender;
    static int number = 0;
    {
        number += 1;
    }

    public Person(String name, String gender){
        this.name = name;
        this.gender = gender;
    }

    public void eat(){
        System.out.println(name + "이(가) 식사를 합니다.");
    }

    public void intro(){
        System.out.println("안녕하세요, 저는 " + name + "이고 " + gender + "입니다.");
    }

    protected void getNumber(){
        System.out.println(number + " 명 있습니다.");
    }

}
