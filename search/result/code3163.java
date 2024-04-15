 public synchronized CDOChangeSetData merge(CDOChangeSet target, CDOChangeSet sou{  if (!conflicts.isEmpty())     {  throw new ConflictException(this);     }  return result; } 
