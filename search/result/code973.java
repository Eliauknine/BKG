 define([{  if (locationSession && locationSession.ETag === metadata.ETag) { editor.setSelections(locationSession.selections);  textView.setTopIndex(locationSession.topIndex, animate ? function() {} : undefined);  }  },  save: function() { } 
