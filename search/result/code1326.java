 public static List<IType> getResolvedTypeParamValue(IType focusType, IType level{  if (levelType == null) { return Collections.emptyList();     }  IType item = levelType.typeArguments().get(typeParamIndex);  if (!item.isParameterType()) {  // direct bind  return Arrays.asList(item); } } 
