 public void visit(CDOSetFeatureDelta delta)  {  EStructuralFeature feature = delta.getFeature();  Object oldValue = getOldValue(feature);  if (oldValue instanceof CDOID)     {  CDOID oldID = (CDOID)oldValue; } } 
