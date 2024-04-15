 public class CommitTransactionIndication extends CDOServerIndication{  private CDORevisionImpl[] dirtyObjects;  private Map<CDOID, CDOID> idMappings = new HashMap();  private long timeStamp; } 
