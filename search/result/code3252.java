  return null;	}  private MPerspective getCurrentPerspective() {  MPerspectiveStack stack = getPerspectiveStack();  return stack == null ? null : stack.getSelectedElement(); 	}
