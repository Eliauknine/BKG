 return false;	}  /** 	 * This method searches for fragments or application model elements 	 * resources 	 */  public static ResourceSet getModelElementResources() {  ResourceSet resourceSet = new ResourceSetImpl();  final PDEExtensionRegistry reg = new PDEExtensionRegistry();  IExtension[] extensions = reg.findExtensions("org.eclipse.e4.workbench.model", true);   final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot(); 
