package resources.spellsitout;

public class NumberTranslation {
	
	private final static String[] UNITS = {
			"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"
	};
	
	private final static String[] DOZENS = {
			"","","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"
	};
	
	private final static String ZERO = "zero";
	private final static String ONE_BILLION = "one billion";
	private final static String HUNDRED = "hundred";
	private final static String THOUSAND = "thousand";
	private final static String MILLION = "million";
	private final static String SPACE = " ";
	private final static String MINUS = "-";
	
	private int minValue = 0;
	private int maxValue = 1000000000;
	private int nten = 10;
	private int ntwenty = 20;
	private int nhundred = 100;
	private int nthousand = 1000;
	private int nmillion = 1000000;

	
	public String translateNumbers(int n){
		String nStr = "";
		
		if(n == minValue){
			nStr = ZERO;
		}else if(n == maxValue) {
			nStr = ONE_BILLION;
		}else if(n < ntwenty){
			nStr = UNITS[n];
		}else if(n < nhundred){
			nStr = getDozens(n);
		}else if(n < nthousand){
			nStr = getHundreds(n);
		}else if(n < nmillion){
			if(n % nthousand != 0)
				nStr = getHundreds(n/nthousand) + SPACE + THOUSAND + SPACE + translateNumbers(n%nthousand);
			else
				nStr = getHundreds(n/nthousand) + SPACE + THOUSAND;
		}else{
			if(n % nmillion != 0)
				nStr = getHundreds(n/nmillion) + SPACE + MILLION + SPACE + translateNumbers(n%nmillion);
			else
				nStr = getHundreds(n/nmillion) + SPACE + MILLION;
		}
		
		return nStr;
	}
	
	private String getDozens(int n) {
		String nStr ="";
		int auxDiv = n/nten, rest = n%nten;

		if(auxDiv != 0){
			nStr = DOZENS[auxDiv];
		}
		
		if(rest != 0 && n > ntwenty){
			nStr += MINUS + UNITS[rest];
		}else if(n < ntwenty){
			if(!nStr.equals(""))
				nStr += SPACE + UNITS[n];
			else 
				nStr += UNITS[n];
		}
		
		return nStr;
	}
	
	private String getHundreds(int n) {
		String nStr="";
		int auxDiv = n/nhundred, rest = n%nhundred;

		if(auxDiv != 0)
			nStr += UNITS[auxDiv] + SPACE + HUNDRED;
		if(rest != 0){
			if(!nStr.equals(""))
				nStr += SPACE + getDozens(rest);
			else
				nStr += getDozens(rest);
		}
		return nStr;
	}
}