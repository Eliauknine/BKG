 protected List<IAttributeMapping> createAttributeMappings(CDOFeature[] features){  protected List<IReferenceMapping> createReferenceMappings(CDOFeature[] features)   {  List<IReferenceMapping> referenceMappings = new ArrayList();  for (CDOFeature feature : features)     {  if (feature.isReference() && feature.isMany()) } } } 
