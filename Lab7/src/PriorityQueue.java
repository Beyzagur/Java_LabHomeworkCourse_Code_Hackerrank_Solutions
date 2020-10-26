public class PriorityQueue {
	private int rear, front;
	private QueueElement[] elements;
	private int temprear, tempfront;
	private QueueElement[] tempelements;
	
	

	public PriorityQueue(int capacity) {		
		rear = -1;
		front = 0;
		elements = new QueueElement[capacity];
		temprear =-1;
		tempfront = 0;
		tempelements =new QueueElement[capacity] ;
	}

	void enqueue(QueueElement item) {
		if (isFull()) {
			System.out.println("Queue overflow");
		} else {
			while (!isEmpty() && item.getPriority() <= peek().getPriority())
				tempEnqueue(dequeue());
			tempEnqueue(item);
			while (!isEmpty())
				tempEnqueue(dequeue());
			while (!isEmptyTemp())
				simpleEnqueue(tempDequeue());
		}
	}

	void tempEnqueue(QueueElement item) {
		if (isFullTemp())
			System.out.println("Queue overflow");
		else {
			temprear = (temprear + 1) % tempelements.length;
			tempelements[temprear] = item;
		}
	}

	void simpleEnqueue(QueueElement item) {
		if (isFull())
			System.out.println("Queue overflow");
		else {
			rear = (rear + 1) % elements.length;
			elements[rear] = item;
		}
	}
	
	QueueElement dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		} else {
			QueueElement item = elements[front];
			elements[front] = null;
			front = (front + 1) % elements.length;
			return item;
		}
	}

	QueueElement tempDequeue() {
		if (isEmptyTemp()) {
			System.out.println("Queue is empty");
			return null;
		} else {
			QueueElement item = tempelements[tempfront];
			tempelements[tempfront] = null;
			tempfront = (tempfront + 1) % tempelements.length;
			return item;
		}
	}

	QueueElement peek() {
		if (isEmpty()) {
			System.out.println("Queue isempty");
			return null;
		} else {
			return elements[front];
		}
	}

	boolean isEmpty() {
		return elements[front] == null;
	}

	boolean isEmptyTemp() {
		return tempelements[tempfront] == null;
	}
	
	boolean isFull() {
		return (front == (rear + 1) % elements.length && 
				elements[front] != null && 
				elements[rear] != null);
	}
	
	boolean isFullTemp() {
		return (tempfront == (temprear + 1) % tempelements.length && 
				tempelements[tempfront] != null && 
				tempelements[temprear] != null);
	}
	
	int size() {
		if (rear >= front)
			return rear - front + 1;
		else if (elements[front] != null)
			return elements.length - (front - rear) + 1;
		else
			return 0;
	}
	
	int sizeTemp() {
		if (temprear >= tempfront)
			return temprear - tempfront + 1;
		else if (tempelements[tempfront] != null)
			return tempelements.length - (tempfront - temprear) + 1;
		else
			return 0;
	}
	
}