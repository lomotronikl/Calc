
public class Calc {
	 char[] operations = {'+','-','*','/'}; 
	 
	 Digit firstOper,secondOper,result;
	 char operator;
     public Calc(String str) throws Exception {
    	 
    	 parseInString(str);
     }
     private void parseInString(String str) throws Exception {
    	 
    	 boolean flFind=false;
    	 String firstOperand="";
	     String secondOperand="";

    	 for (char operator : operations){
    		
             int pos=str.indexOf(operator);  
    		 if (pos>=0) {
    			 flFind=true;
    		     
    		     if (pos==0) {
    		    	 // -1
    		    	 throw new Exception("Отсутствует первый операнд"); 
    		     }
    		     if ((pos+1) >= str.length()) {
    		    	 // -2
    		    	 throw new Exception("Отсутствует второй операнд"); 
    		     }
    		     firstOperand=str.substring(0,pos);
    		     secondOperand=str.substring(pos+1);
                 this.operator=operator;
    		     firstOper=new Digit(firstOperand);
    		     secondOper= new Digit(secondOperand);
    		     			 
    			 
    		     if ((firstOper.isArabic()^secondOper.isArabic())) {
    		    	 // not equals; rim arab
    		    	 throw new Exception("Оба операнда должны быть в одном формате"); 
    		     }
    		     
    		     
    			break; 
    	     }
    	 }
    	 if (!flFind) {
    		// operand not found
	    	 throw new Exception("Не найдена операция ( + , - , / , * )"); 
    	    	 
    	 }
    	 
     }
     public String calculate() {
    	 
    	   byte val=0;
    	   switch (operator) {
    	   case '+':{
    		          val=(byte) (firstOper.getValue()+secondOper.getValue());
    	             }break;
    	   case '-':{
		          val=(byte) (firstOper.getValue()-secondOper.getValue());
	             }break;
    	   case '/':{
		          val=(byte) (firstOper.getValue()/secondOper.getValue());
	             }break;
    	   case '*':{
		          val=(byte) (firstOper.getValue()*secondOper.getValue());
	             }break;
    	   }
    	 Digit res= new Digit(val,firstOper.isArabic);
    	 return res.toString();
     }
}
