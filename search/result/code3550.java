 public void write(CDODataOutput out, int referenceChunk) throws IOException   {  CDOClassifierRef classRef = new CDOClassifierRef(getEClass());  if (TRACER.isEnabled())     {  TRACER           .format(  "Writing revision: ID={0}, className={1}, version={2}, created={3}, revised={4}, resource={5}, container={6}, featureID={7}",   id, getEClass().getName(), getVersion(), created, revised, resourceID, containerID, containingFeatureID);     }  WRITING.start(this); } 
