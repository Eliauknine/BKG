      * @return whether the string matches the pattern     */  private boolean match(String string) {  if (matcher == null) {  return true;         }  return matcher.match(string);     }  /** }
