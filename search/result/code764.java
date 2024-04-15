  this.isModified = true;}; Prefs.prototype.delete = function(path) {  this.set(path, NOT_EXIST); }; Prefs.prototype.getJson = function() {  return this.json; }
