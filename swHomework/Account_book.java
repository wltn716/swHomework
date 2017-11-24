import java.util.Scanner;

public class Account_book {
	String name;
	String date;
	int price;
	int index;
	
	static int last_index=0;
	
	//������ - �ʱ�ȭ ����
	public Account_book(String name, String date, int price, int index) {
		super();
		this.name = name;
		this.date = date;
		this.price = price;
		this.index = index;
	}
	
	//����� �ۼ� �޼ҵ�
	public void write(){
		Scanner write_content = new Scanner(System.in);
		System.out.print("������ ��ǰ��:");
		this.name = write_content.next();
		System.out.print("���ų�¥(ex.170605):");
		this.date = write_content.next();
		System.out.print("���� ����(ex.1000)(��):");
		this.price = write_content.nextInt();
		this.index++;
	}
	
	
	
	//����� ���� �޼ҵ�
	public void update(){
		Scanner update_content = new Scanner(System.in);
		Scanner update_yes_no = new Scanner(System.in);
		String update_next;
		System.out.println("������ ��ǰ��: "+this.name+"\t���� ��¥: "+this.date+"\t���� ����: "+this.price+"\n");
		do{
			System.out.println("�����ϰ��� �ϴ� ������ � �κ��Դϱ�?");
			System.out.print("b1.������ ��ǰ��\nb2.���ų�¥(ex.170605)\nb3.���� ����\n:");
			String update_num  =update_content.next();
			if(update_num.equals("b1")){
				System.out.print("������ ��ǰ���� �Է����ּ���:");
				this.name = update_content.next();
			}
			else if(update_num.equals("b2")){
				System.out.print("������ ���� ��¥�� �Է����ּ���:");
				this.date = update_content.next();
			}
			else if(update_num.equals("b3")){
				System.out.print("������ ���Ű����� �Է����ּ���:");
				this.price = update_content.nextInt();
			}
			System.out.println("\n������ ��ǰ��: "+this.name+"\t���� ��¥: "+this.date+"\t���� ����: "+this.price+"\n");
			System.out.println("�� �����Ͻ� ������ �ֽ��ϱ�?");
			System.out.println("a.��\tb.�ƴϿ�\n:");
			update_next = update_yes_no.next();
		}while(update_next.equals("a"));
	}
	
	//����� ���� �޼ҵ�
	public void delete(Account_book[] account_book, int last){
		for(int i=this.index;i<last;i++){
			account_book[i] = account_book[i+1];
		}
	}
	
	//����� ����Ʈ ���
	static public void account_list_print(Account_book[] account_book){
		if(account_book[0].name!=null){
			System.out.println("   \t��ǰ��\t��¥\t����");
			for(int i=0;i<last_index;i++){
				System.out.println("["+(i+1)+"]\t"+account_book[i].name+"\t"+account_book[i].date+"\t"+account_book[i].price+"\t\n");
			}
		}else
			System.out.println("�ۼ��� ����ΰ� �����ϴ�.\n");
		System.out.println("a.����� �ۼ�\nb.����� ����\nc.����� ����\nd.���ư���");
	}
	
	public static void main(String[] args) {
		int i=0,update_index,delete_index;
		Scanner scan = new Scanner(System.in);
		Account_book[] account_book = new Account_book[100];
		account_book[0] = new Account_book(null,null,0,0);
		
		account_list_print(account_book);
		
		while(true){
			System.out.print("���ϴ� �۾��� �Է����ּ���:");
			String input = scan.next();
			System.out.println();
			
			if(input.equals("a")){
				if(i==0){
					account_book[i].write();
				}
				else{
					account_book[i] = new Account_book(null,null,0,0);
					account_book[i].write();
				}
				i++;last_index++;
				account_list_print(account_book);
			}
			else if(input.equals("b")){
				System.out.print("�����ϰ��� �ϴ� ����� ��ȣ�� �Է��ϼ���:");
				update_index = scan.nextInt();
				account_book[update_index-1].update();
				account_list_print(account_book);
			}
			else if(input.equals("c")){
				System.out.println("�����ϰ��� �ϴ� ����� ��ȣ�� �Է��ϼ���:");
				delete_index = scan.nextInt();
				account_book[delete_index-1].delete(account_book,last_index);
				last_index--;
				account_list_print(account_book);
			}
			else if(input.equals("d"))
				break;
		}
	}

}
