 private int queryID;  public QueryCancelIndication()   {   }  @Override  protected short getSignalID()   {  return CDOProtocolConstants.SIGNAL_QUERY_CANCEL;   }  @Override 
