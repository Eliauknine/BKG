 	 *            The index of the notification in the list of initial notifications.	 * @return The notification to manage. 	 */  protected Notification getAddNotification(final Notification initialNotification, final List<Notification> managedNotifications, final int index){  Notification currentNotification = initialNotification;    if (NattableaxisPackage.eINSTANCE.getITreeItemAxis_Children() == currentNotification.getFeature()) {  if (currentNotification.getNotifier() instanceof ITreeItemAxis && (null == ((EObject) currentNotification.getNotifier()).eContainer() || (((EObject) currentNotification.getNotifier()).eContainer()) instanceof AbstractAxisProvider)) {  currentNotification = null; 			} 		}    return currentNotification;  	}  /** 	 * This allow to get the move notification from the initial remove notification. This one will be managed as move (because the move does not exist in GMD command (replaced by add and remove)). 	 *  	 * @param initialNotification 	 *            The initial remove notification. 	 * @param managedNotifications }
