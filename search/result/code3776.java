 protected SignalReactor createSignalReactor(short signalID){  switch (signalID)    {  case CDOProtocolConstants.SIGNAL_OPEN_SESSION:  return new OpenSessionIndication();  case CDOProtocolConstants.SIGNAL_LOAD_LIBRARIES:  return new LoadLibrariesIndication();  case CDOProtocolConstants.SIGNAL_VIEWS_CHANGED:  return new ViewsChangedIndication();  case CDOProtocolConstants.SIGNAL_RESOURCE_ID:  return new ResourceIDIndication();  case CDOProtocolConstants.SIGNAL_LOAD_PACKAGE:  return new LoadPackageIndication();  case CDOProtocolConstants.SIGNAL_LOAD_REVISION:  return new LoadRevisionIndication();  case CDOProtocolConstants.SIGNAL_LOAD_REVISION_BY_TIME:  return new LoadRevisionByTimeIndication();  case CDOProtocolConstants.SIGNAL_LOAD_REVISION_BY_VERSION:  return new LoadRevisionByVersionIndication();  case CDOProtocolConstants.SIGNAL_LOAD_CHUNK:  return new LoadChunkIndication();  case CDOProtocolConstants.SIGNAL_VERIFY_REVISION:  return new VerifyRevisionIndication();  case CDOProtocolConstants.SIGNAL_COMMIT_TRANSACTION:  return new CommitTransactionIndication();  case CDOProtocolConstants.SIGNAL_COMMIT_TRANSACTION_PHASE1:  return new CommitTransactionPhase1Indication();  case CDOProtocolConstants.SIGNAL_COMMIT_TRANSACTION_PHASE2:  return new CommitTransactionPhase2Indication();  case CDOProtocolConstants.SIGNAL_COMMIT_TRANSACTION_PHASE3:  return new CommitTransactionPhase3Indication();  case CDOProtocolConstants.SIGNAL_COMMIT_TRANSACTION_CANCEL:  return new CommitTransactionCancelIndication();  case CDOProtocolConstants.SIGNAL_QUERY:  return new QueryIndication();  case CDOProtocolConstants.SIGNAL_QUERY_CANCEL:  return new QueryCancelIndication();  case CDOProtocolConstants.SIGNAL_SYNC:  return new SyncRevisionIndication();  case CDOProtocolConstants.SIGNAL_PASSIVE_UPDATE:  return new SetPassiveUpdateIndication();  case CDOProtocolConstants.SIGNAL_CHANGE_SUBSCRIPTION:  return new ChangeSubscriptionIndication();  case CDOProtocolConstants.SIGNAL_SET_AUDIT:  return new SetAuditIndication();  case CDOProtocolConstants.SIGNAL_REPOSITORY_TIME:  return new RepositoryTimeIndication();  default:  return null; } } 
