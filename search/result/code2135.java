 protected void initializeCellEditorValue(CellEditor cellEditor, ViewerCell cell){  final IObservableValue target = doCreateCellEditorObservable(cellEditor); Assert.isNotNull(target, "doCreateCellEditorObservable(...) did not return an observable");   final IObservableValue model = doCreateElementObservable(cell.getElement(), cell);  Assert.isNotNull(model, "doCreateElementObservable(...) did not return an observable");   final Binding binding = createBinding(target, model); } 
