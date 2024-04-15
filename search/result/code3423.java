 public void detachObject(InternalCDOObject object){  if (!dirty)    {  dirty = true;  fireEvent(new StartedEvent());     }   } 
