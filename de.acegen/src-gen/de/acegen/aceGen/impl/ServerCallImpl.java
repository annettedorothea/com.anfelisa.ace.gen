/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.JsonObject;
import de.acegen.aceGen.ServerCall;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Server Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.ServerCallImpl#getJsonObject <em>Json Object</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServerCallImpl extends MinimalEObjectImpl.Container implements ServerCall
{
  /**
   * The cached value of the '{@link #getJsonObject() <em>Json Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJsonObject()
   * @generated
   * @ordered
   */
  protected JsonObject jsonObject;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ServerCallImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return AceGenPackage.Literals.SERVER_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JsonObject getJsonObject()
  {
    return jsonObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetJsonObject(JsonObject newJsonObject, NotificationChain msgs)
  {
    JsonObject oldJsonObject = jsonObject;
    jsonObject = newJsonObject;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AceGenPackage.SERVER_CALL__JSON_OBJECT, oldJsonObject, newJsonObject);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setJsonObject(JsonObject newJsonObject)
  {
    if (newJsonObject != jsonObject)
    {
      NotificationChain msgs = null;
      if (jsonObject != null)
        msgs = ((InternalEObject)jsonObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.SERVER_CALL__JSON_OBJECT, null, msgs);
      if (newJsonObject != null)
        msgs = ((InternalEObject)newJsonObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.SERVER_CALL__JSON_OBJECT, null, msgs);
      msgs = basicSetJsonObject(newJsonObject, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.SERVER_CALL__JSON_OBJECT, newJsonObject, newJsonObject));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AceGenPackage.SERVER_CALL__JSON_OBJECT:
        return basicSetJsonObject(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AceGenPackage.SERVER_CALL__JSON_OBJECT:
        return getJsonObject();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AceGenPackage.SERVER_CALL__JSON_OBJECT:
        setJsonObject((JsonObject)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case AceGenPackage.SERVER_CALL__JSON_OBJECT:
        setJsonObject((JsonObject)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AceGenPackage.SERVER_CALL__JSON_OBJECT:
        return jsonObject != null;
    }
    return super.eIsSet(featureID);
  }

} //ServerCallImpl
