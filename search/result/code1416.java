  filePath = path.dirname(filePath); if (filePath.length <= workspaceDir) return Promise.reject(new Error("Forbidden"));  }  return git.Repository.discover(filePath, 0, workspaceDir).then(function(buf) {  return git.Repository.open(buf.toString());  }); }  function getRepo(req) {  var u = url.parse(req.url, true);  var restpath = u.pathname.split(fileRoot)[1];  if (!restpath) return Promise.reject(new Error("Forbidden"));  var filePath = path.join(req.user.workspaceDir, restpath);  return getRepoByPath(filePath,req.user.workspaceDir); } function getClone(req, res) {  getClones(req, res, function(repos) {  res.status(200).json({ } }
