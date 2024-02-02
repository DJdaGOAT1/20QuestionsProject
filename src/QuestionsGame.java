// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.
import java.io.PrintStream;
import java.util.*;

public class QuestionsGame {
    // Your code here

    private static class QuestionNode {
        public final String data;
        public QuestionNode left;
        public QuestionNode right;
        
        public QuestionNode(String data, QuestionNode left, QuestionNode right) {
        	this.data = data;
        	this.left = left;
        	this.right = right;
        }
    }
    
    public QuestionsGame(String object) {
    	QuestionsGame obj = new QuestionsGame(object);
    }
    
    public QuestionsGame(Scanner input) {
    	QuestionsGame scan = new QuestionsGame(input);
    }
    
    public void saveQuestions(PrintStream output) {
    	if(output == null) {
    		throw new IllegalArgumentException();
    	}
    }
    
    public void play() {
    	
    }
    
    
}