 							.isGenerateViewModelOptionSelected(); final IDEViewModelRegistry registry = getViewModelRegistry();  if (registry != null) {  final VView view = registry.createViewModel(modelFile, selectedEClass, selectedEcore);  if (generateViewModelControls) {  ControlGenerator.generateAllControls(view); 							} 						}  // Open the view }
