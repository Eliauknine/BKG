 public void testMergeLocalChangesPerFeature_Basic() throws Exception{  transaction.commit(); CDOTransaction transaction2 = session.openTransaction();  transaction2.options().getConflictResolvers().add(new MergeLocalChangesPerFeature());  Address address2 = (Address)transaction2.getOrCreateResource("/res1").getContents().get(0);  address2.setCity("OTTAWA"); } 
