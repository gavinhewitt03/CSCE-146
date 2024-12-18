/*
 * Gavin Hewitt
 */
public class Tester {
	public static void main(String[] args)
	{
		VideoGameLL test = new VideoGameLL();
		test.readFile("./Collection.txt");
		//test.print();
		VideoGameLL searchResults = new VideoGameLL();
		
		/*
		test.search("*", "nintendo entertainment system", searchResults);
		System.out.println("----------------------------------------");
		searchResults.print();
		*/
		
		
		test.search("mega",  "nintendo entertainment system", searchResults);
		System.out.println("----------------------------------------");
		searchResults.print();
		
		searchResults.writetoFile("./Test.txt", false);
		
		System.out.println("----------------------------------------");
		
		test.search("*", "super nintendo", searchResults);
		System.out.println("----------------------------------------");
		searchResults.print();
		
		searchResults.writetoFile("./Test.txt", true);
		
		System.out.println("----------------------------------------");
		searchResults.clear();
		searchResults.print();
		System.out.println(searchResults.getSize());
	}
}
