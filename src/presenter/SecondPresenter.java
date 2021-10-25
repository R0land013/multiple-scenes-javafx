package presenter;

import view.PresenterView;
import view.SecondView;

public class SecondPresenter extends AbstractPresenter{

	private static final int GO_TO_THIRD_SCENE_BTN = 1;
	
	private SecondView view;
	
	private int clickedBtn;
	
	
	
	
	public SecondPresenter(PresenterManager presenterStack) {
		super(presenterStack);
		
		view = new SecondView(this);
	}
	
	public void goToThirdScene() {
		clickedBtn = GO_TO_THIRD_SCENE_BTN;
		notifyManagerToAddNewPresenter();
	}
	
	@Override
	public AbstractPresenter getDerivedPresenter() {
		if(clickedBtn == GO_TO_THIRD_SCENE_BTN) {
			return new ThirdPresenter(getPresenterStack());
		}
		return null;
	}

	public void returnToFirstScene() {
		notifyManagerToDeletePresenter();
	}
	
	
	@Override
	public PresenterView getPresenterView() {
		return view;
	}

}
