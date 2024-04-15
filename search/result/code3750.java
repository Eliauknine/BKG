 public DBStore()   {  super(TYPE, set(ChangeFormat.REVISION), set(RevisionTemporality.AUDITING), set(RevisionParallelism.NONE));  setRevisionTemporality(RevisionTemporality.AUDITING);   } 
