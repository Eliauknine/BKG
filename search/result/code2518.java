 private void updateConnectionIfNeeded(DataAssociation association, ItemAwareElem{  List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, (EObject)value); for (PictogramElement p : pes) {  if (BusinessObjectUtil.getFirstElementOfType(p, BPMNShape.class)!=null) {  pe = p;  break; 					} 				} } 
