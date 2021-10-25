package presenter;

import view.PresenterView;
import view.ThirdView;

public class ThirdPresenter extends AbstractPresenter{
	
	private ThirdView view;
	
	
	
	public ThirdPresenter(PresenterManager presenterStack) {
		super(presenterStack);
		
		view = new ThirdView(this);
		
	}

	@Override
	public AbstractPresenter getDerivedPresenter() {
		// TODO Auto-generated method stub
		return null;
	}

	public void returnToSecondScene() {
		notifyManagerToDeletePresenter();
	}
	
	@Override
	public PresenterView getPresenterView() {
		return view;
	}

}
