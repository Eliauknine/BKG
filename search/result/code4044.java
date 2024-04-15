 public void rollback(IView view, ITransaction<IStoreWriter> storeTransaction){   { try     {  connection.rollback();     }  catch (SQLException ex) } } 
