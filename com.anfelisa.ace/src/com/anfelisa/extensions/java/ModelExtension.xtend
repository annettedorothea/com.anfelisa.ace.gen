package com.anfelisa.extensions.java

import com.anfelisa.ace.Attribute
import com.anfelisa.ace.JAVA
import com.anfelisa.ace.Model
import com.anfelisa.ace.ModelRef
import java.util.ArrayList
import java.util.List
import javax.inject.Inject

class ModelExtension {

	@Inject
	extension AttributeExtension
		
	def String modelName(Model it) '''I«name.toFirstUpper»Model'''

	def String modelListAttributeName(Model it) '''«name»List'''
	
	def String modelClassName(Model it) '''«name.toFirstUpper»Model'''
	
	def String modelParam(Model it) '''«name.toFirstLower»Model'''
	
	def String modelDao(Model it) '''«name.toFirstUpper»Dao'''
	
	def String modelMapper(Model it) '''«name.toFirstUpper»Mapper'''
	
	def String table(Model it) '''«name.toLowerCase»'''
	
	def String importModel(Model it) '''import «modelInterfaceWithPackage»;'''
	
	def String modelInterfaceWithPackage(Model it) '''«(eContainer as JAVA).name».models.«modelName»'''
	
	def String modelGetAttribute(Model it, Attribute attribute) 
	''' «modelParam».«attribute.getterCall» '''
	
	def String modelAttributeSqlValue(Model it, Attribute attribute) 
	''':«attribute.name.toLowerCase»'''
	
	def List<Attribute> allUniqueAttributes(Model it) {
		var list = new ArrayList<Attribute>();
		for (attribute : attributes) {
			if (attribute.unique) {
				list.add(attribute);
			}
		}
		return list;
	}
	
	def String listGetter(Model it) '''
		@JsonProperty
		public java.util.List<«modelName»> get«modelListAttributeName.toFirstUpper»() {
			return this.«modelListAttributeName»;
		}'''
	
	def String listSetter(Model it) '''
		public void set«modelListAttributeName.toFirstUpper»(java.util.List<«modelName»> «modelListAttributeName») {
			this.«modelListAttributeName» = «modelListAttributeName»;
		}'''
	
	def String interfaceGetter(ModelRef it) '''«interfaceWithPackage» get«modelRefToUpper»();'''
	
	def String declaration(ModelRef it) '''
		private «interfaceWithPackage» «modelRefToLower»;
	'''
	
	def String interfaceWithPackage(ModelRef it) '''«model.modelInterfaceWithPackage»'''
	
	def String getter(ModelRef it) '''
		@JsonProperty
		public «interfaceWithPackage» get«modelRefToUpper»() {
			return this.«modelRefToLower»;
		}'''
	
	def String setter(ModelRef it) '''
		public void set«modelRefToUpper»(«interfaceWithPackage» «modelRefToLower») {
			this.«modelRefToLower» = «modelRefToLower»;
		}'''
	
	def String modelRefToLower(ModelRef it) '''«model.name.toFirstLower»'''
	
	def String modelRefToUpper(ModelRef it) '''«model.name.toFirstUpper»'''
	
}