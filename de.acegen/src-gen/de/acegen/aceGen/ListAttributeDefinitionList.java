/**
 * generated by Xtext 2.16.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Attribute Definition List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.ListAttributeDefinitionList#getAttributeDefinitionList <em>Attribute Definition List</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getListAttributeDefinitionList()
 * @model
 * @generated
 */
public interface ListAttributeDefinitionList extends EObject
{
  /**
   * Returns the value of the '<em><b>Attribute Definition List</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.AttributeDefinitionList}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute Definition List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Definition List</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getListAttributeDefinitionList_AttributeDefinitionList()
   * @model containment="true"
   * @generated
   */
  EList<AttributeDefinitionList> getAttributeDefinitionList();

} // ListAttributeDefinitionList
