  final ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage(); try {  for (final AbstractOperation operation : operationsHandle.iterable()) {  changePackage.add(operation); 			} 		} finally {  operationsHandle.close(); } }
