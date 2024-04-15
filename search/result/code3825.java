 protected boolean successful(){  trans2.rollback();  assertEquals(CDOState.INVALID, CDOUtil.getCDOObject(res2).cdoState());  try     { } } 
