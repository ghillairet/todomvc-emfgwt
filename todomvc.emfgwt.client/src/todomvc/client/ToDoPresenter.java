package todomvc.client;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.ecore.resource.Resource;

import todomvc.model.todo.Item;
import todomvc.model.todo.Todo;
import todomvc.model.todo.TodoFactory;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.view.client.AbstractDataProvider;
import com.google.gwt.view.client.ListDataProvider;

/**
 * The presenter for the ToDo application. This class is responsible for the lifecycle of the
 * {@link Item} instances.
 *
 * @author ceberhardt
 *
 */
public class ToDoPresenter {

	/**
	 * The interface that a view for this presenter must implement.
	 */
	public interface View {

		CellView getCell();

		/**
		 * Gets the text that the user has input for the creation of new tasks.
		 */
		String getTaskText();

		/**
		 * Clears the user input field where new tasks are added.
		 */
		void clearTaskText();

		/**
		 * Sets the current task statistics.
		 */
		void setTaskStatistics(int totalTasks, int completedTasks);

		/**
		 * Sets the data provider that acts as a source of {@link Item} instances.
		 */
		void setDataProvider(AbstractDataProvider<Item> data);

		/**
		 * Adds the handler to the events raised by the view.
		 */
		void addhandler(ViewEventHandler handler);

		/**
		 * Informs the view of the current routing state.
		 */
		void setRouting(ToDoRouting routing);
	}
	
	/**
	 * The interface that the cell view for this presenter must implement. 
	 */
	public interface CellView {
		/**
		 * Adds the handler to the events raised by the view.
		 */
		void addhandler(CellViewEventHandler handler);
	}

	/**
	 * The interface that handles interactions from the view.
	 *
	 */
	public interface ViewEventHandler {
		/**
		 * Invoked when a user adds a new task.
		 */
		void addTask();

		/**
		 * Invoked when a user wishes to clear completed tasks.
		 */
		void clearCompletedTasks();

		/**
		 * Sets the completed state of all tasks to the given state
		 */
		void markAllCompleted(boolean completed);
	}
	
	/**
	 * The interface that handles interactions from the cell view. 
	 *
	 */
	public interface CellViewEventHandler {
		/**
		 * Invoked when a user deletes a task.
		 */
		void deleteTask(Item editingItem);
		
	}

	/**
	 * Handler for view events, defers to private presenter methods.
	 */
	private final ViewEventHandler viewHandler = new ViewEventHandler() {
		@Override
		public void addTask() {
			ToDoPresenter.this.addTask();
		}

		@Override
		public void clearCompletedTasks() {
			ToDoPresenter.this.clearCompletedTasks();
		}

		@Override
		public void markAllCompleted(boolean completed) {
			ToDoPresenter.this.markAllCompleted(completed);
		}
	};
	
	private final CellViewEventHandler cellViewHandler = new CellViewEventHandler() {
		@Override
		public void deleteTask(Item editingItem) {
			ToDoPresenter.this.deleteTask(editingItem);
		}
	}; 

	private Todo todos;

	private final ListDataProvider<Item> filteredTodos = new ListDataProvider<Item>();

	private final View view;

	private ToDoRouting routing = ToDoRouting.ALL;

	private boolean suppressStateChanged = false;

	public ToDoPresenter(ClientFactory clientFactory, final View view) {
		this.view = view;

		clientFactory.getTodo(new Callback<Todo>() {
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			};
			public void onSuccess(Todo result) {
				todos = result;

				String initialToken = History.getToken();
				routing = parseRoutingToken(initialToken);

				view.addhandler(viewHandler);
				view.getCell().addhandler(cellViewHandler);
				view.setDataProvider(filteredTodos);
				view.setRouting(routing);

				updateFilteredList();
				updateTaskStatistics();
				setupHistoryHandler();	
			};
		});
	}

	/**
	 * Set up a the history changed handler, which provides routing.
	 */
	private void setupHistoryHandler() {
		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
				String historyToken = event.getValue();
				routing = parseRoutingToken(historyToken);
				view.setRouting(routing);
				updateFilteredList();
			}
		});
	}

	/**
	 * Converts the string routing token into the equivalent enum value
	 */
	private ToDoRouting parseRoutingToken(String token ) {
		if (token.equals("/active")) {
			return ToDoRouting.ACTIVE;
		} else if (token.equals("/completed")) {
			return ToDoRouting.COMPLETED;
		} else {
			return ToDoRouting.ALL;
		}
	}

	/**
	 * Updates the filtered list, which is rendered in the UI.
	 */
	private void updateFilteredList() {
		filteredTodos.getList().clear();
		for (Item task : todos.getTasks()) {
			if (routing.getRoutingFunction().matches(task)) {
				filteredTodos.getList().add(task);
			}
		}
	}

	/**
	 * Computes the tasks statistics and updates the view.
	 */
	private void updateTaskStatistics() {
		int totalTasks = todos.getTasks().size();

		int completeTask = 0;
		for (Item task : todos.getTasks()) {
			if (task.isDone()) {
				completeTask++;
			}
		}

		view.setTaskStatistics(totalTasks, completeTask);
	}

	/**
	 * Deletes the given task and updates statistics.
	 */
	protected void deleteTask(Item Item) {
		todos.getTasks().remove(Item);
		taskStateChanged();
	}

	/**
	 * Invoked by a task when its state changes so that we can update the view statistics and persist.
	 */
	protected void itemStateChanged(Item Item) {

		if (suppressStateChanged) {
			return;
		}

		// if the item has become empty, remove it
		if (Item.getTitle().trim().equals("")) {
			todos.getTasks().remove(Item);
		}

		taskStateChanged();
	}

	/**
	 * When the task state has changed, this method will update the UI and persist
	 */
	private void taskStateChanged() {
		updateFilteredList();
		updateTaskStatistics();
		saveState();
	}

	/**
	 * Sets the completed state of all tasks
	 */
	private void markAllCompleted(boolean completed) {

		// update the completed state of each item
		suppressStateChanged = true;
		for (Item task : todos.getTasks()) {
			task.setDone(completed);
		}
		suppressStateChanged = false;

		taskStateChanged();
	}

	/**
	 * Adds a new task based on the user input field
	 */
	private void addTask() {
		String taskTitle = view.getTaskText().trim();

		// if white-space only, do not add a todo
		if (taskTitle.equals(""))
			return;

		Item item = TodoFactory.eINSTANCE.createItem();
		item.setTitle(taskTitle);
		view.clearTaskText();
		todos.getTasks().add(item);

		taskStateChanged();
	}

	/**
	 * Clears completed tasks and updates the view.
	 */
	private void clearCompletedTasks() {
		Iterator<Item> iterator = todos.getTasks().iterator();
		while (iterator.hasNext()) {
			Item item = iterator.next();
			if (item.isDone()) {
				iterator.remove();
			}
		}

		taskStateChanged();
	}

	/**
	 * Saves the current to-do items to local storage
	 */
	private void saveState() {
		try {
			todos.eResource().save(null, new Callback<Resource>() {
				@Override
				public void onSuccess(Resource result) {
					
				}
				@Override
				public void onFailure(Throwable caught) {
					caught.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
