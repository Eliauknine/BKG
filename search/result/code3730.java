 protected void indicationTransaction(CDODataInput in) throws Exception{   { int viewID = in.readInt();  commitContext = new XATransactionCommitContext(getTransaction(viewID));   } } 
