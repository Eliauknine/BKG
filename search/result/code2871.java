			}		});  textWidget.addVerifyListener(new VerifyListener() {  public void verifyText(VerifyEvent e) {  fDelayedExecutor.schedule(new Runnable() {  public void run() {  // When we leave the current input  Object oldInput = getInput();  if (oldInput instanceof CompareInputAdapter) {  final AttributeChange diff = (AttributeChange)((CompareInputAdapter)oldInput) 									.getComparisonObject();  final EAttribute eAttribute = diff.getAttribute();  final Match match = diff.getMatch();  final IEqualityHelper equalityHelper = match.getComparison().getEqualityHelper();  updateModel(diff, eAttribute, equalityHelper, match.getLeft(), true);  updateModel(diff, eAttribute, equalityHelper, match.getRight(), false); 						} 					} 				}); 			} 		
