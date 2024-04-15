 public void rollback(InternalCommitContext commitContext){  if (contextEntry != null)     {  contextEntry.getFuture().cancel(true);  commitContext.postCommit(false);     }   } 
