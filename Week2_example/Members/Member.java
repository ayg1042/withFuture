package Week2_example.Members;

abstract class Member {
    
    private String name;

    public Member(String name){
        this.name = name;
    }

    public void talk(){
        System.out.println(name + "님이 말합니다.");
    }

    abstract void work();

    public String getName(){
        return this.name;
    }
}
