  if (p != null) { ID id = p.getID();  if (id != null) {  appendText(getOutputText(), new ChatLine(NLS.bind(  Messages.ChatRoomManagerView_ENTERED_MESSAGE,  getUsernameFromID(id)), null));  chatRoomParticipantViewer.add(p); 				} 			} }
