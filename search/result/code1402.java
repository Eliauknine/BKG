  if(repo){ return Promise.resolve(getBranch(repo))  .then(function(branchname){  var workDir = api.join("/file", repo.workdir().substring(req.user.workspaceDir.length + 1), "/");  addGitLinks(workspacechild,branchname,workDir);  });  } }
