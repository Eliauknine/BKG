 	 */ protected void deleteRows(List<EObject> deletionList) {  final EditingDomain editingDomain = getModelElementContext().getEditingDomain();  final EObject modelElement = getModelElementContext().getModelElement();  editingDomain.getCommandStack().execute(  RemoveCommand.create(editingDomain, modelElement, getStructuralFeature(), deletionList)); 	}  /** }
