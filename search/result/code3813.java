 public synchronized EList<Adapter> eAdapters(){  @Override  protected void didAdd(int index, Adapter newObject)         {  if (!FSMUtil.isTransient(CDOObjectImpl.this))           {  cdoView().subscribe(CDOObjectImpl.this, newObject); } } } 
