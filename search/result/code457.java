 @Override  public ImageDescriptor getImageDescriptor(Object element, int columnIndex) {  if (element instanceof LicensingRequirement) {  LicensingRequirement requirement = (LicensingRequirement) element;  Iterable<RestrictionVerdict> restrictions = getRestrictions(requirement.getFeatureIdentifier());  String imageKey = RestrictionRepresenters.resolveImageKey(restrictions);  switch (columnIndex) {  case INDEX_STATUS: } } } 
