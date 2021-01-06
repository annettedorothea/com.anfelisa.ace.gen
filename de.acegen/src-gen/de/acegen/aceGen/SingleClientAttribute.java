/**
 * generated by Xtext 2.23.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Client Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.SingleClientAttribute#isList <em>List</em>}</li>
 *   <li>{@link de.acegen.aceGen.SingleClientAttribute#isHash <em>Hash</em>}</li>
 *   <li>{@link de.acegen.aceGen.SingleClientAttribute#isStorage <em>Storage</em>}</li>
 *   <li>{@link de.acegen.aceGen.SingleClientAttribute#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getSingleClientAttribute()
 * @model
 * @generated
 */
public interface SingleClientAttribute extends ClientAttribute
{
  /**
   * Returns the value of the '<em><b>List</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' attribute.
   * @see #setList(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getSingleClientAttribute_List()
   * @model
   * @generated
   */
  boolean isList();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.SingleClientAttribute#isList <em>List</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>List</em>' attribute.
   * @see #isList()
   * @generated
   */
  void setList(boolean value);

  /**
   * Returns the value of the '<em><b>Hash</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hash</em>' attribute.
   * @see #setHash(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getSingleClientAttribute_Hash()
   * @model
   * @generated
   */
  boolean isHash();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.SingleClientAttribute#isHash <em>Hash</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Hash</em>' attribute.
   * @see #isHash()
   * @generated
   */
  void setHash(boolean value);

  /**
   * Returns the value of the '<em><b>Storage</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Storage</em>' attribute.
   * @see #setStorage(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getSingleClientAttribute_Storage()
   * @model
   * @generated
   */
  boolean isStorage();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.SingleClientAttribute#isStorage <em>Storage</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Storage</em>' attribute.
   * @see #isStorage()
   * @generated
   */
  void setStorage(boolean value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.ClientAttribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getSingleClientAttribute_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<ClientAttribute> getAttributes();

} // SingleClientAttribute
