package boyerMoore;

public class App {

	public static void main(String[] args) {
		
		String text = "this is my name!";
		String pattern = "name";
		
		BoyerMoore boyerMoore = new BoyerMoore(text, pattern);
		
		boyerMoore.preComputeTable();
		System.out.println(boyerMoore.search());

	}

}
