 define([{  if(!this.model || !loc) {  return null;  }  var elementId = this.model.getId({Location: loc});  var elementNode = lib.node(elementId);  return elementNode ? elementNode._item : null;  },  handleResourceChange: function(evt) {  if(!this.model) { } } 
