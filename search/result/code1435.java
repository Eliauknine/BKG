 define([{  return that.updateWorkspacePrefs(folderLocation); }).then(function(){  delete sessionStorage.lastFile;  window.location.href = "/";  } 
