 public <P extends IProperty> P getProperty(  VFeaturePathDomainModelReference domainModelReference,  Class<P> propertyClass) {  VFeaturePathDomainModelReference subDMR = (VFeaturePathDomainModelReference)ModelReferenceHelper.createDomainModelReference(domainModelReference.getDomainModelEReferencePath().get(domainModelReference.getDomainModelEReferencePath().size()-1), domainModelReference.getDomainModelEReferencePath().subList(0, domainModelReference.getDomainModelEReferencePath().size()-1));  IValueProperty property=(IValueProperty) super.getProperty(subDMR, propertyClass);  final VIndexDomainModelReference indexDomainModelReference = (VIndexDomainModelReference) domainModelReference;  final EMFIndexedValueProperty valueProperty = new EMFIndexedValueProperty( } 
