/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.acegen.aceGen.AceGenPackage
 * @generated
 */
public interface AceGenFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AceGenFactory eINSTANCE = de.acegen.aceGen.impl.AceGenFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Project</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Project</em>'.
   * @generated
   */
  Project createProject();

  /**
   * Returns a new object of class '<em>Http Client</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Client</em>'.
   * @generated
   */
  HttpClient createHttpClient();

  /**
   * Returns a new object of class '<em>Http Client Ace</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Client Ace</em>'.
   * @generated
   */
  HttpClientAce createHttpClientAce();

  /**
   * Returns a new object of class '<em>Http Client Outcome</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Client Outcome</em>'.
   * @generated
   */
  HttpClientOutcome createHttpClientOutcome();

  /**
   * Returns a new object of class '<em>Http Client State Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Client State Function</em>'.
   * @generated
   */
  HttpClientStateFunction createHttpClientStateFunction();

  /**
   * Returns a new object of class '<em>Http Client State Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Client State Element</em>'.
   * @generated
   */
  HttpClientStateElement createHttpClientStateElement();

  /**
   * Returns a new object of class '<em>Http Client Type Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Client Type Definition</em>'.
   * @generated
   */
  HttpClientTypeDefinition createHttpClientTypeDefinition();

  /**
   * Returns a new object of class '<em>Http Server</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Server</em>'.
   * @generated
   */
  HttpServer createHttpServer();

  /**
   * Returns a new object of class '<em>Http Server Ace</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Server Ace</em>'.
   * @generated
   */
  HttpServerAce createHttpServerAce();

  /**
   * Returns a new object of class '<em>Http Server Ace Write</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Server Ace Write</em>'.
   * @generated
   */
  HttpServerAceWrite createHttpServerAceWrite();

  /**
   * Returns a new object of class '<em>Http Server Outcome</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Server Outcome</em>'.
   * @generated
   */
  HttpServerOutcome createHttpServerOutcome();

  /**
   * Returns a new object of class '<em>Http Server Ace Read</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Server Ace Read</em>'.
   * @generated
   */
  HttpServerAceRead createHttpServerAceRead();

  /**
   * Returns a new object of class '<em>Http Server View</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Server View</em>'.
   * @generated
   */
  HttpServerView createHttpServerView();

  /**
   * Returns a new object of class '<em>Http Server View Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Http Server View Function</em>'.
   * @generated
   */
  HttpServerViewFunction createHttpServerViewFunction();

  /**
   * Returns a new object of class '<em>Auth User</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Auth User</em>'.
   * @generated
   */
  AuthUser createAuthUser();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Scenario</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scenario</em>'.
   * @generated
   */
  Scenario createScenario();

  /**
   * Returns a new object of class '<em>Given Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Given Ref</em>'.
   * @generated
   */
  GivenRef createGivenRef();

  /**
   * Returns a new object of class '<em>When Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>When Block</em>'.
   * @generated
   */
  WhenBlock createWhenBlock();

  /**
   * Returns a new object of class '<em>Then Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Then Block</em>'.
   * @generated
   */
  ThenBlock createThenBlock();

  /**
   * Returns a new object of class '<em>Data Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Definition</em>'.
   * @generated
   */
  DataDefinition createDataDefinition();

  /**
   * Returns a new object of class '<em>Authorization</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Authorization</em>'.
   * @generated
   */
  Authorization createAuthorization();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Json Date Time</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Date Time</em>'.
   * @generated
   */
  JsonDateTime createJsonDateTime();

  /**
   * Returns a new object of class '<em>Json Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Object</em>'.
   * @generated
   */
  JsonObject createJsonObject();

  /**
   * Returns a new object of class '<em>Json Member</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Member</em>'.
   * @generated
   */
  JsonMember createJsonMember();

  /**
   * Returns a new object of class '<em>Json Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Value</em>'.
   * @generated
   */
  JsonValue createJsonValue();

  /**
   * Returns a new object of class '<em>Json Array</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json Array</em>'.
   * @generated
   */
  JsonArray createJsonArray();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AceGenPackage getAceGenPackage();

} //AceGenFactory
