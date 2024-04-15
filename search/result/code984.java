  module.exports.isWorkspace = isWorkspace;  module.exports.getSignature = getSignature;  module.exports.getCommit = getCommit;  return express.Router()  .use(bodyParser.json()) }
