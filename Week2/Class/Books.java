package Week2.Class;

import java.util.UUID;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
// key는 java.util.UUID.randomUUID();
public class Books {
    private UUID key;
    private String book_name;
    private String author;
    private String type;

// 입출력시 사용될 항목
// (ex : 책 번호, 책 id, 책 이름, 책 요약 명 등)의 갯수 역시 자유롭게
// 진행하시되 3개 이상 권장

    public Books(){
		this.key = UUID.randomUUID();
	}

	public Books(String[] titles){
		this.key = UUID.randomUUID();
        this.book_name = titles[0];
        this.author = titles[1];
        this.type = titles[2];
	}

	public Books(Books other) {
		this.key = UUID.randomUUID();
		this.book_name = other.book_name;
		this.author = other.author;
		this.type = other.type;
	}

    public void print(){
        System.out.println("Key : " + this.key + ", 제목 : " + this.book_name + ", 제작자 : " + this.author + ", 타입(장르, 종류) : " + this.type);
    }

}
