 public void cdoInternalSetView(CDOView view)   {  CDOViewImpl impl = (CDOViewImpl)view;  cdoView = impl;  eSetStore(impl.getStore());   }  public void cdoInternalSetResource(CDOResource resource) 
