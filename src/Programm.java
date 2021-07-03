import java.util.Scanner;

public class Programm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner in = new Scanner(System.in);
       System.out.println("Введите выражение в одну строку:");
       String inStr=in.nextLine();
       try{
       Calc calc= new Calc(inStr);
       System.out.println(calc.calculate());
       }catch (Exception ex) {
    	   System.err.print(ex.getMessage());
       }
       
	}

}
