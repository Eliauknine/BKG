	 * @return the IFile	 */  public IFile getFile(String delta) {  IResource res = ResourcesPlugin.getWorkspace().getRoot().getFile(  new Path(delta));  return res instanceof IFile ? (IFile) res : null; 	} 
