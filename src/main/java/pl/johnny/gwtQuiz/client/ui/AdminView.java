package pl.johnny.gwtQuiz.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

import pl.johnny.gwtQuiz.client.ui.widgets.PanelWidget;
import pl.johnny.gwtQuiz.shared.Question;
import pl.johnny.gwtQuiz.shared.SQLConstraintException;

/**
 * View interface. Extends IsWidget so a view impl can easily provide
 * its container widget.
 *
 * @author jzarewicz
 */
public interface AdminView extends IsWidget
{
	void setPresenter(Presenter listener);
	
	public interface Presenter {
		void goTo(Place place);

		void fetchAndBuildPanelWithTmpQuestions();

		void acceptUserTmpQuestion(Question acceptedQuestion, String tmpQuestionID);

		void deleteUserTmpQuestion(String questionID);

		void addCategory(String newCategory);

		void deleteCategory(String categoryToDelete, final List<String> list, final String selectedCategory);

		void updateCategory(String updatedCategory, int categoryID);
		
	}

	void setCategories(String[] categories);

	void buildAndFillPanelsWithTmpQuestions(ArrayList<Question> tmpQuestion);

	void refreshPanel();

	PanelWidget[] getPanelWidgets();

	void buildCategoriesCellList(String[] categories);
}