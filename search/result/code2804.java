  DataStore result = dataStore; if (dataStoreList.size() > 1) {  PopupMenu popupMenu = new PopupMenu(dataStoreList, labelProvider);  boolean b = popupMenu.show(Display.getCurrent().getActiveShell());  if (b) {  result = (DataStore) popupMenu.getResult(); 					} 				}  if (result == dataStore) { // the new one  mh.addRootElement(dataStore);  ModelUtil.setID(dataStore);  dataStore.setName(oldName);  bo.setName(dataStore.getName()); 				} else  bo.setName(result.getName() + " Ref");  bo.setDataStoreRef(result);  ModelUtil.setID(bo, mh.getResource());  putBusinessObject(context, bo); 			} catch (IOException e) {  Activator.showErrorWithLogging(e); 			}
