 public synchronized void detachObject(InternalCDOObject object){  else    {  getLastSavepoint().getDetachedObjects().put(id, object);  if (!formerRevisionKeys.containsKey(object))       {  CDORevisionKey revKey = CDORevisionUtil.copyRevisionKey(object.cdoRevision());  formerRevisionKeys.put(object, revKey);       }  if (!cleanRevisions.containsKey(object))       { } } } 
