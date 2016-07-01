package pl.johnny.gwtQuiz.client.ui;

import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.client.ui.NavbarBrand;
import org.gwtbootstrap3.client.ui.constants.IconType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import pl.johnny.gwtQuiz.client.place.HighScoresPlace;
import pl.johnny.gwtQuiz.client.place.MainMenuPlace;
import pl.johnny.gwtQuiz.client.place.QuestionPlace;

public class NavBarViewImpl extends Composite implements NavBarView {

	private static NavBarViewImplUiBinder uiBinder = GWT.create(NavBarViewImplUiBinder.class);

	interface NavBarViewImplUiBinder extends UiBinder<Widget, NavBarViewImpl> {
	}
	
	private Presenter listener;
	
	@UiField NavbarBrand navBarBrand;
	@UiField AnchorListItem newGameAnchor;
	@UiField AnchorListItem highScoreAnchor;

	public NavBarViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		
		// Set icons on navigation bar buttons
		highScoreAnchor.setIcon(IconType.LIST_ALT);
		newGameAnchor.setIcon(IconType.PLAY_CIRCLE);
	}

	@Override
	public void setPresenter(Presenter listener) {
		this.listener = listener;
	}
	
	@UiHandler("navBarBrand")
	void onNavBarBrandClicked(ClickEvent e) {
		navBarBrand.getText();
		if (listener != null) {
			listener.goTo(new MainMenuPlace("MainMenu"));
		}
	}
	
	@UiHandler("newGameAnchor")
	void onNewGameAnchorClicked(ClickEvent e) {
		if (listener != null) {
			listener.goTo(new QuestionPlace("Quiz!"));
		}
	}
	
	@UiHandler("highScoreAnchor")
	void onHighScoreAnchorClicked(ClickEvent e) {
		if (listener != null) {
			listener.goTo(new HighScoresPlace("HighScores"));
		}
	}
	
	@Override
	public void setAnchorListItem(int whichAnchorToHighlight){
		AnchorListItem[] anchorListItems = new AnchorListItem[]{newGameAnchor,highScoreAnchor};
		
		//Reset all nav bar anchors and navBarBrand (which don't have setActive() to non-active.
		for(int i=0; i < anchorListItems.length; i++){anchorListItems[i].setActive(false);};
		navBarBrand.getElement().getStyle().setProperty("backgroundColor", "#F8F8F8");
		
		switch(whichAnchorToHighlight){
			case 0 : anchorListItems[0].setActive(true);
			break;
			
			case 1 : anchorListItems[1].setActive(true);
			break;
			
			case 2 : navBarBrand.getElement().getStyle().setProperty("backgroundColor", "#E7E7E7");
			break;
		}
	}
}