 public void widgetSelected( SelectionEvent e ){  protected void handleAddEvent( ) 	{  DataItemSelfBindingDialog dialog = new DataItemSelfBindingDialog( );  dialog.setInput( inputElement );  dialog.setExpressionProvider( expressionProvider );  if ( dialog.open( ) == Dialog.OK ) } } 
