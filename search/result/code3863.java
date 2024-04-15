 public void handleInvalidation(long timeStamp, Set<CDOIDAndVersion> dirtyOIDs, C{  if (cdoObject != null)      {  CDOStateMachine.INSTANCE.invalidate(cdoObject, true, timeStamp);       }     } 
