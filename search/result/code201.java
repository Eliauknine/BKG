  withEventsViewer.setContentProvider(new EventContentProvider()); withEventsViewer.setLabelProvider(new EventLabelProvider());  Table tableWith = withEventsViewer.getTable();  configureTableLayout(tableWith);  tableWith.addListener(SWT.Selection, event -> {  if (event.detail == SWT.CHECK) {  TableItem checkedItem = (TableItem) event.item;  Event e = (Event) checkedItem.getData();  With with = e.getWith().stream().filter(w -> w.getVariables().equals(getType())).findFirst() 						.orElse(null);  if (checkedItem.getChecked()) {  if (null == with) { } } } } }
