 function putIndex(req, res) {  var index, repo;  var filePath = path.join(req.user.workspaceDir, req.params["0"]);  return clone.getRepo(req)  .then(function(_repo) {  repo = _repo;  filePath = api.toURLPath(filePath.substring(repo.workdir().length));  return repo.refreshIndex();  })  .then(function(indexResult) { } } }
