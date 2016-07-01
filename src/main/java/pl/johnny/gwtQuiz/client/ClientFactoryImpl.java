package pl.johnny.gwtQuiz.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

import pl.johnny.gwtQuiz.client.ui.HighScoreCellTableView;
import pl.johnny.gwtQuiz.client.ui.HighScoreCellTableViewImpl;
import pl.johnny.gwtQuiz.client.ui.HighScoresView;
import pl.johnny.gwtQuiz.client.ui.HighScoresViewImpl;
import pl.johnny.gwtQuiz.client.ui.MainMenuView;
import pl.johnny.gwtQuiz.client.ui.MainMenuViewImpl;
import pl.johnny.gwtQuiz.client.ui.NavBarView;
import pl.johnny.gwtQuiz.client.ui.NavBarViewImpl;
import pl.johnny.gwtQuiz.client.ui.QuestionView;
import pl.johnny.gwtQuiz.client.ui.QuestionViewImpl;

public class ClientFactoryImpl implements ClientFactory
{
	private static final EventBus eventBus = new com.google.web.bindery.event.shared.SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static final MainMenuView mainMenuView = new MainMenuViewImpl();
	private static final QuestionView questionView = new QuestionViewImpl();
	private static final HighScoreCellTableView highScoreCellTableView = new HighScoreCellTableViewImpl();
	private static final HighScoresView highScoreView = new HighScoresViewImpl();
	private static final NavBarView navBarView = new NavBarViewImpl();
	private final QuestionServiceAsync questionService = GWT.create(QuestionService.class);


	@Override
	public EventBus getEventBus()
	{
		return eventBus;
	}

	@Override
	public MainMenuView getMainMenuView()
	{
		return mainMenuView;
	}

	@Override
	public PlaceController getPlaceController()
	{
		return placeController;
	}

	@Override
	public QuestionView getQuestionView()
	{
		return questionView;
	}
	
	@Override
	public HighScoreCellTableView getHighScoreCellTableView()
	{
		return highScoreCellTableView;
	}
	
	@Override
	public HighScoresView getHighScoreView()
	{
		return highScoreView;
	}

	@Override
	public QuestionServiceAsync getContactService() {
		return questionService;
	}

	@Override
	public NavBarView getNavBarView() {
		return navBarView;
	}
}