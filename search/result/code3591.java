 public CDOResource getOrCreateResource(String path){  try     {  CDOID id = getResourceID(path);  if (!CDOIDUtil.isNull(id))       {  return (CDOResource)getObject(id); } } } 
