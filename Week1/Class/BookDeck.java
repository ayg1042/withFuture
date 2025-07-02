package Week1.Class;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import Week1.Class.Books;
    /*
        1) 전체 조회
        2) key로 조회
        3) 신규 레코드 추가
        4) key를 기반으로 갱신
        5) key를 기반으로 삭제
    */
public class BookDeck {
    Scanner scan = new Scanner(System.in);
    ArrayList<Books> book_list = new ArrayList<Books>();
    String choice;
    String[] title = {"책 이름", "저자", "타입"};

    // 초기 데이터 설정 -> 테스트
    public BookDeck(){
        book_list.add(new Books("qqq", "www", "eee"));
        book_list.add(new Books("aaa", "bbb", "ccc"));
    }

    // 메뉴
    public String main_menu(){
        System.out.println("1) 전체 조회\n2) key로 조회\n3) 추가\n4) 수정\n5) 삭제\n0) 종료");
        choice = scan.next();
        System.out.println();
        return choice;
    }

    // 1) 전체 조회
    public void show_all(){
        if (book_list.isEmpty()){
            System.out.println("내용이 없습니다.");
            return ;
        }else{
            for(Books b : book_list){
                b.print();
            }
        }
    }

    // 2) Key로 조회
    public Books find_book(){
        System.out.print("검색할 Key를 입력하세요 : ");
        UUID find_id = UUID.fromString(scan.next());
        if (book_list.isEmpty()){
            System.out.println("내용이 없습니다.");
            return null;
        }
        Books book = book_list.stream().filter(b -> b.getKey().equals(find_id)).findFirst().orElse(null);
        if(book != null){
            book.print();
        }else{
            System.out.println("잘못된 Key값 입니다.");
        }
        return book;
    }

    // 3) 신규 레코드 추가
    public void add_book(){
        String[] titles = new String[title.length];

        for(int i = 0; i < title.length; i++){
            System.out.print(title[i] + " : ");
            titles[i] = scan.next();
        }
        book_list.add(new Books(titles));

    }

    // 수정
    public void update(){
        show_all();
        Books book = find_book();
        if(book != null){
            for(int i = 0; i < title.length; i++){
                System.out.println(title[i] + " 수정 - " + i);
            }
            int number = scan.nextInt();

            switch (number) {
                case 0:
                    System.out.println(title[0] + " 수정합니다. ");
                    System.out.println("기존 : " + book.getBook_name());
                    System.out.print("수정할 내용 : ");
                    book.setBook_name(scan.next());
                    break;
            
                case 1:
                    System.out.println(title[1] + " 수정합니다. ");
                    System.out.println("기존 : " + book.getBook_name());
                    System.out.print("수정할 내용 : ");
                    book.setAuthor(scan.next());
                    break;

                case 2:
                    System.out.println(title[2] + " 수정합니다. ");
                    System.out.println("기존 : " + book.getBook_name());
                    System.out.print("수정할 내용 : ");
                    book.setType(scan.next());
                    break;
            }
        }
    }

    // 삭제
    public void delete(){
        Books book = find_book();
        if(book != null) book_list.remove(book);
        System.out.println("삭제 되었습니다.");
        show_all();
    }

    
}
