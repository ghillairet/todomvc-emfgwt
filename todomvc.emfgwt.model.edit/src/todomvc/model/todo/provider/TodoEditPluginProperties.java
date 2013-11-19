/**
 */
package todomvc.model.todo.provider;

import com.google.gwt.i18n.client.Messages;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public interface TodoEditPluginProperties extends Messages {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_text")
	@DefaultMessage("{0}")
	String createChildText(Object type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_text2")
	@DefaultMessage("{1} {0}")
	String createChildText2(Object type, Object feature);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_text3")
	@DefaultMessage("{0}")
	String createChildText3(Object feature);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_tooltip")
	@DefaultMessage("Create New {0} Under {1} Feature")
	String createChildTooltip(Object type, Object feature);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_description")
	@DefaultMessage("Create a new child of type {0} for the {1} feature of the selected {2}.")
	String createChildDescripition(Object type, Object feature, Object selection);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateSibling_description")
	@DefaultMessage("Create a new sibling of type {0} for the selected {2}, under the {1} feature of their parent.")
	String createSiblingDescription(Object type, Object feature, Object selection);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_PropertyDescriptor_description")
	@DefaultMessage("The {0} of the {1}")
	String propertyDescriptorDescription(Object feature, Object type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Todo_type")
	@DefaultMessage("Todo")
	String todoType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Item_type")
	@DefaultMessage("Item")
	String itemType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Unknown_type")
	@DefaultMessage("Object")
	String unknownType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Unknown_datatype")
	@DefaultMessage("Value")
	String unknownDatatype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Todo_tasks_feature")
	@DefaultMessage("Tasks")
	String todo_TasksFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Item_title_feature")
	@DefaultMessage("Title")
	String item_TitleFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Item_done_feature")
	@DefaultMessage("Done")
	String item_DoneFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Unknown_feature")
	@DefaultMessage("Unspecified")
	String unknownFeature();

}
