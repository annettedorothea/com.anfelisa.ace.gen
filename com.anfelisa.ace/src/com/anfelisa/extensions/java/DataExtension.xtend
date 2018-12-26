package com.anfelisa.extensions.java

import com.anfelisa.ace.Attribute
import com.anfelisa.ace.Data
import com.anfelisa.ace.JAVA
import java.util.ArrayList
import java.util.List
import javax.inject.Inject

class DataExtension {
		
	@Inject
	extension AttributeExtension
	
	def String dataName(Data it) '''«IF it !== null»«name.toFirstUpper»Data«ELSE»IDataContainer«ENDIF»'''
	def String presentationalDataName(Data it) '''«name.toFirstUpper»PresentationalData'''
	def String presentationalDataInterfaceName(Data it) '''I«name.toFirstUpper»PresentationalData'''
	def String dataInterfaceName(Data it) '''«IF it !== null»I«name.toFirstUpper»Data«ELSE»IDataContainer«ENDIF»'''
	def String dataNameWithPackage(Data it) '''«(eContainer as JAVA).name».data.«name.toFirstUpper»Data'''
	
	def String dataImport(Data it) '''
		«IF it !== null»
			import «(eContainer as JAVA).name».data.«dataName»;
		«ELSE»
			import com.anfelisa.ace.IDataContainer;
		«ENDIF»
	'''
	
	def String dataParamType(Data it) '''«IF it !== null»«dataName»«ELSE»IDataContainer«ENDIF»'''
	
	def List<Attribute> allAttributes(Data it) {
		val attrs = new ArrayList<Attribute>();
		for (model : models) {
			for (attribute : model.model.attributes) {
				if (!attrs.containsAttribute(attribute)) {
					attrs.add(attribute)
				}
			}
		}
		return attrs;
	}
	
	def boolean containsAttribute(List<Attribute> it, Attribute attribute) {
		if (size == 0) {
			return false
		} else {
			for (attr : it) {
				if (attr.name.equals(attribute.name)) {
					return true
				}
			}
		}
	}
	
	def newFromCommandData(Data it) '''new «dataNameWithPackage»(
			«FOR attribute : allAttributes SEPARATOR ',' AFTER ','»
				this.commandData.«attribute.getterCall»
			«ENDFOR»
			this.commandData.getUuid()
		)'''
	
	def String listGetter(Data it) '''
		@JsonProperty
		public List<«dataNameWithPackage»> get«dataName.toFirstUpper»List() {
			return this.«dataName.toFirstLower»List;
		}'''
	
	def String listSetter(Data it) '''
		public void set«dataName.toFirstUpper»List(List<«dataNameWithPackage»> «dataName.toFirstLower»List) {
			this.«dataName.toFirstLower»List = «dataName.toFirstLower»List;
		}'''
	
	
	
}