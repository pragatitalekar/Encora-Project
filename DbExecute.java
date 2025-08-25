package aug20;

public class DbExecute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		DbOperations.displayInfo();
		
		int ts = 0;
		ts += DbOperations.insertInfo(9, "watch", 1400);
		ts += DbOperations.insertInfo(10, "printer", 2000);
		if(ts > 0) {
			System.out.println(ts+ " rows are added in the table");
		}
		else {
			System.out.println("No rows are affected and insertion operation did not execute");
		}
		

//		System.out.println(ts+ " rows are added successfully");
		
		
		int dr = 0;
		dr += DbOperations.deleteQry("watch");
		dr += DbOperations.deleteQry("printer");
		if(dr > 0) {
			System.out.println(dr+ " rows are deleted from the table");
		}
		else {
			System.out.println("No rows are affected and delete operation did not execute");
		}

	}

}
