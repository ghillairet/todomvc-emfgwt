package todomvc.client;

import todomvc.model.todo.Item;

/**
 * A routing function that matches completed todo items.
 */
public class ToDoRoutingCompleted implements ToDoRoutingFunction {

	@Override
	public boolean matches(Item item) {
		return item.isDone();
	}

}
