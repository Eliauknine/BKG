  return clone.getRepo(req) .then(function(repo) {  theRepo = repo;  fileDir = api.join(fileRoot, repo.workdir().substring(req.user.workspaceDir.length + 1));  return repo.getRemote(remoteName);  })  .then(function(remote) { } }
