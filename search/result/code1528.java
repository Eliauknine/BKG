  private def dispatch JsonElement createJsonSchemaElement(EReference reference) {  val jsonObject = new JsonObject  if (reference.upperBound > 1) { 			jsonObject.withType("array") 			jsonObject.with("items", createJsonSchemaElement(reference.EReferenceType))	 		} else { } } }
