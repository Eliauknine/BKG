  synchronized (getConnectLock()) { // If we are currently connected  if (isConnected()) {  final ISynchAsynchConnection conn = getConnection();  synchronized (conn) {  synchronized (getGroupMembershipLock()) { } } } } }
