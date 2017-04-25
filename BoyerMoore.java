package boyerMoore;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {
	
	private String text;
	private String pattern;
	private Map<Character, Integer> mismatchTable;
	
	public BoyerMoore(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
		this.mismatchTable = new HashMap<>();
	}
	
	public void preComputeTable() {
		
		int lengthOfPattern = pattern.length();
		
		for(int i = 0; i < lengthOfPattern; i++) {
			
			char actualCharacter = pattern.charAt(i);
			int maxShift = Math.max(1, lengthOfPattern - i - 1); 
			mismatchTable.put(actualCharacter, maxShift);
			
		}
	}
	
	public int search() {
		
		int lengthOfText = this.text.length();
		int lengthOfPattern = this.pattern.length();
		int numOfSkips;
		
		for(int i = 0; i <= lengthOfText - lengthOfPattern; i += numOfSkips) {
			
			numOfSkips = 0;
			
			for(int j = lengthOfPattern - 1; j > 0; j--) {
				if(pattern.charAt(j) != text.charAt(i+j)) {
					if(this.mismatchTable.get(pattern.charAt(j)) != null ) {
						numOfSkips = mismatchTable.get(pattern.charAt(j));
						break;
					}
					else {
						numOfSkips = lengthOfPattern;
						break;
					}
				}
			}
			if(numOfSkips == 0)
				return i;
		}
		return lengthOfText;
	}
}
