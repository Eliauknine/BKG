 innerText.setText(text.getText()); innerText.setSelection(text.getCaretOffset());  innerText.addFocusListener(new FocusListener() {  @Override  public void focusLost(FocusEvent e) { } }
