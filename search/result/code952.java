 @Override  public void doSave(IProgressMonitor monitor) {  try {  resource.save(null);  basicCommandStack.saveIsDone();  firePropertyChange(IEditorPart.PROP_DIRTY); 		} catch (final IOException e) {  Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e)); 		} 	}  @Override  public void doSaveAs() { 	}  @Override 
