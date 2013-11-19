package todomvc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class ToDoApp implements EntryPoint {

	@Override
	public void onModuleLoad() {
		ToDoView toDoView = new ToDoView();
		new ToDoPresenter(new ClientFactory(), toDoView);
		RootPanel.get().add(toDoView);
	}

}
