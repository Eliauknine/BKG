  @Override protected void buttonPressed(int id) {  if (id == IDialogConstants.OK_ID || id == IDialogConstants.CANCEL_ID) {  ScopedPreferenceStore store = new ScopedPreferenceStore(ConfigurationScope.INSTANCE,  IKernelPreferences.KERNEL_PREFERENCES_ID);  store.setValue(MODEL_VALIDATION_ON_LAUNCH, !dontValidateAnymoreBeforeLaunchButton);  try {  store.save(); 			} catch (IOException e) {  e.printStackTrace(); 			} 		} } }
