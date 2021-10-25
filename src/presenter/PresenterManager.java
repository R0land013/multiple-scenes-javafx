package presenter;

import java.util.Stack;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import view.PresenterView;

public class PresenterManager {
	
	private Stack<AbstractPresenter> stack;
	private Stage stage;
	
	public PresenterManager(Stage stage) {
		stack = new Stack<AbstractPresenter>();
		this.stage = stage;
	}
	
	
	public void pushDerivedPresenter() {
		
		if(stack.isEmpty()) {
			throw new RuntimeException("There are not presenters.");
		}
		
		AbstractPresenter topPresenter = stack.peek();
		
		AbstractPresenter derivedPresenter = topPresenter.getDerivedPresenter();
		PresenterView derivedView = derivedPresenter.getPresenterView();
		
		stage.setScene(derivedView.getViewScene());
		stack.add(derivedPresenter);
	}
	
	
	public void setInitialPresenter(AbstractPresenter presenter) {
		if(stack.size() != 0) {
			throw new RuntimeException("There is already an initial presenter.");
		}
		stack.add(presenter);
		stage.setScene(presenter.getPresenterView().getViewScene());
	}
	
	public void popPresenter() {
		if(stack.isEmpty()) {
			throw new RuntimeException("There are not presenters.");
		}
		
		stack.pop();
		
		if(stack.isEmpty()) {
			Platform.exit();
			System.exit(0);
		}
		
		AbstractPresenter currentTopPresenter = stack.peek();
		PresenterView currentTopView = currentTopPresenter.getPresenterView();
		
		stage.setScene(currentTopView.getViewScene());
		
	}
	
	
	
	public void show() {
		if(stack.isEmpty()) {
			throw new RuntimeException("There are not presenters.");
		}
		stage.show();
	}
	
}
