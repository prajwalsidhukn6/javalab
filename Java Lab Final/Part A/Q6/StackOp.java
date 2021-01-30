// Create the dynamic stack by implementing
// the interfaces that defines push() and
// pop() methods.

interface Stack {
    int pop();
	void push(int a);
}

class DStack implements Stack {
	int[] arr;
	int top;
	int size;

	public DStack() {
		size = 3;
		arr = new int[size];
		top = -1;
	}

	public int pop() {
		if (top == -1) {
			System.out.println("STACK UNDERFLOW!!");
			return -1;
		}
		return arr[top--];
	}

	public void push(int a) {
		if (top == size - 1) {
			System.out.println("RESIZING....");
			int[] temp = new int[size * 2];

			for (int i = 0; i < size; i++)
				temp[i] = arr[i];
			arr = temp;
			size = size * 2;
		}
		arr[++top] = a;
		System.out.println("PUSHED " + a);
	}
}

public class StackOp {
	public static void main(String[] args) {
		DStack s = new DStack();

		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		System.out.println("POP: " + s.pop());
		System.out.println("POP: " + s.pop());
		System.out.println("POP: " + s.pop());
		System.out.println("POP: " + s.pop());
		System.out.println("POP: " + s.pop());
		System.out.println("POP: " + s.pop());
		System.out.println("POP: " + s.pop());
		System.out.println("POP: " + s.pop());
	}
}
