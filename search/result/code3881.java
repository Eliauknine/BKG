 public CDOResource getOrCreateResource(String path)   {  CDOID id = getResourceID(path);  if (id == null || id.isNull())     {  return createResource(path); } } 
