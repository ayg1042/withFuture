package Week2_example.Exp;

import Week2_example.Exp.National;

public class main {
    public static void main(String[] args) {
        Swimmer player1 = new National("김태환", "남", "SK", "한국");
        ((National)player1).getNumber();
        
        Runner player2 = new National("우사인볼트", "남", "모름", "자메이카");
        ((National)player2).getNumber();


        ((National)player1).intro();
        ((National)player1).train();
        ((National)player1).represent();
        player1.swim();
        player1.dive();

        // player1.run();

        System.out.println("------------");

        ((National)player2).intro();
        ((National)player2).train();
        ((National)player2).represent();
        player2.run();
        player2.sprint();

    }
}
