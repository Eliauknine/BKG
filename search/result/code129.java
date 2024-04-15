 else if (event instanceof ILifecycleEvent){  ILifecycleEvent e = (ILifecycleEvent)event; if (e.getKind() == Kind.DEACTIVATED)           {  removeView(view);           }         } 
