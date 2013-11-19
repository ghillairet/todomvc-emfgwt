/**
 */
package todomvc.model.todo.provider;

import com.google.gwt.core.client.GWT;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

/**
 * This is the central singleton for the Todo edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class TodoEditPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final TodoEditPlugin INSTANCE = new TodoEditPlugin();

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TodoEditPlugin() {
		super
		  (new ResourceLocator [] {
		   });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final TodoEditPluginProperties PROPERTIES = GWT.create(TodoEditPluginProperties.class);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getString(String key, boolean translate) {
		if ("_UI_Todo_type".equals(key)) return PROPERTIES.todoType();
		else if ("_UI_Item_type".equals(key)) return PROPERTIES.itemType();
		else  if ("_UI_Unknown_type".equals(key)) return PROPERTIES.unknownType();
		else if ("_UI_Unknown_datatype".equals(key)) return PROPERTIES.unknownDatatype();
		else if ("_UI_Todo_tasks_feature".equals(key)) return PROPERTIES.todo_TasksFeature();
		else if ("_UI_Item_title_feature".equals(key)) return PROPERTIES.item_TitleFeature();
		else if ("_UI_Item_done_feature".equals(key)) return PROPERTIES.item_DoneFeature();
		else if ("_UI_Unknown_feature".equals(key)) return PROPERTIES.unknownFeature();
		else return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getString(String key, Object [] substitutions, boolean translate) {
		if ("_UI_CreateChild_text".equals(key)) return PROPERTIES.createChildText(substitutions[0]);
		else if ("_UI_CreateChild_text2".equals(key)) return PROPERTIES.createChildText2(substitutions[0], substitutions[1]);
		else if ("_UI_CreateChild_text3".equals(key)) return PROPERTIES.createChildText3(substitutions[1]);
		else if ("_UI_CreateChild_tooltip".equals(key)) return PROPERTIES.createChildTooltip(substitutions[0], substitutions[1]);
		else if ("_UI_CreateChild_description".equals(key)) return PROPERTIES.createChildDescripition(substitutions[0], substitutions[1], substitutions[2]);
		else if ("_UI_CreateSibling_description".equals(key)) return PROPERTIES.createSiblingDescription(substitutions[0], substitutions[1], substitutions[2]);
		if ("_UI_PropertyDescriptor_description".equals(key)) return PROPERTIES.propertyDescriptorDescription(substitutions[0], substitutions[1]);
		else return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final TodoEditPluginImages IMAGES = GWT.create(TodoEditPluginImages.class);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(String key) {
		if ("full/obj16/Todo".equals(key)) return IMAGES.todo();
		else if ("full/obj16/Item".equals(key)) return IMAGES.item();
		else return key;
	}

}
