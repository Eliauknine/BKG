 private void depopulateRevisionFeature(CDOViewImpl view, InternalCDORevision rev{  if (eFeature.isMany())    {  eSettings[i] = null;  List<Object> setting = (List<Object>)super.dynamicGet(eFeature.getFeatureID());  int size = eStore().size(this, eFeature);  for (int index = 0; index < size; index++)       {  setting.add(eStore().get(this, eFeature, index));       }     }  else } 
