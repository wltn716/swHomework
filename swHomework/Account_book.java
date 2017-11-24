package swHomework;

import java.util.Scanner;

class Account_book {
	String name;
	String date;
	int price;
	int index;
	
	//생성자 - 초기화 수행
	public Account_book(String name, String date, int price, int index) {
		super();
		this.name = name;
		this.date = date;
		this.price = price;
		this.index = index;
	}
	
	//가계부 작성 메소드
	public void write(){
		Scanner write_content = new Scanner(System.in);
		System.out.print("구매한 물품명:");
		this.name = write_content.next();
		System.out.print("구매날짜(ex.170605):");
		this.date = write_content.next();
		System.out.print("구매 가격(ex.1000)(원):");
		this.price = write_content.nextInt();
		this.index++;
	}
	
	
	
	//가계부 수정 메소드
	public void update(){
		Scanner update_content = new Scanner(System.in);
		Scanner update_yes_no = new Scanner(System.in);
		String update_next;
		System.out.println("구매한 물품명: "+this.name+"\t구매 날짜: "+this.date+"\t구매 가격: "+this.price+"\n");
		do{
			System.out.println("수정하고자 하는 내용이 어떤 부분입니까?");
			System.out.print("b1.구매한 물품명\nb2.구매날짜(ex.170605)\nb3.구매 가격\n:");
			String update_num  =update_content.next();
			if(update_num.equals("b1")){
				System.out.print("수정할 물품명을 입력해주세요:");
				this.name = update_content.next();
			}
			else if(update_num.equals("b2")){
				System.out.print("수정할 구입 날짜를 입력해주세요:");
				this.date = update_content.next();
			}
			else if(update_num.equals("b3")){
				System.out.print("수정할 구매가격을 입력해주세요:");
				this.price = update_content.nextInt();
			}
			System.out.println("\n구매한 물품명: "+this.name+"\t구매 날짜: "+this.date+"\t구매 가격: "+this.price+"\n");
			System.out.println("더 수정하실 내용이 있습니까?");
			System.out.println("a.예\tb.아니오\n:");
			update_next = update_yes_no.next();
		}while(update_next.equals("a"));
	}
	
	//가계부 삭제 메소드
	public void delete(Account_book[] account_book, int last){
		for(int i=this.index;i<last;i++){
			account_book[i] = account_book[i+1];
		}
	}
	
	//가계부 리스트 출력
	static public void account_list_print(Account_book[] account_book,int last){
		if(account_book[0].name!=null){
			System.out.println("   \t물품명\t날짜\t가격");
			for(int i=0;i<last;i++){
				System.out.println("["+(i+1)+"]\t"+account_book[i].name+"\t"+account_book[i].date+"\t"+account_book[i].price+"\t\n");
			}
		}else
			System.out.println("작성된 가계부가 없습니다.\n");
		System.out.println("a.가계부 작성\nb.가계부 수정\nc.가계부 삭제\nd.돌아가기");
	}

}
