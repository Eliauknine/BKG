 public void testSimple() throws Exception  {  CDOSession session = openModel1Session();  CDOTransactionImpl transaction = (CDOTransactionImpl)session.openTransaction();  new CDOAutoAttacher(transaction);  CDOResource resource1 = transaction.getOrCreateResource("/test1");  Product1 product = getModel1Factory().createProduct1(); } 
