/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.Authorization;
import de.acegen.aceGen.DataDefinition;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.WhenBlock;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>When Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.WhenBlockImpl#getAction <em>Action</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.WhenBlockImpl#getDataDefinition <em>Data Definition</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.WhenBlockImpl#getAuthorization <em>Authorization</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WhenBlockImpl extends MinimalEObjectImpl.Container implements WhenBlock
{
  /**
   * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
  protected HttpServerAce action;

  /**
   * The cached value of the '{@link #getDataDefinition() <em>Data Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataDefinition()
   * @generated
   * @ordered
   */
  protected DataDefinition dataDefinition;

  /**
   * The cached value of the '{@link #getAuthorization() <em>Authorization</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAuthorization()
   * @generated
   * @ordered
   */
  protected Authorization authorization;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WhenBlockImpl()
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
    return AceGenPackage.Literals.WHEN_BLOCK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpServerAce getAction()
  {
    if (action != null && action.eIsProxy())
    {
      InternalEObject oldAction = (InternalEObject)action;
      action = (HttpServerAce)eResolveProxy(oldAction);
      if (action != oldAction)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AceGenPackage.WHEN_BLOCK__ACTION, oldAction, action));
      }
    }
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HttpServerAce basicGetAction()
  {
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAction(HttpServerAce newAction)
  {
    HttpServerAce oldAction = action;
    action = newAction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.WHEN_BLOCK__ACTION, oldAction, action));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DataDefinition getDataDefinition()
  {
    return dataDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDataDefinition(DataDefinition newDataDefinition, NotificationChain msgs)
  {
    DataDefinition oldDataDefinition = dataDefinition;
    dataDefinition = newDataDefinition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AceGenPackage.WHEN_BLOCK__DATA_DEFINITION, oldDataDefinition, newDataDefinition);
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
  public void setDataDefinition(DataDefinition newDataDefinition)
  {
    if (newDataDefinition != dataDefinition)
    {
      NotificationChain msgs = null;
      if (dataDefinition != null)
        msgs = ((InternalEObject)dataDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.WHEN_BLOCK__DATA_DEFINITION, null, msgs);
      if (newDataDefinition != null)
        msgs = ((InternalEObject)newDataDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.WHEN_BLOCK__DATA_DEFINITION, null, msgs);
      msgs = basicSetDataDefinition(newDataDefinition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.WHEN_BLOCK__DATA_DEFINITION, newDataDefinition, newDataDefinition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Authorization getAuthorization()
  {
    return authorization;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAuthorization(Authorization newAuthorization, NotificationChain msgs)
  {
    Authorization oldAuthorization = authorization;
    authorization = newAuthorization;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AceGenPackage.WHEN_BLOCK__AUTHORIZATION, oldAuthorization, newAuthorization);
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
  public void setAuthorization(Authorization newAuthorization)
  {
    if (newAuthorization != authorization)
    {
      NotificationChain msgs = null;
      if (authorization != null)
        msgs = ((InternalEObject)authorization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.WHEN_BLOCK__AUTHORIZATION, null, msgs);
      if (newAuthorization != null)
        msgs = ((InternalEObject)newAuthorization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.WHEN_BLOCK__AUTHORIZATION, null, msgs);
      msgs = basicSetAuthorization(newAuthorization, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.WHEN_BLOCK__AUTHORIZATION, newAuthorization, newAuthorization));
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
      case AceGenPackage.WHEN_BLOCK__DATA_DEFINITION:
        return basicSetDataDefinition(null, msgs);
      case AceGenPackage.WHEN_BLOCK__AUTHORIZATION:
        return basicSetAuthorization(null, msgs);
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
      case AceGenPackage.WHEN_BLOCK__ACTION:
        if (resolve) return getAction();
        return basicGetAction();
      case AceGenPackage.WHEN_BLOCK__DATA_DEFINITION:
        return getDataDefinition();
      case AceGenPackage.WHEN_BLOCK__AUTHORIZATION:
        return getAuthorization();
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
      case AceGenPackage.WHEN_BLOCK__ACTION:
        setAction((HttpServerAce)newValue);
        return;
      case AceGenPackage.WHEN_BLOCK__DATA_DEFINITION:
        setDataDefinition((DataDefinition)newValue);
        return;
      case AceGenPackage.WHEN_BLOCK__AUTHORIZATION:
        setAuthorization((Authorization)newValue);
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
      case AceGenPackage.WHEN_BLOCK__ACTION:
        setAction((HttpServerAce)null);
        return;
      case AceGenPackage.WHEN_BLOCK__DATA_DEFINITION:
        setDataDefinition((DataDefinition)null);
        return;
      case AceGenPackage.WHEN_BLOCK__AUTHORIZATION:
        setAuthorization((Authorization)null);
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
      case AceGenPackage.WHEN_BLOCK__ACTION:
        return action != null;
      case AceGenPackage.WHEN_BLOCK__DATA_DEFINITION:
        return dataDefinition != null;
      case AceGenPackage.WHEN_BLOCK__AUTHORIZATION:
        return authorization != null;
    }
    return super.eIsSet(featureID);
  }

} //WhenBlockImpl
