package com.anfelisa.extensions.java

import com.anfelisa.ace.Attribute
import com.anfelisa.ace.Model
import com.anfelisa.ace.PrimitiveAttribute
import com.google.inject.Inject

class PrimitiveAttributeExtension {

	@Inject
	extension ModelExtension
	
	def String declaration(PrimitiveAttribute it) '''
		«IF constraint !== null»
			@«constraint»
		«ENDIF»
		private «javaType» «name.toFirstLower»«IF type.equals('Boolean')» = false«ENDIF»;
	'''
	
	def String javaType(PrimitiveAttribute it) '''«IF list»java.util.List<«ENDIF»«IF type.equals('DateTime')»org.joda.time.DateTime«ELSE»«type»«ENDIF»«IF list»>«ENDIF»'''

	def String sqlType(PrimitiveAttribute it) {
		switch type {
      		case 'Integer' : "integer"
      		case 'Long' : "bigint"
      		case 'String' : "character varying"
      		case 'Float' : "numeric"
      		case 'Boolean' : "boolean"
      		case 'DateTime' : "timestamp with time zone"
    	}
	}
	
	def String mapperInit(PrimitiveAttribute it) '''«IF isList»null«ELSEIF type.equals("DateTime")»r.getTimestamp("«name»") != null ? new org.joda.time.DateTime(r.getTimestamp("«name»")) : null«ELSEIF type.equals("Integer")»r.getObject("«name»") != null ? r.getInt("«name»") : null«ELSEIF type.equals("Serial")»r.getInt("«name»")«ELSE»r.get«javaType»("«name»")«ENDIF»'''

	def String param(PrimitiveAttribute it, boolean jsonProperty) '''«IF jsonProperty»@JsonProperty("«name»") «ENDIF»«javaType» «name»'''
	
	def String resourceParamType(PrimitiveAttribute it) '''«IF type.equals('DateTime')»String«ELSE»«type»«ENDIF»'''
	
	def String resourceParam(PrimitiveAttribute it) '''«IF type.equals('DateTime')»new DateTime(«name»).withZone(DateTimeZone.UTC)«ELSE»«name»«ENDIF»'''
	
	def String bind(PrimitiveAttribute it, String modelName) '''
		statement.bind("«name»", «modelName».get«name.toFirstUpper»());
	'''
	
	def String tableName(PrimitiveAttribute it) '''«((eContainer as Attribute).eContainer as Model).table»'''
	
	def String tableDefinition(PrimitiveAttribute it, String tableName) '''«name.toLowerCase» «sqlType» «IF constraint !== null && constraint.equals('NotNull')»NOT NULL «ENDIF» '''
	
	def String primaryKey(PrimitiveAttribute it, String tableName) '''«IF isPrimaryKey», CONSTRAINT «tableName»_pkey PRIMARY KEY («name.toLowerCase»)«ENDIF»'''
	
	def String foreignKey(PrimitiveAttribute it, String tableName, String schema) '''«IF foreignKey !== null», CONSTRAINT «tableName»_«name.toLowerCase»_fkey FOREIGN KEY («name.toLowerCase») REFERENCES «schema».«foreignKey.tableName» ( «foreignKey.name.toLowerCase» ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE«ENDIF»'''
	
	def String uniqueConstraint(PrimitiveAttribute it, String tableName) '''«IF unique», CONSTRAINT «tableName»_«name»_unique UNIQUE («name»)«ENDIF»'''

	def String interfaceGetter(PrimitiveAttribute it) '''«javaType» get«name.toFirstUpper»();'''
	
	def String getter(PrimitiveAttribute it, boolean jsonProperty) '''
		«IF jsonProperty»@JsonProperty«ENDIF»
		public «javaType» get«name.toFirstUpper»() {
			return this.«name»;
		}'''
	
	def String getterCall(PrimitiveAttribute it) '''get«name.toFirstUpper»()'''
	def String setterCall(PrimitiveAttribute it, String param) '''set«name.toFirstUpper»(«param»)'''
	
	def String setter(PrimitiveAttribute it) '''
		public void set«name.toFirstUpper»(«javaType» «name») {
			this.«name» = «name»;
		}'''
	
	def String initializer(PrimitiveAttribute it, String className) '''
		public «className» with«name.toFirstUpper»(«javaType» «name») {
			this.«name» = «name»;
			return this;
		}'''
	
	def String assign(PrimitiveAttribute it) '''this.«name» = «name»;'''
	
}