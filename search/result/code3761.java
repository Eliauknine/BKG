 private Session session;  public OpenSessionIndication()   {   }  @Override  protected short getSignalID()   {  return CDOProtocolConstants.SIGNAL_OPEN_SESSION;   }  @Override 
