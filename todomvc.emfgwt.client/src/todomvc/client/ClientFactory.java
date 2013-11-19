package todomvc.client;

import java.io.IOException;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emfjson.gwt.handlers.LocalStorageHandler;
import org.eclipselabs.emfjson.gwt.resource.JsResourceFactoryImpl;

import todomvc.model.todo.Todo;
import todomvc.model.todo.TodoFactory;
import todomvc.model.todo.TodoPackage;

public class ClientFactory {

	private static final String STORAGE_KEY = "todo-gwt";
	private ResourceSet resourceSet = new ResourceSetImpl();

	public ClientFactory() {
		resourceSet.getPackageRegistry().put(TodoPackage.eNS_URI, TodoPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new JsResourceFactoryImpl());
		resourceSet.getURIConverter().getURIHandlers().add(0, new LocalStorageHandler(STORAGE_KEY));
	}

	public void getTodo(final Callback<Todo> callback) {
		final Resource resource = resourceSet.createResource(URI.createURI("todos.json"));

		try {
			resource.load(null, new Callback<Resource>() {
				@Override
				public void onFailure(Throwable caught) {
					// resource does not exist yet

					callback.onFailure(caught);
					Todo todo = TodoFactory.eINSTANCE.createTodo();
					resource.getContents().add(todo);
					callback.onSuccess(todo);
				}
				@Override
				public void onSuccess(Resource result) {
					Todo todo;
					if (result.getContents().isEmpty()) {
						todo = TodoFactory.eINSTANCE.createTodo();
						result.getContents().add(todo);
					} else {
						todo = (Todo) result.getContents().get(0);
					}
					callback.onSuccess(todo);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
