 private void editingDomainChange(ICompareEditingDomain oldValue, ICompareEditing{ 	} private void refreshTitle() {  // TODO Make sure this is called as little as possible  // Or make this asynchronous?  if (getControl().isDisposed() || !(getControl().getParent() instanceof CompareViewerSwitchingPane)) {  return; 		} } 
