  .delete('/temp/:id', deleteOperation)  .get('/count', function(req, res/*, next*/) {  writeResponse(200, res, null, {"count": taskCount});  }); } function getTaskMeta(req, taskLocationOrKeep, taskId) {  var keep, id;  if (typeof taskLocationOrKeep === "string") {  // This is when req doesn't have enough information needed  keep = taskLocationOrKeep.startsWith("/id");  } else if (typeof taskLocationOrKeep === "boolean") {  keep = taskLocationOrKeep  } else {  keep = req.url.startsWith("/id")  }  return {  keep: keep, } }
