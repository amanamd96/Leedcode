//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
    
    void sortedStack(Stack<Integer> s ,int data){
        	if(s.isEmpty() || s.peek() < data){
		       s.push(data);
		       return;
		    }
		    
		    int n = s.peek();
		    s.pop();
		    sortedStack(s,data);
		    s.push(n);
    }
    
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		if(s.isEmpty()){
		    return s;
		}
		
		
	     int data = s.peek();
	     s.pop();
	     sort(s);
	     sortedStack(s , data);
	     
	     return s;
		    
	}
}