 public String toHtml(){ 		// [/protected]		[let valueType : String = aProperty.valueType.toString()] 			[if (Sequence{'String', 'XMLLiteral', 'DateTime', 'URI'}->includes(valueType))] 				s= s + [resourcePropertyAsTextInputForCreation(aProperty) /]; 			[elseif(valueType = 'Boolean')] 				s= s + "<input name=\"[aProperty.name/]\" type=\"radio\" value=\"true\">True<br><input name=\"[aProperty.name/]\" type=\"radio\" value=\"false\">False"; } 
