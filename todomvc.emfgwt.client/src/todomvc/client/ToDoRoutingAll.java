package todomvc.client;

import todomvc.model.todo.Item;

/**
 * A routing function that matches all todo items.
 */
public class ToDoRoutingAll implements ToDoRoutingFunction {

	@Override
	public boolean matches(Item item) {
		return true;
	}

}
