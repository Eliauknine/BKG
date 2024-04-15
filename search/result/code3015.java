  private Message getMessage(String text, Position curr, InterfaceItem item, boolean outgoing) { proceedToToken(text, curr);  if (text.charAt(curr.pos)!='.')  return null; 		++curr.pos; } }
