 public void testDetachProxyResource() throws Exception{  msg("Creating resource"); CDOResource resource = transaction.getResource("/test1");   msg("Deleting resource");  resource.delete(null);  transaction.commit();     } 
