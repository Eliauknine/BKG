  initDrop(); 	}  private void initDrag() {  new DLTKViewerDragSupport(fViewer).start(); 	}  private void initDrop() {  DLTKViewerDropSupport dropSupport = new DLTKViewerDropSupport(fViewer);  dropSupport.addDropTargetListener(new WorkingSetDropAdapter(this));  dropSupport.start(); }
