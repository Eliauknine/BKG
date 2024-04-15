 private void computeDirtyObjects(OMMonitor monitor){  if (!dirtyObjects[i].isWritable())         {  throw new NoPermissionException(dirtyObjects[i]);         }  monitor.worked(); } 
