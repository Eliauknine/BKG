  } event.preventDefault();  nextWindow.webContents.send('collect-tabs-info','closeorion');   ipcMain.on("collected-tabs-info-closeorion", function(event, args){  updateLastOpendTabsPrefs(args);  exit();  }
