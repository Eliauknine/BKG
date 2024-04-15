 public void writePackages(CDOPackageImpl... cdoPackages){     } Set<IDBTable> affectedTables = mapPackages(cdoPackages);  store.getDBAdapter().createTables(affectedTables, connection);   } 
