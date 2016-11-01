/*
 * generated by Xtext 2.10.0
 */
package com.anfelisa.serializer;

import com.anfelisa.ace.AcePackage;
import com.anfelisa.ace.Attribute;
import com.anfelisa.ace.Command;
import com.anfelisa.ace.Data;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.EventOnOutcome;
import com.anfelisa.ace.Model;
import com.anfelisa.ace.Project;
import com.anfelisa.ace.View;
import com.anfelisa.ace.ViewFunction;
import com.anfelisa.services.AceGrammarAccess;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;

@SuppressWarnings("all")
public class AceSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private AceGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == AcePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case AcePackage.ACTION:
				sequence_Action(context, (com.anfelisa.ace.Action) semanticObject); 
				return; 
			case AcePackage.ATTRIBUTE:
				sequence_Attribute(context, (Attribute) semanticObject); 
				return; 
			case AcePackage.COMMAND:
				sequence_Command(context, (Command) semanticObject); 
				return; 
			case AcePackage.DATA:
				sequence_Data(context, (Data) semanticObject); 
				return; 
			case AcePackage.EVENT:
				sequence_Event(context, (Event) semanticObject); 
				return; 
			case AcePackage.EVENT_ON_OUTCOME:
				sequence_EventOnOutcome(context, (EventOnOutcome) semanticObject); 
				return; 
			case AcePackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case AcePackage.PROJECT:
				sequence_Project(context, (Project) semanticObject); 
				return; 
			case AcePackage.VIEW:
				sequence_View(context, (View) semanticObject); 
				return; 
			case AcePackage.VIEW_FUNCTION:
				sequence_ViewFunction(context, (ViewFunction) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Action returns Action
	 *
	 * Constraint:
	 *     (type=FunctionType? name=ID data=[Data|QualifiedName]? command=[Command|QualifiedName]?)
	 */
	protected void sequence_Action(ISerializationContext context, com.anfelisa.ace.Action semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Attribute returns Attribute
	 *
	 * Constraint:
	 *     (unique?='Unique'? constraint=Constraint? type=ModelType name=ID)
	 */
	protected void sequence_Attribute(ISerializationContext context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Command returns Command
	 *
	 * Constraint:
	 *     (name=ID data=[Data|QualifiedName]? eventsOnOutcome+=EventOnOutcome*)
	 */
	protected void sequence_Command(ISerializationContext context, Command semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Data returns Data
	 *
	 * Constraint:
	 *     (name=ID models+=[Model|QualifiedName]*)
	 */
	protected void sequence_Data(ISerializationContext context, Data semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EventOnOutcome returns EventOnOutcome
	 *
	 * Constraint:
	 *     (outcome=ID events+=[Event|QualifiedName]* actions+=[Action|QualifiedName]*)
	 */
	protected void sequence_EventOnOutcome(ISerializationContext context, EventOnOutcome semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Event returns Event
	 *
	 * Constraint:
	 *     (name=ID data=[Data|QualifiedName]? listeners+=[ViewFunction|QualifiedName]*)
	 */
	protected void sequence_Event(ISerializationContext context, Event semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (persistent?='persistent'? name=ID attributes+=Attribute*)
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Project returns Project
	 *
	 * Constraint:
	 *     (
	 *         name=QualifiedName 
	 *         (target='ES6' | target='JAVA') 
	 *         models+=Model* 
	 *         data+=Data* 
	 *         actions+=Action* 
	 *         commands+=Command* 
	 *         events+=Event* 
	 *         views+=View*
	 *     )
	 */
	protected void sequence_Project(ISerializationContext context, Project semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ViewFunction returns ViewFunction
	 *
	 * Constraint:
	 *     (name=ID data=[Data|QualifiedName]?)
	 */
	protected void sequence_ViewFunction(ISerializationContext context, ViewFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     View returns View
	 *
	 * Constraint:
	 *     (name=ID renderFunctions+=ViewFunction*)
	 */
	protected void sequence_View(ISerializationContext context, View semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
