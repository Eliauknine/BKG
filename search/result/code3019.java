  protected void attributeChangeControlPressed(DialogField field) {  if (field == attributeClassDialogField) {  // attributeClass = chooseAttributeType().getFullyQualifiedName();  attributeClass = chooseAttributeType();  if (attributeClass != null) {  attributeClassDialogField.setText(attributeClass); 			} 		} } }
