 public void notifyEvent(IEvent event){     { if (event instanceof CDOTransactionFinishedEvent)       {  CDOTransactionFinishedEvent e = (CDOTransactionFinishedEvent)event;  if (e.getType() == CDOTransactionFinishedEvent.Type.COMMITTED)         {    Map<CDOID, CDOID> idMappings = e.getIDMappings();    HashSet<CDOID> newOIDs = new HashSet<CDOID>(idMappings.values());    new ItemsProcessor(view)    {    @Override    protected void processCDOObject(TreeViewer viewer, InternalCDOObject cdoObject)    {    viewer.update(cdoObject.cdoInternalInstance(), null);    }    }.processCDOObjects(treeViewer, newOIDs);         }  else         {  try           { } } } } } 
