package swHomework;

import java.util.Scanner;

class Calculator{
	
	String selected;
	float result;
	
	public static void print_list(Calculator[] cal) {
		for(int i=0; i<cal.length; i++)
			System.out.println("nothing\n");
	}
	
	public void calculating() {
		if (this.selected.equals("a")) {
			execArithmetic();
		}
		else {
			execTransform();
		}		
	}
	
	public void execArithmetic() {
		
		Scanner scanner = new Scanner(System.in);
		Arithmetic arm = new Arithmetic();
		String operator="";
		
		System.out.println("원하는 수를 입력하세요");
		arm.operand_1 = scanner.nextInt();
		
		System.out.println("a. +(plus)");
		System.out.println("b. -(minus)");
		System.out.println("c. *(multiply)");
		System.out.println("d. /(divide)");
		operator = scanner.next();
		
		System.out.println("원하는 수를 입력하세요");
		arm.operand_2 = scanner.nextInt();
		
		if(operator.equals("a") || operator.equals("+")) {
			this.result = arm.add();
			operator = "+";
		}
		else if(operator.equals("b") || operator.equals("-")) {
			this.result = arm.subtract();
			operator = "-";
		}
		else if(operator.equals("c")|| operator.equals("*")) {
			this.result = arm.multiply();
			operator = "*";
		}
		else if(operator.equals("d")|| operator.equals("/")) {
			this.result = arm.divide();
			operator = "/";
		}
		else {
			System.out.println("잘못된 값을 입력하셨습니다.");
		}
			
		System.out.println(arm.operand_1+operator+arm.operand_2+"="+this.result);
		
	}
	
	public void execTransform() {
		Scanner scanner = new Scanner(System.in);
		Transformation trnf = new Transformation();
		System.out.println("원하는 수를 입력하세요");
		trnf.number = scanner.nextInt();
		String unitOfResult="";
		System.out.println("a. pound");
		System.out.println("b. kg");
		System.out.println("c. inch");
		System.out.println("d. cm");
		System.out.println("e. °F");
		System.out.println("f. °C");
		trnf.unit = scanner.next();
		
		if(trnf.unit.equals("a") ||trnf.unit.equals("b") ) {
			if(trnf.unit.equals("a")) {
				trnf.unit = "pound";
				unitOfResult = "kg";
			}
			else {
				trnf.unit = "kg";
				unitOfResult = "pound";
			}
			this.result = trnf.poundKg();
		}
		else if(trnf.unit.equals("c") || trnf.unit.equals("d")) {
			if(trnf.unit.equals("c")) {
				trnf.unit = "inch";
				unitOfResult = "cm";
			}
			else {
				trnf.unit = "cm";
				unitOfResult = "inch";
			}
			this.result = trnf.inchCm();
		}
		else if(trnf.unit.equals("e") || trnf.unit.equals("f")) {
			if(trnf.unit.equals("e")) {
				trnf.unit = "fahrenheit";
				unitOfResult = "°C";
			}
			else {
				trnf.unit = "celsius";
				unitOfResult = "°F";
			}
			this.result = trnf.fC();
		}
		else {
			System.out.println("잘못된 값을 입력하셨습니다.");
		}
		System.out.println(this.result+unitOfResult);
	}
}

class Arithmetic {
	
	int operand_1, operand_2; //사칙연산의 대상이 될 두개의 수

	public int add(){ // 덧셈을 수행하는 메소드
		return operand_1+operand_2;
	}

	public int subtract(){ // 뺄셈을 수행하는 메소드 
		return operand_1-operand_2;
	}

	public int multiply(){ // 곱셈을 수행하는 메소드 
		return operand_1*operand_2;
	}

	public int divide(){ //나눗셈을 수행하는 메소드 
		return operand_1/operand_2;
	}
}

class Transformation{
	float number; //변환할 값
   	String unit;
	
	public float poundKg(){
		if(unit.equals("pound")) number *= 0.453592;
		else number *= 2.204623;
		return number;
	} 
   	public float inchCm(){
   		if(unit.equals("inch")) number *= 2.54;
		else number *= 0.393701;
   		return number;
   	}
   	public float fC(){
   		if(unit.equals("fahrenheit")) number *= -17.222222;
		else number *= 33.8;
   		return number;
   	}
}
