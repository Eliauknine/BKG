 @Override public void pageSelectedNotify() throws ProcessingException {  if (m_rowSelectionRequired) {  selectPageTableRowIfNecessary(getPageTableField().getTable());  m_rowSelectionRequired = false;     }   } 
