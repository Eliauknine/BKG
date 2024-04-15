 */public interface InternalCDOTransaction extends CDOTransaction, InternalCDOView {  public CDOCommitContext createCommitContext();  public void handleRollback(CDOSavepoint savepoint); } 
