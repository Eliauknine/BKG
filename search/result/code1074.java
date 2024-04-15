 @Override  public void clearCache() {  if (resourceSet == null) {   return;  }  for (final Resource r : resourceSet.getResources()) {   r.unload();  }  resourceSet = null; 	} 
