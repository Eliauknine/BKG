 public boolean inspectChanges({  final ESChangePackage changePackage, ESModelElementIdToEObjectMapping idToEObjectMapping) {  final ESChangePackageImpl internalChangePackage = (ESChangePackageImpl) changePackage;  final ESLocalProjectImpl localProjectImpl = (ESLocalProjectImpl) localProject;  final CommitDialog commitDialog = new CommitDialog(getShell(),  internalChangePackage.toInternalAPI(),  localProjectImpl.toInternalAPI(), 			((ESModelElementIdToEObjectMappingImpl) idToEObjectMapping).toInternalAPI()); } } 
