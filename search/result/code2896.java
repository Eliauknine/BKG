	 */ @Override  public String getText(Object object) {  final VTableColumn tableColumn = (VTableColumn) object;  return getString("_UI_TableColumn_type") + " " + tableColumn.isReadOnly(); 	} 
