     */ @Override  public void init(IEditorSite site, IEditorInput input) throws PartInitException {  super.init(site, input);  getEditorSite().getPage().addPartListener(_partListener);     } 
