 private void detachResource(ResourceSet rset, CDOResource resource) throws Excep{  Assert.assertEquals(0, rset.getResources().size()); assertTransient(order);  assertTransient(orderDetail);  assertEquals(1, CDOUtil.getViewSet(rset).getViews().length);  assertEquals(0, rset.getResources().size());  assertEquals(true, resource.getContents().contains(order));  assertEquals(true, order.getOrderDetails().contains(orderDetail));   } 
