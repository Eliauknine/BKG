  // Prepare for CreateChild item addition or removal.  //  createChildMenuManager = new MenuManager(DocumentstructuretemplateEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"));   submenuManager.insertBefore("additions", createChildMenuManager);   // Prepare for CreateSibling item addition or removal.  //  createSiblingMenuManager = new MenuManager(DocumentstructuretemplateEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"));   submenuManager.insertBefore("additions", createSiblingMenuManager);   // Force an update because Eclipse hides empty menus now. }
