	 * @see org.eclipse.emf.emfstore.internal.client.ui.common.OperationCustomLabelProvider#getImage(org.eclipse.emf.emfstore.internal.server.model.versioning.operations.AbstractOperation)	 */  public Object getImage(AbstractOperation operation) {  init();  final Image image = adapterFactoryLabelProvider.getImage(operation);  dispose();  return image; 	}  /** 
