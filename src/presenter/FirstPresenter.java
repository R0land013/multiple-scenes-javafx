package presenter;

import view.FirstView;
import view.PresenterView;

public class FirstPresenter extends AbstractPresenter{

	private FirstView view;
	
	private int btn_clicked = 0;
	
	private static final int GO_TO_SECOND_SCENE_BTN = 1;
	
	
	public FirstPresenter(PresenterManager presenterStack) {
		super(presenterStack);
		view = new FirstView(this);
	}

	@Override
	public AbstractPresenter getDerivedPresenter() {
		if(btn_clicked == GO_TO_SECOND_SCENE_BTN) {
			return new SecondPresenter(getPresenterStack());
		}
		return null;
	}

	public void goToSecondScene() {
		btn_clicked = GO_TO_SECOND_SCENE_BTN;
		notifyManagerToAddNewPresenter();
	}
	
	public void exit() {
		notifyManagerToDeletePresenter();
	}
	
	@Override
	public PresenterView getPresenterView() {
		return view;
	}

}
