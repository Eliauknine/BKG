 public synchronized void setPassiveUpdateEnabled(boolean passiveUpdateEnabled){  getSessionProtocol().setPassiveUpdate(allRevisions, initialChunkSize, passiveUpdateEnabled);        } 
