  request() .get(EXPORT_PATH + '/' + WORKSPACE_ID + '/project/exportSample.zip')  .expect(200)  .end(done)  //TODO extract and confirm zip?  }
