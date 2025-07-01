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
    int choice = 0;

    public int main_menu(){
        System.out.println("1) 전체 조회\n2) key로 조회\n3) 추가\n4) 수정\n5) 삭제\n0) 종료");
        choice = scan.nextInt();
        System.out.println();
        return choice;
    }

    // 1) 전체 조회
    public void show_all(){
        if (book_list.isEmpty()){
            System.out.println("내용이 없습니다.");
        }else{
            for(Books b : book_list){
                b.print();
            }
        }
    }

    // 2) Key로 조회
    public void find_book(){
        UUID find_id = UUID.fromString(scan.next());
        if (book_list.isEmpty()){
            System.out.println("내용이 없습니다.");
            return ;
        }
        Books book = book_list.stream().filter(b -> b.getKey().equals(find_id)).findFirst().orElse(null);
        if(book != null){
            book.print();
        }else{
            System.out.println("잘못된 Key값 입니다.");
        }
    }

    // 3) 신규 레코드 추가
    public void add_book(){
        System.out.print("책 이름 : ");
        String book_name = scan.next();
        System.out.print("저자 : ");
        String author = scan.next();
        System.out.print("타입(소설, 문학, 등) : ");
        String type = scan.next();
        book_list.add(new Books(author, book_name, type));

    }

    
}
