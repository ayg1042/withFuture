package Week2_example;

public class Throw {
    public static void main(String[] args) {
        final int test1 = 5;
        final int test2;

        test2 = 3;

        System.out.println(test1);
        System.out.println(test2);
        
        int a = 1;
        int b = 1;

        int c;

        c = Exception_throw_thorws(a, b);

        try {
            c = Exception_throw_thorws(a, b);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }


        // Ethrow();

        // try{
        //     Ethrows();
        // }catch(Exception e){
        //     System.out.println(e);
        // }

        // throw new Exception();
        // int i = 0;

        System.out.println(ad(1,2));

    }

    public static int ad(int a, int b){
        return a+b;
    }


    public static int Exception_throw_thorws(int a, int b) throws ArithmeticException{
        if(b <= 0){
            throw new ArithmeticException("0나누기 안됨");
        }
        return a/b;
    }

    public static void Ethrow(){
        
        try{
            throw new Exception("Ethrow 에러 발생");
        }catch(Exception e){
            System.out.println(e);
            System.out.println("throw 에러 발생시키기");
        }

    }

    public static void Ethrows() throws Exception{

        throw new Exception("throws 에러 발생");

    }

}
