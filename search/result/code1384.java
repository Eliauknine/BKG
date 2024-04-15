  return clone.getRepo(req) .then(function(_repo) {  repo = _repo;  return git.Stash.save(repo, git.Signature.default(repo), message, flags);  })  .then(function() {  res.status(200).end(); } }
