 public void registerProxyResource(CDOResourceImpl resource){  try     {  CDOID id = getResourceID(path);  resource.cdoInternalSetID(id);  registerObject(resource);     } } 
