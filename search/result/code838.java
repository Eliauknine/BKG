   */ public AbstractComparisonViewer createComparisonViewer(Composite parent_p,  IActionBars actionBars_p) {  ComparisonViewer result = doCreateComparisonViewer(parent_p, actionBars_p);  ILabelProvider customLP = getCustomLabelProvider();  if (customLP != null)  result.setDelegateLabelProvider(customLP);  return result;   } 
