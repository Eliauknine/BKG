 	 * @return the x coordinate	 */  private int getRelativeToDiagramX(Shape shape) {  int ret = 0;  if (!(shape instanceof ConnectionDecorator)) {  while (shape != null && !(shape instanceof Diagram)) {  ret = ret + getXOfPictogramElement(shape);  shape = shape.getContainer(); 			} 		} else { } } }
