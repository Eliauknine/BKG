  clone.getRepo(req) .then(function(_repo) {  repo = _repo;  fileDir = api.join(fileRoot, repo.workdir().substring(req.user.workspaceDir.length + 1));  if (mergeBase) {  var names = scope.split("..");  var commit0, commit1,mergeBaseCommitOid; } } }
