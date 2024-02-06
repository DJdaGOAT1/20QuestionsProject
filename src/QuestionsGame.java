// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.
import java.io.PrintStream;
import java.util.*;

public class QuestionsGame {
    public QuestionNode overallRoot;

    private static class QuestionNode {
        public final String data;
        public QuestionNode left;
        public QuestionNode right;
        
        public QuestionNode(String data, QuestionNode left, QuestionNode right) {
        	this.data = data;
        	this.left = left;
        	this.right = right;
        }
        
        public QuestionNode(String data) {
        	this.data = data;
        	left = null;
        	right = null;
        }

    }
    
    public QuestionsGame(String object) {
    	overallRoot = new QuestionNode(object);
    }
    
    public QuestionsGame(Scanner input) {
    	overallRoot = makeTree(input);

    }
    
    private QuestionNode makeTree(Scanner input) {
        String type = input.nextLine(); //skips q and a
        String item = input.nextLine(); //item = next line in the file
        QuestionNode a = new QuestionNode(item);

        //if it is a question
        if (type.contains("Q")) {
           a.left = makeTree(input);
           a.right = makeTree(input);
        }

        return a;
    }

    
    public void saveQuestions(PrintStream output) {
        saveQuestions(overallRoot, output); 
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
    	play(overallRoot);
    }
    
    private void play(QuestionNode overallRoot) {
    	while(overallRoot != null) {
    		
    	}
    }
    
   
    

}