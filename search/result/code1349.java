 public boolean validateFeaturePathDomainModelReference_resolveable({  VFeaturePathDomainModelReference featurePathDomainModelReference, DiagnosticChain diagnostics,  Map<Object, Object> context) {  // Do not validate feature dmrs witch are contained in another dmr,  // as normally specific logic is applied for them  if (VDomainModelReference.class.isInstance(featurePathDomainModelReference.eContainer())) {  return true; 		}  if (featurePathDomainModelReference.getDomainModelEFeature() == null) {  if (featurePathDomainModelReference.eContainer() != null) {  diagnostics } } } } 
