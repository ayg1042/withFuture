package Week2;

import Week2.Class.BookDeck;

public class main {
    public static void main(String[] args) {
        /*
        1) 전체 조회
        2) key로 조회
        3) 신규 레코드 추가
        4) key를 기반으로 갱신
        5) key를 기반으로 삭제
        */
        Boolean status = true;
        BookDeck bd = new BookDeck();
        while(status){
            switch(bd.main_menu()){
                case "1":
                    bd.show_all();
                    break;
                case "2":
                    bd.find_book();
                    break;
                case "3":
                    bd.add_book();
                    break;
                case "4":
                    bd.update2();
                    break;
                case "5":
                    bd.delete();
                    break;
                case "0":
                    System.out.println("0");
                    status = false;
                    break;
                default:
                    System.out.println("번호 확인하세요");
            }
        }

    }
}
