 public Object[] getChildren(Object element){  else        {  Object childElement = child.getElement();  if (!LifecycleUtil.isActive(childElement))           {  it.remove();  child.dispose(); } } } 
