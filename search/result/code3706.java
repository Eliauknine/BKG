 public void testInvalidateAndCache() throws Exception{  transactionA.commit(); cdoidA = CDOUtil.getCDOObject(categoryA).cdoID();  transactionA.removeObject(cdoidA);     } 
