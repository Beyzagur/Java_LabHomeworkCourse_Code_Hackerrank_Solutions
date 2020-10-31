public class Main {
	//The function that converts the two-dimensional array into a list.
	public static void list(int[][] matrix, MultiLinkedList list)
	{
		for (int i = 0; i < matrix.length; i++) {
			list.addRow(Integer.toString(i+1));
			
			for (int j = 0; j < matrix[i].length; j++) {
				list.addElement(Integer.toString(i+1), matrix[i][j]);
			}
		}
	}
	
	public static void main(String[] args) {
		
		MultiLinkedList mll=new MultiLinkedList();
		MultiLinkedList mll1=new MultiLinkedList();
		MultiLinkedList mll2=new MultiLinkedList();
		MultiLinkedList mll3=new MultiLinkedList();
		
		int[][] matrix = {{55,0,0,0,0},
						  {0,55,0,0,0},
						  {0,0,55,0,0},
						  {0,0,0,55,0},
						  {0,0,0,0,55}};
		
		int[][] matrix1 = {{18,0,0,0},
						   {0,18,0,0},
						   {0,0,18,0},
						   {0,0,0,18}};
		
		int[][] matrix2 = {{6,0,0,0,0,0},
						   {0,6,0,0,0,0},
						   {0,0,6,0,0,5},
						   {0,0,0,6,0,0},
						   {0,0,0,0,6,0},
						   {0,0,0,0,0,6}};
		
		int[][] matrix3 = {{6,0,0,0,0,0},
				  		   {0,6,0,0,0,0},
				  		   {0,0,6,0,0,0},
				  		   {0,0,0,6,0,0},
				  		   {0,0,0,0,7,0},
				  		   {0,0,0,0,0,6}};

		list(matrix,mll);//The two-dimensional array and the object of the Multi-Link List are sent to the function.
		mll.display();//The list is displayed on the screen.
		System.out.println("Is the matrix scalar?");
		System.out.println("Output: "+mll.control());//The result of the list check is displayed on the screen.
		System.out.println();
		
		list(matrix1,mll1);
		mll1.display();
		System.out.println("Is the matrix scalar?");
		System.out.println("Output: "+mll1.control());
		System.out.println();
		
		list(matrix2,mll2);
		mll2.display();
		System.out.println("Is the matrix scalar?");
		System.out.println("Output: "+mll2.control());
		System.out.println();
		
		list(matrix3,mll3);
		mll3.display();
		System.out.println("Is the matrix scalar?");
		System.out.println("Output: "+mll3.control());

	}

}
