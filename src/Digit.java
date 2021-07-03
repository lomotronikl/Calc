
public class Digit {
	private String[]  rimDigits = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
	private byte value=0;
	boolean isArabic=false;
     public Digit(String str) throws Exception {
    	 str=str.trim();
    	 
    	 boolean found=false;
    	 try
    	 {
    		 value=Byte.valueOf(str);
    		 isArabic=true;
    		 found=true;
    	 }
    	 catch (NumberFormatException ex) {
    		 
    	 }
    	 if (!isArabic) {
    	   for (int i=0;i<rimDigits.length;i++)
    	   {
    		   if (str.equals(rimDigits[i])) {
    			   value=(byte)( i+1);
    			   found=true;
    			   break;
    		   }
    	   }
    	 }//if (!isArabic 
    	 
    	 if (!found) {
    		 
    		throw new Exception("Не смог перевести из строки в число:"+str); 
    	 }
    	 if ((value<1)|(value >10)) {
    			throw new Exception(value+ " не входит в диапазон допустимых значений 1..10");
    	 }
     }
     public Digit(byte val, boolean isArabic) {
    	 value=val;
    	 this.isArabic=isArabic;
     }
     public boolean isArabic() {
    	 return isArabic;
     }
     public byte getValue() {
    	 return value;
     }
     public String toString() {
    	 if (isArabic) {
    		 return String.valueOf(value);
    	 }
    	 else {
    		  String[]  ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    		  String[]  tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    		  String[] hunds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    		 
    		  String h= hunds[(value / 100) %10];
    		  String t= tens[(value / 10) %10];
    		  String o= ones[(value %10)];
    		  if (value==0) {o="в римской записи 0 отсутствует";}
    		 return h+t+o;
    	 }
     }
     
}
