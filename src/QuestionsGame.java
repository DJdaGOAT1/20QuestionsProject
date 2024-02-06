// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.
import java.io.PrintStream;
import java.util.*;

public class QuestionsGame {
    public QuestionNode overallRoot;

    public static class QuestionNode {
        public final String data;
        public QuestionNode left;
        public QuestionNode right;
        
        public QuestionNode(String data, QuestionNode left, QuestionNode right) {
        	// setting all variables to given parameters
        	this.data = data;
        	this.left = left;
        	this.right = right;
        }
        
        public QuestionNode(String data) {
        	// setting the data to given parameter and setting every other variable to null
        	this.data = data;
        	left = null;
        	right = null;
        }

    }
    
    public QuestionsGame(String object) {
    	// constructor setting overallRoot to a new node with data, object
    	overallRoot = new QuestionNode(object);
    }
    
    public QuestionsGame(Scanner input) {
    	// sets the overallRoot as a tree to the input from a given file
    	overallRoot = makeTree(input); // calls private method makeTree to give you the tree

    }
    
    private QuestionNode makeTree(Scanner input) {
        String type = input.nextLine(); //skips q and a
        String item = input.nextLine(); //item = next line in the file
        QuestionNode a = new QuestionNode(item);

        //if it is a question
        if (type.contains("Q")) {
           // recur in pre-order pattern to add nodes as questions are asked
           a.left = makeTree(input);
           a.right = makeTree(input);
        }

        return a;
    }

    
    public void saveQuestions(PrintStream output) {
        saveQuestions(overallRoot, output); // calling private saveQuestions method
    }

    private void saveQuestions(QuestionNode node, PrintStream output) {
       
        if(node.left == null && node.right == null) {
        	output.println("A: ");
        	output.println(node.data);
        }
        else {
        	output.println("Q: ");
        	saveQuestions(node.left, output);
        	saveQuestions(node.right, output);
        }
    }
    
    public void play() {
    	play(overallRoot); // calling private play method
    }
    
    private void play(QuestionNode node) {
    	Scanner scan = new Scanner(System.in);
    	QuestionNode a = overallRoot;
    	if(a == null)  {
    		return;
    	}
    	System.out.println(node.data + "(y/n)?");
    	if(scan.nextLine().toLowerCase().trim().equals("y") && a.left != null) {
    		a = a.left;
    	}
    	else if(a.right != null){
    		a = a.right;
    	}
    	
    	if(a.left == null && a.right == null) {
    		System.out.println("I guess that your object is " + node.data);
    		System.out.println("Am I right? (y/n)");
    		if(scan.nextLine().toLowerCase().trim().equals("y")) {
    			System.out.println("Awesome! I win!");
    		}
    		else {
    			System.out.println("Boo! I Lose.  Please help me get better!");
    			System.out.println("What is your object? ");
    			String word = scan.nextLine();
    			System.out.println("Please give me a yes/no question that distinguishes between " + word + "and " + node.data);
    			String ques = scan.nextLine();
    			QuestionNode temp = a;
    			a.left = new QuestionNode(word);
    			a.right = temp;
    			a = new QuestionNode(ques);
    		}
    	}
    	
    }
    
   
    

}