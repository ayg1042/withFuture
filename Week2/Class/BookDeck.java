package Week2.Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Scanner;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import Week2.Class.Books;
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
        String[] test1 = {"책1", "작성자1", "소설"};
        String[] test2 = {"책2", "작성자2", "국문학"};
        String[] test3 = {"책3", "작성자3", "영문학"};
        book_list.add(new Books(test1));
        book_list.add(new Books(test2));
        book_list.add(new Books(test3));
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
            // 기존 코든
            // for(Books b : book_list){
            //     b.print();
            // }
            book_list.stream().forEach(b -> b.print());
        }
    }

    // 2) Key로 조회
    public Books find_book(){
        Books book = null;
        if (book_list.isEmpty()){
            System.out.println("내용이 없습니다.");
            return null;
        }
        
        System.out.print("검색할 Key를 입력하세요 : ");
        try{
            UUID find_id = UUID.fromString(scan.next());
            book = book_list.stream().filter(b -> b.getKey().equals(find_id)).findFirst().orElse(null);
        }catch (IllegalArgumentException e){
            System.out.println("Key 형식을 확인하세요.");
            return null;
        }

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

        // 기존 코드
        // for(int i = 0; i < title.length; i++){
        //     System.out.print(title[i] + " : ");
        //     titles[i] = scan.next();
        // }

        IntStream.range(0, title.length).forEach( i -> {
            System.out.println(title[i] + " : ");
            titles[i] = scan.next();
        });

        // 2week _ 수정
        // book_list.add(new Books(titles));

        // steam으로 변경을 해서
        // 값을 추가하고 다시 book_list로 변환
        book_list = Stream.concat(
            book_list.stream(), 
            Stream.of(new Books(titles))
            )
            .collect(Collectors.toCollection(ArrayList::new));

    }

    // 수정
    // 2week _ 수정
    public void update(){
        show_all();
        boolean check = false;
        Books book = find_book();
        if(book != null){
            while(!check){
                // 기존 코드
                // for(int i = 0; i < title.length; i++){
                //     System.out.println(title[i] + " 수정 - " + i);
                // }

                IntStream.range(0, title.length).forEach(i -> {
                    System.out.println(title[i] + " 수정 - " + i);
                });

                System.out.println("돌아가기. 3");
                String number = scan.next();
    
                switch (number) {
                    case "0":
                        System.out.println(title[0] + " 수정합니다. ");
                        System.out.println("기존 : " + book.getBook_name());
                        System.out.print("수정할 내용 : ");
                        book.setBook_name(scan.next());
                        break;
                
                    case "1":
                        System.out.println(title[1] + " 수정합니다. ");
                        System.out.println("기존 : " + book.getAuthor());
                        System.out.print("수정할 내용 : ");
                        book.setAuthor(scan.next());
                        break;
    
                    case "2":
                        System.out.println(title[2] + " 수정합니다. ");
                        System.out.println("기존 : " + book.getType());
                        System.out.print("수정할 내용 : ");
                        book.setType(scan.next());
                        break;
                    case "3":
                        System.out.println("메뉴로 돌아갑니다.");
                        check = true;
                    default:
                        System.out.println("번호를 확인하세요.");
                }
            }
        }else{
            System.out.println("Key값을 확인하세요.");
        }
    }

    public void update2(){
        show_all();
        Books uda = find_book();
        ArrayList<Consumer<String>> test = new ArrayList<>();
        test.add(uda::setBook_name);
        test.add(uda::setAuthor);
        test.add(uda::setType);
        
        IntStream.range(0, title.length).forEach(
            i -> 
            {
                System.out.println("수정할 내용 " + title[i]);
                test.get(i).accept(scan.next());
            }
        );

    }

    // 삭제
    // 2week _ 수정
    // 다시 진행.
    // booklist -> Steam으로 해서
    // 삭제해서 booklist로 다시 만들기.
    public void delete(){
        Books book = find_book();
        if(book != null){
            // 2주차 수정내용
            // book_list.remove(book);

            book_list = book_list.stream()
                .filter(a -> a != book)
                .collect(Collectors.toCollection(ArrayList::new));


            System.out.println("삭제 되었습니다.");
        }else{
            System.out.println("Key값을 확인하세요.");
        }
        show_all();
    }

    
}
