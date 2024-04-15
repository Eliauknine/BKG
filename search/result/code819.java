  if (process.platform === 'darwin') { if (!Menu.getApplicationMenu()) {  var template = [{  label: electron.app.getName(),  submenu: [  {role: 'about'},  { type: "separator" }, } } } }
