	 */ public boolean inspectChanges(  ESLocalProject localProject,  ESChangePackage changePackage,  ESModelElementIdToEObjectMapping idToEObjectMapping) {  final ChangePackage internalChangePackage = ((ESChangePackageImpl) changePackage).toInternalAPI();  final ProjectSpace projectSpace = ((ESLocalProjectImpl) localProject).toInternalAPI();  if (internalChangePackage.getOperations().isEmpty()) {  RunInUI.run(new Callable<Void>() {  public Void call() throws Exception {  MessageDialog } } } } 
