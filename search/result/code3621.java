 protected InternalCDORevision verifyRevision(InternalCDORevision revision, int r{  if (repository.isVerifyingRevisions())    {  accessor = StoreThreadLocal.getAccessor();  revision = (InternalCDORevision)accessor.verifyRevision(revision);     }  ensureChunks(revision, referenceChunk, accessor); } 
