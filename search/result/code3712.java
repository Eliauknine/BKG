 public void testTransientResource() throws Exception{  msg("Creating resourceSet");  ResourceSet resourceSet = new ResourceSetImpl();  CDOSessionImpl.prepareResourceSet(resourceSet);  msg("Creating resource");  CDOResource resource = (CDOResource)resourceSet.createResource(uri); } 
