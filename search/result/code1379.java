 define(['i18n!orion/navigate/nls/messages', 'orion/webui/littlelib', 'orion/i18n{  var createFunction = function(name) { if (name) {  var location = parentItem.Location;  var functionName = isDirectory ? "createFolder" : "createFile";  var deferred = fileClient[functionName](location, name, {select: true});  progressService.showWhile(deferred, i18nUtil.formatMessage(messages["Creating ${0}"], name)).then( } } } 
