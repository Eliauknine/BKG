        .getVersion(), index, CDOIDUtil.getLong(targetId));  }  public final void updateRevised(CDORevision revision, IClassMapping classMapping)   {  doUpdateRevised(classMapping.getTable().getName(), revision.getCreated() - 1, CDOIDUtil.getLong(revision.getID()),  revision.getVersion() - 1);   }  public final void updateRevised(CDOID id, long revised, IClassMapping classMapping)   {  doUpdateRevised(classMapping.getTable().getName(), revised, CDOIDUtil.getLong(id));   
