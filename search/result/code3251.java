  private final static String[] EMPTY_STRING_ARRAY = new String[0]; private String[] getArrayForTag(String tagPrefix) {  MPerspective perspective = getPerspectiveStack().getSelectedElement();  if (perspective == null) {  return EMPTY_STRING_ARRAY; 		}  List<String> id = ModeledPageLayout.getIds(perspective, tagPrefix);  if (id.size() == 0) {  return EMPTY_STRING_ARRAY; 		}  return id.toArray(new String[id.size()]); 	}  /* }
