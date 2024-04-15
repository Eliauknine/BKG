  } }  autoUpdater.on("error", function(error) {  console.log(error);  });  autoUpdater.on("update-available-automatic", function(newVersion) {  if (platform === "linux" && !linuxDialog) { }
