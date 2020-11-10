/**
 * generated by Xtext 2.23.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Client When Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.ClientWhenBlock#getAction <em>Action</em>}</li>
 *   <li>{@link de.acegen.aceGen.ClientWhenBlock#getInputValues <em>Input Values</em>}</li>
 *   <li>{@link de.acegen.aceGen.ClientWhenBlock#getUuid <em>Uuid</em>}</li>
 *   <li>{@link de.acegen.aceGen.ClientWhenBlock#getClientSystemTime <em>Client System Time</em>}</li>
 *   <li>{@link de.acegen.aceGen.ClientWhenBlock#getServerSystemTime <em>Server System Time</em>}</li>
 *   <li>{@link de.acegen.aceGen.ClientWhenBlock#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link de.acegen.aceGen.ClientWhenBlock#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getClientWhenBlock()
 * @model
 * @generated
 */
public interface ClientWhenBlock extends EObject
{
  /**
   * Returns the value of the '<em><b>Action</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' reference.
   * @see #setAction(HttpClientAce)
   * @see de.acegen.aceGen.AceGenPackage#getClientWhenBlock_Action()
   * @model
   * @generated
   */
  HttpClientAce getAction();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ClientWhenBlock#getAction <em>Action</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' reference.
   * @see #getAction()
   * @generated
   */
  void setAction(HttpClientAce value);

  /**
   * Returns the value of the '<em><b>Input Values</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.InputValue}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Input Values</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getClientWhenBlock_InputValues()
   * @model containment="true"
   * @generated
   */
  EList<InputValue> getInputValues();

  /**
   * Returns the value of the '<em><b>Uuid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uuid</em>' attribute.
   * @see #setUuid(String)
   * @see de.acegen.aceGen.AceGenPackage#getClientWhenBlock_Uuid()
   * @model
   * @generated
   */
  String getUuid();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ClientWhenBlock#getUuid <em>Uuid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Uuid</em>' attribute.
   * @see #getUuid()
   * @generated
   */
  void setUuid(String value);

  /**
   * Returns the value of the '<em><b>Client System Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Client System Time</em>' attribute.
   * @see #setClientSystemTime(String)
   * @see de.acegen.aceGen.AceGenPackage#getClientWhenBlock_ClientSystemTime()
   * @model
   * @generated
   */
  String getClientSystemTime();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ClientWhenBlock#getClientSystemTime <em>Client System Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Client System Time</em>' attribute.
   * @see #getClientSystemTime()
   * @generated
   */
  void setClientSystemTime(String value);

  /**
   * Returns the value of the '<em><b>Server System Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Server System Time</em>' attribute.
   * @see #setServerSystemTime(String)
   * @see de.acegen.aceGen.AceGenPackage#getClientWhenBlock_ServerSystemTime()
   * @model
   * @generated
   */
  String getServerSystemTime();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ClientWhenBlock#getServerSystemTime <em>Server System Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Server System Time</em>' attribute.
   * @see #getServerSystemTime()
   * @generated
   */
  void setServerSystemTime(String value);

  /**
   * Returns the value of the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute</em>' reference.
   * @see #setAttribute(Attribute)
   * @see de.acegen.aceGen.AceGenPackage#getClientWhenBlock_Attribute()
   * @model
   * @generated
   */
  Attribute getAttribute();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ClientWhenBlock#getAttribute <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute</em>' reference.
   * @see #getAttribute()
   * @generated
   */
  void setAttribute(Attribute value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(PrimitiveValue)
   * @see de.acegen.aceGen.AceGenPackage#getClientWhenBlock_Value()
   * @model containment="true"
   * @generated
   */
  PrimitiveValue getValue();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ClientWhenBlock#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(PrimitiveValue value);

} // ClientWhenBlock
