 public abstract class AbstractCDORevision implements InternalCDORevision{  private static final PerfTracer WRITING = new PerfTracer(OM.PERF_REVISION_WRITING, AbstractCDORevision.class);  private CDOClassInfo classAdapter;  private CDOID id; } 
