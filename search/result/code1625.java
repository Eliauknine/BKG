 protected void createTableViewer(Composite parent) { super.createTableViewer(parent);  final TableViewerColumn roleColumnViewer = new TableViewerColumn(getTableViewer(), SWT.NONE);  roleColumnViewer.getColumn().setText(Messages.ProjectComposite_Role);  roleColumnViewer.getColumn().setWidth(120);  roleColumnViewer.setLabelProvider(new ColumnLabelProvider() {  @Override  public String getText(Object element) { } } } 
