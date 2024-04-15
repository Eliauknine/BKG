 public Object[] getChildren(Object element){  if (element instanceof CDOResourceFolder)     {  return ((CDOResourceFolder)element).getNodes().toArray();     }  return super.getChildren(element); } 
