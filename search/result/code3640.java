 /**   * @since 2.0    */  public void handleSyncResponse(long timestamp, Set<CDOIDAndVersion> dirtyOIDs, Collection<CDOID> detachedObjects)   {  handleCommitNotification(timestamp, dirtyOIDs, detachedObjects, null, null, true, false);   }  /**    * @since 2.0    */  public void handleCommitNotification(final long timeStamp, Set<CDOIDAndVersion> dirtyOIDs,  final Collection<CDOID> detachedObjects, final Collection<CDORevisionDelta> deltas, InternalCDOView excludedView)   {  handleCommitNotification(timeStamp, dirtyOIDs, detachedObjects, deltas, excludedView, options()         .isPassiveUpdateEnabled(), true);   }  private void handleCommitNotification(final long timeStamp, Set<CDOIDAndVersion> dirtyOIDs,  final Collection<CDOID> detachedObjects, final Collection<CDORevisionDelta> deltas, InternalCDOView excludedView,  final boolean passiveUpdate, boolean async)   {  if (passiveUpdate)     { } } 
