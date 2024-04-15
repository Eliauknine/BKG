 public static final class SingleValuedFeatures extends CDOUndoDetectorImpl  {  @Override  protected boolean ignore(EStructuralFeature feature)     {  return feature.isMany();     }   } 
