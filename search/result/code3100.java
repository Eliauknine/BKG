 public void testNotUsingXATransaction_Exception() throws Exception{  try       {  transactionA.commit();  fail("CommitException expected");       }  catch (CommitException expected) } 
