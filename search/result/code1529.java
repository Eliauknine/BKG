 	} private def JsonObject withTypeProperties(JsonObject jsonObject, EClassifier eClassifier, int upper) {  if (upper > 1) { 			jsonObject.withType("array") 			jsonObject.with("items", new JsonObject().withTypeProperties(eClassifier)) 		} else { } }
