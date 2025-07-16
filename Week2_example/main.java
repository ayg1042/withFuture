package Week2_example;

import Week2_example.Members.Debater;
import Week2_example.Members.Moderator;

public class main {
    public static void main(String[] args) {
        
        Moderator mt = new Moderator("이");
        Debater de = new Debater("김");

        mt.work();
        de.work();

        mt.talk();
        mt.talk();

        mt.startDiscussion();
        de.giveArgument();
        mt.endDiscussion();

    }

    static void print(){
        System.out.println("오버로딩 파라미터 값 없음");
    }

    static void print(String a){
        System.out.println("오버로딩 파라미터 값 String : "  + a + " 1개");
    }

    static void print(int a){
        System.out.println("오버로딩 파라미터 값 int : " + a + " 1개");
    }

    static void print(String a, int b){
        System.out.println("오버로딩 파라미터 값 String : " + a + " int : " + b + " 2개");
    }



}
