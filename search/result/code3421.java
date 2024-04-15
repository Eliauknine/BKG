 private void registerNew(Map map, InternalCDOObject object){  if (!dirty)    {  dirty = true;  fireEvent(new StartedEvent());     }   } 
