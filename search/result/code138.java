 public static CDOCheckout getCheckout(Object object){  CDOView view = (CDOView)object;  if (view.isClosed())       {  return null;       }  return (CDOCheckout)view.properties().get(CDOCheckoutImpl.CHECKOUT_KEY); } 
