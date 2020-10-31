public class MainManager{

	SingleLinkedList sll1 = new SingleLinkedList();
	SingleLinkedList sll2 = new SingleLinkedList();
	SingleLinkedList sll3 = new SingleLinkedList();

	public void screen() {
		System.out.print("sll1:");
		sll1.display();
		System.out.print("\nsll2:");
		sll2.display();
		System.out.print("\nsll3:");
		sll3.display();
		System.out.println("\n");
	}
	
	public void user(int count) {
		if(count%2==1) {
			System.out.println("User 1");
		}
		else {
			System.out.println("User 2");
		}
		
	}
	public MainManager()
	{
		int count=1;
		boolean run=true;
		while (run) {
		
			int place = (int) (Math.random() * 3);//0-1-2 is randomly selected. To select one from 3 lists.
			int num = (int) ((Math.random() * 5) + 1);//1-2-3-4-5 is randomly selected.
			

			if (place == 0 && sll1.size1() != 8) {//if place equals zero and sll1 is not size 8.
				user(count);
				sll1.insert(num);
				screen();
				
				//horizontal row control
				if(sll1.size1()>2) {//If the size of sll1 is greater than 2
					//ascending order from left to right(123)
					if(((int)sll1.getElement(sll1.size1()-1)) == ((int)sll1.getElement(sll1.size1()))-1) {
						if(((int)sll1.getElement(sll1.size1()-2)) == ((int)sll1.getElement(sll1.size1()-1)-1)) {  
							run=false;
						}		
					}
					//descending row from left to right (321)
					else if(((int)sll1.getElement(sll1.size1()-1)) == ((int)sll1.getElement(sll1.size1()))+1) {
						if(((int)sll1.getElement(sll1.size1()-2)) == ((int)sll1.getElement(sll1.size1()-1))+1) {
							run=false;
						}
					}
				}				
				
				//cross control from top right to bottom left
				if(sll1.size1()>2 && sll2.size1()>1 && sll3.size1()>0 && sll2.size1()>=sll1.size1()-1 && sll3.size1()>=sll1.size1()-2) {
					// increased sequence control
					if(((int)sll1.getElement(sll1.size1())) == ((int)sll2.getElement(sll1.size1()-1)-1)) {
						if(((int)sll2.getElement(sll1.size1()-1)) ==((int)sll3.getElement(sll1.size1()-2)-1)) {
							run = false;
						}
					}
					//descending order control
					if(((int)sll1.getElement(sll1.size1())) == ((int)sll2.getElement(sll1.size1()-1)+1)) {
						if(((int)sll2.getElement(sll1.size1()-1)) ==((int)sll3.getElement(sll1.size1()-2)+1)) {
							run = false;
						}
					}
				}
				//cross control from top left to bottom right
				if(sll1.size1()>0 && sll2.size1()>1 && sll3.size1()>2 && sll2.size1()>=sll1.size1()+1 && sll3.size1()>=sll1.size1()+2) {
					// increased sequence control
					if(((int)sll1.getElement(sll1.size1())) == ((int)sll2.getElement(sll1.size1()+1)-1)) {
						if(((int)sll2.getElement(sll1.size1()+1)) ==((int)sll3.getElement(sll1.size1()+2)-1)) {
							run = false;
						}
					}
					//descending order control
					if(((int)sll1.getElement(sll1.size1())) == ((int)sll2.getElement(sll1.size1()+1)+1)) {
						if(((int)sll2.getElement(sll1.size1()+1)) ==((int)sll3.getElement(sll1.size1()+2)+1)) {
							run = false;
						}
					}	
				}
				//control downwards
				if(sll1.size1()>0 && sll2.size1()>=sll1.size1() && sll3.size1()>=sll1.size1())
				{//increased sequence control
					if(((int)sll1.getElement(sll1.size1())) == ((int)sll2.getElement(sll1.size1())-1)) {
						if(((int)sll2.getElement(sll1.size1())) ==((int)sll3.getElement(sll1.size1())-1)) {
							run = false;
						}
					}//descending order control
					else if(((int)sll1.getElement(sll1.size1())) == ((int)sll2.getElement(sll1.size1())+1)) {
						if(((int)sll2.getElement(sll1.size1())) ==((int)sll3.getElement(sll1.size1())+1)) {
							run = false;
						}
					}	
				}	
				count++;

			}
			
			else if (place == 1 && sll2.size1() != 8) {//if place equals zero and sll2 is not size 8.
				user(count);
				sll2.insert(num);
				screen();
				
				//horizontal row control
				if(sll2.size1()>2) {//If the size of sll2 is greater than 2
					//ascending order from left to right(123)
					if(((int)sll2.getElement(sll2.size1()-1)) == ((int)sll2.getElement(sll2.size1()))-1) {
						if(((int)sll2.getElement(sll2.size1()-2)) == ((int)sll2.getElement(sll2.size1()-1)-1)) {
							run=false;
						}		
					}
					//descending row from left to right (321)
					else if(((int)sll2.getElement(sll2.size1()-1)) == ((int)sll2.getElement(sll2.size1()))+1) {
						if(((int)sll2.getElement(sll2.size1()-2)) == ((int)sll2.getElement(sll2.size1()-1)+1)) {
							run=false;
						}
					}
				}
				//cross control from top right to bottom left
				if(sll1.size1()>2 && sll2.size1()>1 && sll3.size1()>0 && sll1.size1()>=sll2.size1()+1 && sll3.size1()>=sll2.size1()-1) {
					//increased sequence control
					if(((int)sll1.getElement(sll2.size1()+1)) == ((int)sll2.getElement(sll2.size1())-1)) {
						if(((int)sll2.getElement(sll2.size1())) ==((int)sll3.getElement(sll2.size1()-1)-1)) {
							run = false;
						}
					}
					//descending order control
					if(((int)sll1.getElement(sll2.size1()+1)) == ((int)sll2.getElement(sll2.size1())+1)) {
						if(((int)sll2.getElement(sll2.size1())) ==((int)sll3.getElement(sll2.size1()-1)+1)) {
							run = false;
						}
					}
				}
				//cross control from top left to bottom right
				if(sll1.size1()>0 && sll2.size1()>1 && sll3.size1()>2 && sll1.size1()>=sll2.size1()-1 && sll3.size1()>=sll2.size1()+1) {
					//increased sequence control
					if(((int)sll1.getElement(sll2.size1()-1)) == ((int)sll2.getElement(sll2.size1())-1)) {
						if(((int)sll2.getElement(sll2.size1())) ==((int)sll3.getElement(sll2.size1()+1)-1)) {
							run = false;
						}
					}
					//descending order control
					if(((int)sll1.getElement(sll2.size1()-1)) == ((int)sll2.getElement(sll2.size1())+1)) {
						if(((int)sll2.getElement(sll2.size1())) ==((int)sll3.getElement(sll2.size1()+1)+1)) {
							run = false;
						}
					}	
				}
				
				//top - down control
				if(sll1.size1()>=sll2.size1() && sll2.size1()>0 && sll3.size1()>=sll2.size1())
				{//increased sequence control
					if(((int)sll1.getElement(sll2.size1())) == ((int)sll2.getElement(sll2.size1())-1)) {
						if(((int)sll2.getElement(sll2.size1())) ==((int)sll3.getElement(sll2.size1())-1)) {
							run = false;
						}
					}//descending order control
					else if(((int)sll1.getElement(sll2.size1())) == ((int)sll2.getElement(sll2.size1())+1)) {
						if(((int)sll2.getElement(sll2.size1())) ==((int)sll3.getElement(sll2.size1())+1)) {
							run = false;
						}
					}	
				}
				count++;
			} 
			
			else if (place == 2 && sll3.size1() != 8) {//if place equals zero and sll3 is not size 8.
				user(count);
				sll3.insert(num);
				screen();
				
				//horizontal row control
				if(sll3.size1()>2) {//If the size of sll3 is greater than 2
					//ascending order from left to right(123)
					if(((int)sll3.getElement(sll3.size1()-1)) == ((int)sll3.getElement(sll3.size1()))-1) {
						if(((int)sll3.getElement(sll3.size1()-2)) == ((int)sll3.getElement(sll3.size1()-1)-1)) {
							run=false;
						}		
					}
					//descending row from left to right (321)
					else if(((int)sll3.getElement(sll3.size1()-1)) == ((int)sll3.getElement(sll3.size1()))+1) {
						if(((int)sll3.getElement(sll3.size1()-2)) == ((int)sll3.getElement(sll3.size1()-1))+1) {
							run=false;
						}
					}
				}
				//cross control from bottom right to top left
				 if(sll3.size1()>2 && sll2.size1()>1 && sll1.size1()>0 && sll1.size1()>=sll3.size1()-2 && sll2.size1()>=sll3.size1()-1) {
					//increased sequence control
					if(((int)sll3.getElement(sll3.size1())) == ((int)sll2.getElement(sll3.size1()-1)-1)) {
						if(((int)sll2.getElement(sll3.size1()-1)) ==((int)sll1.getElement(sll3.size1()-2)-1)) {
							run = false;
						}
					}
					//descending order control
					if(((int)sll3.getElement(sll3.size1())) == ((int)sll2.getElement(sll3.size1()-1)+1)) {
						if(((int)sll2.getElement(sll3.size1()-1)) ==((int)sll1.getElement(sll3.size1()-2)+1)) {
							run = false;
						}
					}
				}
				//cross control from top left to bottom right
				if(sll3.size1()>0 && sll2.size1()>1 && sll1.size1()>2 && sll1.size1()>=sll3.size1()+2 && sll2.size1()>=sll3.size1()+1) {
					//increased sequence control
					if(((int)sll3.getElement(sll3.size1())) == ((int)sll2.getElement(sll3.size1()+1)-1)) {
						if(((int)sll2.getElement(sll3.size1()+1)) ==((int)sll1.getElement(sll3.size1()+2)-1)) {
							run = false;
						}
					}
					//descending order control
					if(((int)sll3.getElement(sll3.size1())) == ((int)sll2.getElement(sll3.size1()+1)+1)) {
						if(((int)sll2.getElement(sll3.size1()+1)) ==((int)sll1.getElement(sll3.size1()+2)+1)) {
							run = false;
						}
					}	
				}
				//upward control
				if(sll1.size1()>=sll3.size1() && sll2.size1()>=sll3.size1() && sll3.size1()>0)
				{//increased sequence control
					if(((int)sll3.getElement(sll3.size1())) == ((int)sll2.getElement(sll3.size1())-1)) {
						if(((int)sll2.getElement(sll3.size1())) ==((int)sll1.getElement(sll3.size1())-1)) {
							run = false;
						}
					}//descending order control
					else if(((int)sll3.getElement(sll3.size1())) == ((int)sll2.getElement(sll3.size1())+1)) {
						if(((int)sll2.getElement(sll3.size1())) ==((int)sll1.getElement(sll3.size1())+1)) {
							run = false;
						}
					}	
				}	
				count++;
			}
			//the winner is printed on the screen.
			if(!run) {
				System.out.print("Winner: ");
				user(count-1);
			}
			else if(sll1.size1()==8 && sll2.size1()==8 && sll3.size1()==8) {//if SLL1, SLL2, SLL3 size equals 8
				run=false;
				System.out.println("Winner: Tie");
			}
			
		}
	}
}
