/********************************************************************************
 * Copyright (c) 2020 Annette Pohl
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/




package de.acegen.extensions.java

import de.acegen.aceGen.Attribute
import de.acegen.aceGen.AttributeParamRef
import de.acegen.aceGen.BooleanType
import de.acegen.aceGen.JsonArray
import de.acegen.aceGen.JsonDateTime
import de.acegen.aceGen.JsonObjectAce
import de.acegen.aceGen.JsonValue
import de.acegen.aceGen.LongType
import de.acegen.aceGen.Model
import de.acegen.aceGen.NullType
import de.acegen.aceGen.PrimitiveValue
import de.acegen.aceGen.StringType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.ArrayList
import java.util.List
import javax.inject.Inject

class AttributeExtension {

	@Inject
	extension ModelExtension;

	public String stringLineBreak = '''," + 
"'''

	def String resourceParamType(
		Attribute it) '''String'''

	def String resourceParam(
		Attribute it) '''«IF type !== null && type.equals('DateTime')»LocalDateTime.parse(«name», DateTimeFormatter.ISO_DATE_TIME)«ELSE»«name»«ENDIF»'''

	def String initActionData(AttributeParamRef it) '''
		«IF attribute.type !== null && attribute.type.equals('DateTime') && !attribute.list»
			«IF notNull»
				if (StringUtils.isBlank(«attribute.name») || "null".equals(«attribute.name»)) {
					return badRequest("«attribute.name» is mandatory");
				}
			«ENDIF»
			if (StringUtils.isNotBlank(«attribute.name»)) {
				try {
					actionData.«attribute.setterCall(attribute.resourceParam)»;
				} catch (Exception x) {
					LOG.warn("failed to parse dateTime «attribute.name» - {}", «attribute.name»);
				}
			}
		«ELSE»
			«IF notNull»
				if (StringUtils.isBlank(«attribute.name») || "null".equals(«attribute.name»)) {
					return badRequest("«attribute.name» is mandatory");
				}
			«ENDIF»
			«IF "Integer".equals(attribute.type)»
				actionData.«attribute.setterCall(attribute.resourceParam, attribute.type, "Int")»;
			«ELSEIF "String".equals(attribute.type)»
				actionData.«attribute.setterCall(attribute.resourceParam)»;
			«ELSE»
				actionData.«attribute.setterCall(attribute.resourceParam, attribute.type)»;
			«ENDIF»
		«ENDIF»
	'''

	def String initActionDataFromPayload(AttributeParamRef it) '''
		«IF notNull»
			«IF "String".equals(attribute.type) && !attribute.list»
				if (StringUtils.isBlank(payload.«attribute.getterCall») || "null".equals(payload.«attribute.getterCall»)) {
					return badRequest("«attribute.name» is mandatory");
				}
			«ELSE»
				if (payload.«attribute.getterCall» == null) {
					return badRequest("«attribute.name» is mandatory");
				}
			«ENDIF»
		«ENDIF»
		actionData.«attribute.setterCall('''payload.«attribute.getterCall»''')»;
	'''

	def String getterCall(Attribute it) {
		return '''get«name.toFirstUpper»()''';
	}

	def String javaType(Attribute it) {
		if (type !== null) {
			return '''«IF list»java.util.List<«ENDIF»«IF type.equals('DateTime')»java.time.LocalDateTime«ELSE»«type»«ENDIF»«IF list»>«ENDIF»''';
		}
		if (model !== null) {
			return '''«IF list»java.util.List<«ENDIF»«model.interfaceWithPackage»«IF list»>«ENDIF»'''
		}
	}

	def String javaTypeNew(Attribute it) {
		if (type !== null) {
			return '''«IF list»java.util.ArrayList<«ENDIF»«IF type.equals('DateTime')»java.time.LocalDateTime«ELSE»«type»«ENDIF»«IF list»>«ENDIF»''';
		}
		if (model !== null) {
			return '''«IF list»java.util.ArrayList<«ENDIF»«model.interfaceWithPackage»«IF list»>«ENDIF»'''
		}
	}

	def List<Integer> timesIterator(int length) {
		var list = new ArrayList();
		for (var i = 0; i < length; i++) {
			list.add(i);
		}
		return list;
	}

	def String mapperInit(Attribute it) {
		if (type !== null) {
			return '''«IF isList»null«ELSEIF type.equals("DateTime")»r.getTimestamp("«name»") != null ? r.getTimestamp("«name»").toLocalDateTime() : null«ELSEIF type.equals("Integer")»r.getObject("«name»") != null ? r.getInt("«name»") : null«ELSEIF type.equals("Serial")»r.getInt("«name»")«ELSE»r.get«javaType»("«name»")«ENDIF»'''
		}
		if (model !== null) {
			return '''null''';
		}
	}

	def String sqlType(Attribute it) {
		if (type !== null) {
			switch type {
				case 'Integer': "integer"
				case 'Long': "bigint"
				case 'String': "character varying"
				case 'Float': "numeric"
				case 'Boolean': "boolean"
				case 'DateTime': "timestamp with time zone"
			}
		}
	}

	def String randomValue(Attribute it) {
		if (type !== null) {
			switch type {
				case 'Integer': "random.nextInt(50)"
				case 'Long': "random.nextLong()"
				case 'String': "randomString(random)"
				case 'Float': "random.nextFloat()"
				case 'Boolean': "random.nextBoolean()"
				case 'DateTime': "random.nextBoolean() ? java.time.LocalDateTime.now().plusMinutes(random.nextInt(60)) : java.time.LocalDateTime.now().minusMinutes(random.nextInt(60)) "
			}
		}
	}

	def String tableName(Attribute it) {
		if (type !== null) {
			'''«(eContainer as Model).tableFkRef»'''
		}
	}

	def String declaration(Attribute it) {
		if (type !== null) {
			return '''
				private «javaType» «name.toFirstLower»«IF type.equals('Boolean')» = false«ENDIF»;
			'''
		}
		if (model !== null) {
			return '''
				private «javaType» «name»;
			'''
		}
	}

	def String paramAsJsonProperty(Attribute it) '''@JsonProperty("«name»") «param»'''

	def String param(Attribute it) '''«javaType» «name»'''

	def String interfaceGetter(Attribute it) '''«javaType» get«name.toFirstUpper»();'''

	def String interfaceSetter(Attribute it) '''void set«name.toFirstUpper»(«javaType» «name.toFirstLower»);'''

	def String assign(Attribute it) '''this.«name» = «name»;'''

	def String getter(Attribute it, boolean jsonProperty) '''
		«IF jsonProperty»
			@JsonProperty
			«IF type !== null && type.equals('DateTime')»@JsonSerialize(converter = DateTimeToStringConverter.class)
			@JsonDeserialize(converter = StringToDateTimeConverter.class)«ENDIF»
		«ENDIF»
		public «javaType» get«name.toFirstUpper»() {
			return this.«name»;
		}
	'''

	def String with(Attribute it, Model model) '''
		public «model.dataInterfaceName» with«name.toFirstUpper»(«javaType» «name») {
			this.«name» = «name»;
			return this;
		}
	'''

	def String setter(Attribute it) '''
		public void set«name.toFirstUpper»(«javaType» «name») {
			this.«name» = «name»;
		}
	'''

	def String setterCall(Attribute it, String param) '''set«name.toFirstUpper»(«param»)'''

	def String setterCall(Attribute it, String param, String type) '''set«name.toFirstUpper»("null".equals(«param») ? null : «type».parse«type.toFirstUpper»(«param»))'''

	def String setterCall(Attribute it, String param, String type, String parse) '''set«name.toFirstUpper»("null".equals(«param») ? null : «type».parse«parse»(«param»))'''

	def boolean isPrimitive(Attribute it) {
		return !list && model === null;
	}

	def LocalDateTime dateTimeParse(String dateString, String pattern) {
		try {
			return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(pattern));
		} catch (Exception x) {
			return null;
		}
	}

	def dispatch CharSequence valueFrom(
		JsonObjectAce it) '''«IF it !== null && members !== null && members.size > 0»{ «FOR member : members SEPARATOR stringLineBreak»\"«member.attribute.name»\" : «member.value.valueFrom()»«ENDFOR»}«ELSE»{}«ENDIF»'''

	def dispatch CharSequence valueFrom(String it) {
		return valueFromString
	}

	def dispatch CharSequence valueFrom(JsonValue it) {
		if (it instanceof StringType) {
			return '''\"«string.valueFromString»\"''';
		} else if (it instanceof BooleanType) {
			return boolean;
		} else if (it instanceof NullType) {
			return "null";
		} else if (it instanceof LongType) {
			return '''«long»''';
		}
	}

	def CharSequence valueFromString(String it) {
		var returnString = it;
		if (it.contains("${random}")) {
			returnString = returnString.replace("${random}", '''" + this.randomString() + "''');
		}
		if (it.contains("${testId}")) {
			returnString = returnString.replace("${testId}", '''" + this.getTestId() + "''');
		}
		while (returnString.contains("${")) {
			val beginIndex = returnString.indexOf("${")
			val endIndex = returnString.indexOf("}")
			val templateString = returnString.substring(beginIndex, endIndex + 1)
			val templateStringName = returnString.substring(beginIndex + 2, endIndex)

			returnString = returnString.replace(
				templateString, '''" + this.extractedValues.get("«templateStringName»").toString() + "''');
		}
		return '''«returnString»''';
	}

	def dispatch CharSequence valueFrom(
		JsonArray it) '''«IF it !== null && values !== null && values.size > 0»[ «FOR value : values SEPARATOR stringLineBreak»«value.valueFrom»«ENDFOR»]«ELSE»[]«ENDIF»'''

	def dispatch CharSequence valueFrom(JsonDateTime it) {
		if (dateTime.contains("${")) {
			val beginIndex = dateTime.indexOf("${")
			val endIndex = dateTime.indexOf("}")
			val templateStringName = dateTime.substring(beginIndex + 2, endIndex)
			return '''\"" + LocalDateTime.parse(this.extractedValues.get("«templateStringName»").toString(), DateTimeFormatter.ofPattern("«pattern»"))  + "\"''';
		}
		return '''\"«dateTimeParse(dateTime, pattern)»\"'''
	}

	def primitiveValueFrom(PrimitiveValue it) {
		if (string !== null) {
			var returnString = string;
			if (string.contains("${testId}")) {
				returnString = returnString.replace("${testId}", '''" + this.getTestId() + "''');
			} else if (string.contains("${")) {
				val beginIndex = string.indexOf("${")
				val endIndex = string.indexOf("}")
				val templateString = string.substring(beginIndex, endIndex + 1)
				val templateStringName = string.substring(beginIndex + 2, endIndex)
				returnString = returnString.replace(
					templateString, '''" + this.extractedValues.get("«templateStringName»").toString() + "''');
			}
			return '''"«returnString»"''';
		}
		return getLong()
	}

}
/******* S.D.G. *******/
