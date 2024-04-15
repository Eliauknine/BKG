 public void setConflict(InternalCDOObject object){   { ConflictEvent event = new ConflictEvent(object, conflict == 0);     ++conflict;  fireEvent(event);   }  /** } 
