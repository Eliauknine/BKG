 public void testTableWithTwoColumnsClear() throws NoRendererFoundException, NoPr{  final AbstractSWTRenderer<VElement> tableRenderer = rendererFactory.getRenderer(handle.getTableControl(), new ViewModelContextWithoutServices(handle.getTableControl()));  final Control control = tableRenderer.render(new GridCell(0, 0, tableRenderer), shell);  if (control == null) {  fail("No control was rendered"); 		} } 
