 protected void indicatingCommit(){  commitContext.write(); if (commitContext.getRollbackMessage() == null)     {  commitContext.commit();   }   } 
