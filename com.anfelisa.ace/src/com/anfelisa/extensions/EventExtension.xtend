package com.anfelisa.extensions

import com.anfelisa.ace.Event

class EventExtension {
	def String eventName(Event it) '''«name.toFirstUpper»Event'''
}