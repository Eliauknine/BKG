  // Lazy create the menu. ToolBar toolbar = ((ToolItem) toolItem).getParent();  int style = toolbar.getStyle() 					& (SWT.RIGHT_TO_LEFT | SWT.LEFT_TO_RIGHT);  menu = new Menu(shell, style | SWT.POP_UP);  for (int i = 0; i < 9; ++i) {  final String text = "Drop Down " + i; } }
