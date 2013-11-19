/**
 */
package todomvc.model.todo;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Todo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link todomvc.model.todo.Todo#getTasks <em>Tasks</em>}</li>
 * </ul>
 * </p>
 *
 * @see todomvc.model.todo.TodoPackage#getTodo()
 * @model
 * @generated
 */
public interface Todo extends EObject {
	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link todomvc.model.todo.Item}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tasks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see todomvc.model.todo.TodoPackage#getTodo_Tasks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Item> getTasks();

} // Todo
