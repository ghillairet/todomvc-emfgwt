package todomvc.client;

import todomvc.model.todo.Item;

/**
 * A routing function that matches active todo items.
 */
public class ToDoRoutingActive implements ToDoRoutingFunction {

	@Override
	public boolean matches(Item item) {
		return !item.isDone();
	}

}
