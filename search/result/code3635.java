 public void postCommit(CommitTransactionResult result){               ((InternalCDORevisionDelta)dirtyObjectDelta).adjustReferences(result.getReferenceAdjuster());            } 
