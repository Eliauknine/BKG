  return clone.getRepo(req) .then(function(_repo) {  repo = _repo;  fileDir = api.join(fileRoot, repo.workdir().substring(req.user.workspaceDir.length + 1));  return git.Remote.create(repo, req.body.Remote, req.body.RemoteURI);  })  .then(function(remote) { } }
