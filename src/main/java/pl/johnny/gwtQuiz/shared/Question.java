/**
 * Model Class.
 * @author jzarewicz
 *
 */
package pl.johnny.gwtQuiz.shared;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import com.google.gwt.user.client.rpc.IsSerializable;

@ServerConstraint(groups = ServerGroup.class)
public class Question implements IsSerializable {
	
	@Size(min = 1, max = 50, groups = ServerGroup.class)
	private String question;
	
	private String[] answers;
	
	private String correctAnsw;
	
	@Range(min = 0, max = 3, groups = ServerGroup.class)
	private int correctAnswersInt;
	
	@Size(min = 1, max = 20, groups = ServerGroup.class)
	private String authorData;
	
	private String categoryData;
	/** Image server url as String/ */
	private String questionImageData;
	private String ID;

	/**
	 * Do NOT delete this default,public,no-arg constructor. It's necessary 
	 * for Serialization.
	 */
	public Question() {
	};
	
	/**
	 * Used to retrieve questions from main (non-temporary) tables.
	 * @param questionData String
	 * @param questionImageData String
	 * @param answers String[]
	 * @param correctAnswersData String
	 * @param authorData String
	 * @param categoryData String
	 */
	public Question(String questionData,String questionImageData, String[] answers, String correctAnswersData, 
			String authorData, String categoryData) {
		this.question = questionData;
		this.questionImageData = questionImageData;
		this.answers = answers;
		this.correctAnsw = correctAnswersData;
		this.authorData = authorData;
		this.categoryData = categoryData;
	}
	
	/**
	 * Used to retrieve questions from temporary tables. We add here an ID field. 
	 * @param question String
	 * @param questionImageData String
	 * @param answers String[]
	 * @param correctAnswersData String
	 * @param authorData String
	 * @param categoryData String
	 * @param ID String
	 */
	public Question(String question,String questionImageData, String[] answers, String correctAnswersData, 
			int correctAnswersInt,String authorData, String categoryData, String ID) {
		this.question = question;
		this.questionImageData = questionImageData;
		this.answers = answers;
		this.correctAnsw = correctAnswersData;
		this.correctAnswersInt = correctAnswersInt;
		this.authorData = authorData;
		this.categoryData = categoryData;
		this.ID = ID;
	}

	public String getQuestion() {
		return question;
	}
	
	/**Get image server url as String. */
	public String getImageURL() {
		return questionImageData;
	}

	/**
	 * Get all questions from an array <br/>
	 * Handy e.g in getting size() of questions array
	 * 
	 * @return String[] 
	 */
	public String[] getAnswers() {
		return answers;
	}

	/**
	 * Get specific answer from answers array
	 * @param i
	 * @return Specific question from an array in a String
	 */
	public String getAnswer(int i) {
		return answers[i];
	}

	public String getCorrectAnsw() {
		return correctAnsw;
	}
	
	public int getCorrectAnswersInt() {
		return correctAnswersInt;
	}

	public String getAuthor() {
		return authorData;
	}

	public String getCategory() {
		return categoryData;
	}
	
	public String getID() {
		return ID;
	}
}
