 public void dispose(){  if (((CDOEditorInput)getEditorInput()).isViewOwned())     {  view.close();     }  super.dispose(); } 
