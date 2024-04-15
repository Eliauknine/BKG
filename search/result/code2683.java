  addUIScript((IStoredScript)scriptNotif.getNewValue());				} else if(Notification.REMOVE == scriptNotif.getEventType()) {  removeUIScript((IStoredScript)scriptNotif.getOldValue()); 				} 			}
