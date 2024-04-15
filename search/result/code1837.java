  composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));  composite.setLayout(gridLayout);  final String input = fInputCombo.getText() + ' ';  int inputLength = input.length();  int textStartPosition = 0;  int textEndPosition = inputLength - 1;  int caretPosition = fInputCombo.getCaretPosition();  for (int i = caretPosition; i >= 0; i--) {  if (input.charAt(i) == ' ') {  textStartPosition = i;  break; 			} 		}  for (int j = caretPosition; j < inputLength; j++) {  if (input.charAt(j) == ' ' || input.charAt(j) == '(') {  textEndPosition = j;  break; 			} 		}  final String selectedText = input.substring(textStartPosition, textEndPosition);  fBrowser = new Browser(composite, SWT.NONE);  // calculate toolTipText using selected text  final String toolTipText = EditorToolTipGenerator.getToolTipText(selectedText.trim());  final String theText = "<html>" + toolTipText + "</html>";  fBrowser.setText(theText); }
