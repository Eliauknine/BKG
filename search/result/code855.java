 @Override  protected void modifySelection(CatalogItem connector, boolean selected) {  super.modifySelection(connector, selected); 	}  @Override  public void updateCatalog() {  List<CatalogItem> checkedItems = getCheckedItems();  for (CatalogItem catalogItem : checkedItems) {  modifySelection(catalogItem, false); 		}  super.updateCatalog();  updateButtonState(getSelection()); 	} 
