package pl.johnny.gwtQuiz.client.ui;

import pl.johnny.gwtQuiz.client.place.QuestionPlace;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MainMenuViewImpl extends Composite implements MainMenuView {
	private static HelloViewImplUiBinder uiBinder = GWT.create(HelloViewImplUiBinder.class);

	interface HelloViewImplUiBinder extends UiBinder<Widget, MainMenuViewImpl> {
	}

	@UiField
	Button newGameButton;
	private Presenter listener;
	private String name;

	public MainMenuViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@UiHandler("newGameButton")
	void onNewGameButtonClicked(ClickEvent e) {
		if (listener != null) {
			listener.onNewGameButtonClicked("asd");
		}
	}

	@Override
	public void setPresenter(Presenter listener) {
		this.listener = listener;
	}
}