   */ public void queryResources(QueryResourcesContext context)   {  IView view = getView();  for (CDORevision revision : getStore().getCurrentRevisions())     {  if (revision.isResource()) } } 
