 private CompoundCommand constructDependencyEnd(CompoundCommand command, Dependen{  NamedElement currentEnd = iteratorProp.next(); // look for if an editpart exist for this element  Collection<?> values = viewer.getEditPartRegistry().values();  Collection<EditPart> editPartSet = new ArrayList<EditPart>();  for (Object val : values) {  if (val instanceof EditPart) 				{ } } } 
