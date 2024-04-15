 public void testDetachNewResource() throws Exception{  msg("Creating resource");  CDOResource resource = transaction.createResource("/test1");  detachResource(rset, resource);   } 
